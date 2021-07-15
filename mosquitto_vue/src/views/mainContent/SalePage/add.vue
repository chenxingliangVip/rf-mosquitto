<template>
    <div class="addProject">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-row :gutter="20">
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addformdata1" label="客户名称：">
                            <el-input clearable class="input_right" placeholder="请输入客户名称" v-model="addForm.addformdata1"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata2" label="订单日期：">
                            <el-date-picker type="date" class="input_right" placeholder="请选择订单日期" v-model="addForm.addformdata2"></el-date-picker>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata3" label="订单号：">
                            <el-input clearable class="input_right" placeholder="请输入订单号" v-model="addForm.addformdata3"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item class="formList"></el-form-item>
                        <el-form-item class="formList" prop="addformdata4" label="部门：">
                            <el-select clearable class="input_right" placeholder="请选择部门" v-model="addForm.addformdata4">
                                <el-option label="销售一部" value="销售一部"></el-option>
                                <el-option label="销售二部" value="销售二部"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata5" label="销售人：">
                            <el-select clearable class="input_right" placeholder="请选择销售人" v-model="addForm.addformdata5">
                                <el-option label="张三" value="张三"></el-option>
                                <el-option label="李四" value="李四"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <div class="tableList">
                    <table border="1">
                        <tr>
                            <th>产品名称</th><th>产品编码</th><th>产品规格</th><th>订单量</th><th>批产量</th>
                        </tr>
                        <tr class="add_Table">
                            <td><el-input clearable v-model="tableData.tableInput1" placeholder=""></el-input></td>
                            <td><el-input clearable v-model="tableData.tableInput2" placeholder=""></el-input></td>
                            <td><el-input clearable v-model="tableData.tableInput3" placeholder=""></el-input></td>
                            <td><el-input clearable v-model="tableData.tableInput4" placeholder=""></el-input></td>
                            <td><el-input clearable v-model="tableData.tableInput5" placeholder=""></el-input></td>
                        </tr>
                    </table>
                </div>
                <el-form-item class="formList" prop="addformdata6" label="备注：">
                    <el-input clearable type="textarea" class="input_right" placeholder="请输入备注" v-model="addForm.addformdata6"></el-input>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            tableData: {tableInput1: '',tableInput2: '',tableInput3: '',tableInput4: '',tableInput5:''},
            addForm: {
                addformdata1: '',
                addformdata2: '',
                addformdata3: '',
                addformdata4: '',
                addformdata5: '',
                addformdata6: '',
            },
            rules: {
                addformdata1:[
                    { required: true, message: '请输入客户名称', trigger: 'blur' },
                ],
                addformdata2:[
                    { required: true, message: '请选择订单日期', trigger: 'change' },
                ],
                addformdata3:[
                    { required: true, message: '请输入订单号', trigger: 'blur' },
                ],
                addformdata4:[
                    { required: true, message: '请选择部门', trigger: 'change' },
                ],
                addformdata5:[
                    { required: true, message: '请选择销售人', trigger: 'change' },
                ],
                addformdata6:[
                    { required: true, message: '请输入备注', trigger: 'blur' },
                ],
            },
        }
    },
    methods: {
        setFormData(formName){
            let formdata = {
                ...this.addForm,
                'tableData': {...this.tableData}
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
}
</script>

<style scoped lang="scss">
    @page {
        size: auto;  /* auto is the initial value */
        margin: 0mm; /* this affects the margin in the printer settings */
    }

    @import "@/assets/style/dialog.scss";
    .tablebody {
        margin-top: 50px;
        border: 1px solid #ccc;
        // border-radius: 5px;
        padding: 15px;
        position: relative;

        .table_top {
            position:absolute;
            top: -32px;
            width: 60%;
            background: #fff;
            z-index: 111;
        }
    }
</style>
