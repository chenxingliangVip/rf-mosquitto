<template>
    <div class="addProject">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-row :gutter="20">
                    <el-col :span="12" class="left_color">
                        <el-form-item class="formList" prop="addFormData1" label="产品编码：">
                            <el-input clearable class="input_right" placeholder="请输入产品编码" v-model="addForm.addFormData1"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData2" label="产品名称：">
                            <el-input clearable class="input_right" placeholder="请输入产品名称" v-model="addForm.addFormData2"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData3" label="产品规格：">
                            <el-select clearable class="input_right" placeholder="请选择产品规格" v-model="addForm.addFormData3">
                                <el-option label="药用级" value="药用级"></el-option>
                                <el-option label="工业级" value="工业级"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData4" label="批次号：">
                            <el-input clearable class="input_right" placeholder="请输入批次号" v-model="addForm.addFormData4"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData5" label="阶段：">
                            <el-select clearable class="input_right" placeholder="请选择阶段" v-model="addForm.addFormData5">
                                <el-option label="M1" value="M1"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData6" label="检测数量：">
                            <el-input clearable class="input_right" placeholder="请输入检测数量" v-model="addForm.addFormData6"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addFormData7" label="检验号：">
                            <el-input clearable class="input_right" placeholder="请输入检验号" v-model="addForm.addFormData7"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData8" label="申请人：">
                            <el-input clearable class="input_right" placeholder="请输入申请人" v-model="addForm.addFormData8"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData9" label="申请时间：">
                            <el-date-picker type="date" class="input_right" placeholder="请选择申请时间" v-model="addForm.addformdata9" value-format="yyyy-MM-dd"></el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
                <div class="mine-add">
                    <span class="el-icon-circle-plus" @click="addTable"></span>
                    <span class="el-icon-remove-outline" @click.stop="deleteTable"></span>
                </div>
                <div class="tableList">
                    <table border="1">
                        <tr>
                            <th width="50"></th><th>检项名称</th><th>质量标准</th><th>检验结果</th>
                        </tr>
                        <tr class="add_Table" v-for="(item, index) in tableData"  :key="index">
                            <td>
                                <span class="checkStyle" @click="checkList(index)">
                                    <i class="el-icon-check" v-show="item.list"></i>
                                    <i class="no-check" v-show="!item.list"></i>
                                </span>
                            </td>
                            <td><el-input clearable v-model="item.table1" placeholder=""></el-input></td>
                            <td><el-input clearable v-model="item.table2" placeholder=""></el-input></td>
                            <td><el-input clearable v-model="item.table3" placeholder=""></el-input></td>
                        </tr>
                    </table>
                </div>
            </el-form>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            tableData:[
                { list:false,table1: '',table2: '',table3:''},
            ],
            addForm: {
                addFormData1: 'E010232',
                addFormData2: '聚山梨酯20',
                addFormData3: '药用级',
                addFormData4: 'P191212022',
                addFormData5: 'M2',
                addFormData6: '2',
                addFormData7: 'T1900001',
                addFormData8: '张三',
                addFormData9: '2020-08-22',
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
					{ required: true, message: "请输入批次号", trigger: "change", },
				],
				addFormData5: [
					{ required: true, message: "请选择阶段", trigger: "change" },
				],
				addFormData6: [
					{ required: true, message: "请输入检测数量", trigger: "change", },
				],
				addFormData7: [
					{ required: true, message: "请输入检验号", trigger: "change", },
				],
				addFormData8: [
					{ required: true, message: "请输入申请人", trigger: "blur" },
				],
				addFormData9: [
					{ required: true, message: "请选择申请时间", trigger: "change", },
				],
            },
        }
    },
    methods: {
        addTable(){//增加table
            this.tableData.push({ list:false,table1: '',table2: '',table3:''})
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
        
    },
    components: {
    }
}
</script>

<style scoped lang="scss">
    @import "@/assets/style/dialog.scss";
</style>
