<template>
    <div class="addProject">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-row :gutter="20">
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addFormData1" label="产品编码：">
                            <el-input clearable class="input_right" placeholder="请输入产品编码" v-model="addForm.addFormData1" disabled></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData2" label="产品名称：">
                            <el-input clearable class="input_right" placeholder="请输入产品名称" v-model="addForm.addFormData2" disabled></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData3" label="产品规格：">
                            <el-select clearable class="input_right" placeholder="请选择产品规格" v-model="addForm.addFormData3" disabled>
                                <el-option label="药用级" value="药用级"></el-option>
                                <el-option label="工业级" value="工业级"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData4" label="标准编号：">
                            <el-input clearable class="input_right" placeholder="请输入标准编号" v-model="addForm.addFormData4" :disabled="isdisabled"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addFormData5" label="增录人：">
                            <el-input clearable class="input_right" placeholder="请输入增录人" v-model="addForm.addFormData5" :disabled="isdisabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData6" label="录入时间：">
                            <el-date-picker type="date" class="input_right" placeholder="请选择录入时间" v-model="addForm.addFormData6" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                        </el-form-item>
                        <el-form-item class="formList"></el-form-item>
                        <el-form-item class="formList" prop="addFormData7" label="版本：">
                            <el-input clearable class="input_right" placeholder="请输入版本" v-model="addForm.addFormData7" :disabled="isdisabled"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <div class="mine-add" v-show="!isdisabled">
                    <span class="el-icon-circle-plus" @click="addTable"></span>
                    <span class="el-icon-remove-outline" @click.stop="deleteTable"></span>
                </div>
                <span class="form_left">标准明细：</span>
                <div class="tableList">
                    <table border="1">
                        <tr>
                            <th width="50"></th><th>检项名称</th><th>质量标准</th><th>方法名称</th><th>方法编号</th><th>方法属性</th><th>工时</th>
                        </tr>
                        <tr class="add_Table" v-for="(item, index) in tableData"  :key="index">
                            <td>
                                <span class="checkStyle" @click="checkList(index)" v-show="!isdisabled">
                                    <i class="el-icon-check" v-show="item.list"></i>
                                    <i class="no-check" v-show="!item.list"></i>
                                </span>
                                <span class="checkStyle" v-show="isdisabled">
                                    <i class="no-check"></i>
                                </span>
                            </td>
                            <td><el-input clearable v-model="item.table1" placeholder="" :disabled="isdisabled"></el-input></td>
                            <td><el-input clearable v-model="item.table2" placeholder="" :disabled="isdisabled"></el-input></td>
                            <td><el-input clearable v-model="item.table3" placeholder="" :disabled="isdisabled"></el-input></td>
                            <td><el-input clearable v-model="item.table4" placeholder="" :disabled="isdisabled"></el-input></td>
                            <td><el-input clearable v-model="item.table5" placeholder="" :disabled="isdisabled"></el-input></td>
                            <td><el-input clearable v-model="item.table6" placeholder="" :disabled="isdisabled"></el-input></td>
                        </tr>
                    </table>
                </div>
            </el-form>
        </div>
    </div>
</template>
<script>
export default {
    props: ['title'],
    data () {
        return {
            isdisabled: false,
            tableData:[
                { list:false,table1: '',table2: '',table3:'',table4: '',table5: '',table6:'' },
            ],
            addForm: {
                addFormData1: 'E010232',
                addFormData2: '聚山梨酯20',
                addFormData3: '药用级',
                addFormData4: '',
                addFormData5: '',
                addFormData6: '',
                addFormData7: '',
            },
            rules: {
				addFormData1: [
					{ required: true, message: "请输入产品编码", trigger: "blur", },
				],
				addFormData2: [
					{ required: true, message: "请输入产品名称", trigger: "blur", },
				],
				addFormData3: [
					{ required: true, message: "请选择产品规格", trigger: "change",},
				],
				addFormData4: [
					{ required: true, message: "请输入标准编号", trigger: "blur", },
				],
				addFormData5: [
					{ required: true, message: "请输入增录人", trigger: "blur" },
				],
				addFormData6: [
					{ required: true, message: "请选择录入时间", trigger: "change", },
				],
				addFormData7: [
					{ required: true, message: "请输入版本", trigger: "blur", },
				],
            },
        }
    },
    methods: {
        addTable(){//增加table
            this.tableData.push({ list:false,table1: '',table2: '',table3:'',table4: '',table5: '',table6:'' })
        },
        checkList(index){
            this.tableData[index].list = !this.tableData[index].list;
        },
        deleteTable(){//删除table
            if(this.tableData.length == 1){
                this.$message.warning('不能少于一列!');
                return false
            }else{
                this.tableData = this.tableData.filter(e => {
                    return !e.list
                })
            }
        },
        setFormData(formName){
            let formdata = {
                ...this.addForm,
                'tableData': [...this.tableData]
            }
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.$emit('addForm',formdata)
                }else {
                    return false
                }
            })
        },
    },
    mounted() {
        if(this.title == '查看') {
            this.isdisabled = true
        }else {
            this.isdisabled = false
        }
    },
    components: {
    }
}
</script>

<style scoped lang="scss">
    @import "@/assets/style/dialog.scss";
    .form_left {
        width: 72px;
        height: 32px;
        line-height: 32px;
        text-align: right;
        display: inline-block;
        color: #606266;
        margin-top: 10px
    }
    .tableList {
        margin-top: 0px !important;
    }
</style>
