<template>
    <div class="addProject">
        <div class="addForm zll-form">
            <div class="formList">
                <gantt-chart :sourceData="sourceData"></gantt-chart>
                <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                    <el-row :gutter="20">
                        <el-col :span="8">
                            <el-form-item class="formList" prop="addFormData1" label="产品编码：">
                                <el-input clearable class="input_right" placeholder="请输入产品编码" v-model="addForm.addFormData1" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData2" label="产品名称：">
                                <el-input clearable class="input_right" placeholder="请输入产品名称" v-model="addForm.addFormData2" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData3" label="产品规格：">
                                <el-select clearable class="input_right" placeholder="请选择产品规格" v-model="addForm.addFormData3" :disabled="isdisabled">
                                    <el-option label="药用级" value="药用级"></el-option>
                                    <el-option label="工业级" value="工业级"></el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="16">
                            <div class="mine-add" v-if="titleTxt !== '查看'">
                                <span class="el-icon-circle-plus" @click="addTable"></span>
                                <span class="el-icon-remove-outline" @click.stop="deleteTable"></span>
                            </div>
                            <div class="tableList">
                                <table border="1">
                                    <tr>
                                        <th width="50"></th><th>类型</th><th>订单号</th><th>订单量（吨）</th><th>待排产量</th>
                                    </tr>
                                    <tr class="add_Table" v-for="(item, index) in tableData"  :key="index">
                                        <td>
                                            <span class="checkStyle" @click="checkList(index)" v-if="titleTxt !== '查看'">
                                                <i class="el-icon-check" v-show="item.list"></i>
                                                <i class="no-check" v-show="!item.list"></i>
                                            </span>
                                            <span class="checkStyle" v-else>
                                                <i class="no-check"></i>
                                            </span>
                                        </td>
                                        <td>
                                            <el-select clearable v-model="item.table1" placeholder="" :disabled="isdisabled"> 
                                                <el-option label="销售" value="销售"></el-option>
                                                <el-option label="自备" value="自备"></el-option>
                                            </el-select>
                                        </td>
                                        <td><el-input clearable v-model="item.table2" placeholder="" :disabled="isdisabled"></el-input> </td>
                                        <td><el-input clearable v-model="item.table3" placeholder="" :disabled="isdisabled"></el-input></td>
                                        <td><el-input clearable v-model="item.table4" placeholder="" :disabled="isdisabled"></el-input></td>
                                    </tr>
                                </table>
                            </div>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20" style="margin-top: 15px">
                        <el-col :span="8">
                            <el-form-item class="formList" prop="addFormData4" label="产线：">
                                <el-select clearable class="input_right" placeholder="请选择产线" v-model="addForm.addFormData4" :disabled="isdisabled">
                                    <el-option label="T1" value="T1"></el-option>
                                    <el-option label="T2" value="T2"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData5" label="部门：">
                                <el-select clearable class="input_right" placeholder="请选择部门" v-model="addForm.addFormData5" :disabled="isdisabled">
                                    <el-option label="销售一部" value="销售一部"></el-option>
                                    <el-option label="销售二部" value="销售二部"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData6" label="开始日期：">
                                <el-date-picker type="date" placeholder="请选择开始日期" v-model="addForm.addFormData6" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData7" label="结束日期：">
                                <el-date-picker type="date" placeholder="请选择结束日期" v-model="addForm.addFormData7" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item class="formList" prop="addFormData8" label="计划人：">
                                <el-input clearable class="input_right" placeholder="请输入计划人" v-model="addForm.addFormData8" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData9" label="计划日期：">
                                <el-date-picker type="date" placeholder="请选择计划日期" v-model="addForm.addFormData9" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData10" label="状态：">
                                <el-select clearable class="input_right" placeholder="请选择状态" v-model="addForm.addFormData10" :disabled="isdisabled">
                                    <el-option label="待提交" value="待提交"></el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item class="formList" prop="addFormData11" label="审核人：">
                                <el-input clearable class="input_right" placeholder="请输入审核人" v-model="addForm.addFormData11" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData12" label="审核日期：">
                                <el-date-picker type="date" placeholder="请选择审核日期" v-model="addForm.addFormData12" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                            <el-form-item class="formList" prop="addFormData13" label="审核意见：">
                                <el-input clearable type="textarea" class="input_right" placeholder="请输入审核意见" v-model="addForm.addFormData13" :disabled="isdisabled"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script>
import GanttChart from '@/components/GanttChart/index'
export default {
    props: ['titleTxt'],
    data () {
        return {
            isdisabled: false,
            sourceData: {
                startDate: '2020-01-01',
                endDate: '2020-01-31',
                data: [{
                        formType: "T1",
                        value: [
                            {
                                fromDate: "2020-01-01",
                                toDate: "2020-01-06",
                            },
                            {
                                fromDate: "2020-01-10",
                                toDate: "2020-01-11",
                            },
                            {
                                fromDate: "2020-01-15",
                                toDate: "2020-01-16",
                            },
                        ],
                    }
                ],
            },
            tableData:[
                { list:false,table1: '',table2: '',table3:'',table4: ''},
            ],
            addForm: {
                addFormData1: '',
                addFormData2: '',
                addFormData3: '',
                addFormData4: '',
                addFormData5: '',
                addFormData6: '',
                addFormData7: '',
                addFormData8: '',
                addFormData9: '',
                addFormData10: '',
                addFormData11: '',
                addFormData12: '',
                addFormData13: '',
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
					{ required: true, message: "请选择产线", trigger: "change", },
				],
				addFormData5: [
					{ required: true, message: "请选择部门", trigger: "change" },
				],
				addFormData6: [
					{ required: true, message: "请选择开始日期", trigger: "change", },
				],
				addFormData7: [
					{ required: true, message: "请选择结束日期", trigger: "change", },
				],
				addFormData8: [
					{ required: true, message: "请输入计划人", trigger: "blur" },
				],
				addFormData9: [
					{ required: true, message: "请选择计划日期", trigger: "change", },
				],
				addFormData10: [
					{ required: true, message: "请选择状态", trigger: "change" },
				],
				addFormData11: [
					{ required: true, message: "请输入审核人", trigger: "blur" },
				],
				addFormData12: [
					{ required: true, message: "请选择审核日期", trigger: "change", },
				],
				addFormData13: [
					{ required: true, message: "请输入审核意见", trigger: "blur" },
				],
            },
        }
    },
    methods: {
        addTable(){//增加table
            this.tableData.push({ list:false,table1: '',table2: '',table3:'',table4: ''})
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
        if(this.titleTxt == '查看') {
            this.isdisabled = true
        }else {
            this.isdisabled = false
        }
    },
    components: {
        GanttChart
    }
}
</script>

<style scoped lang="scss">
    @import "@/assets/style/dialog.scss";
</style>
