<template>
    <div class="addProject">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-row :gutter="20">
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addFormData1" label="检项名称：">
                            <el-input clearable class="input_right" placeholder="请输入检项名称" v-model="addForm.addFormData1" :disabled="isdisabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData2" label="方法依据：">
                            <el-input clearable class="input_right" placeholder="请输入方法依据" v-model="addForm.addFormData2" :disabled="isdisabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData3" label="方法类别：">
                            <el-select clearable class="input_right" placeholder="请选择方法类别" v-model="addForm.addFormData3" :disabled="isdisabled">
                                <el-option label="化学" value="化学"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData4" label="方法名称：">
                            <el-input clearable class="input_right" placeholder="请输入方法名称" v-model="addForm.addFormData4" :disabled="isdisabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData5" label="方法编号：">
                            <el-input clearable class="input_right" placeholder="请输入方法编号" v-model="addForm.addFormData5" :disabled="isdisabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData6" label="方法属性：">
                            <el-select clearable class="input_right" placeholder="请选择方法属性" v-model="addForm.addFormData6" :disabled="isdisabled">
                                <el-option label="化学" value="化学"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addFormData7" label="增录人：">
                            <el-input clearable class="input_right" placeholder="请输入增录人" v-model="addForm.addFormData7" :disabled="isdisabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData8" label="部门：">
                            <el-select clearable class="input_right" placeholder="请选择部门" v-model="addForm.addFormData8" :disabled="isdisabled">
                                <el-option label="部门" value="部门"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData9" label="日期：">
                            <el-date-picker type="date" class="input_right" placeholder="请选择日期" v-model="addForm.addFormData9" :disabled="isdisabled" value-format="yyyy-MM-dd"></el-date-picker>
                        </el-form-item>
                        <el-form-item class="formList"></el-form-item>
                        <el-form-item class="formList" prop="addFormData10" label="工时：">
                            <el-input clearable class="input_right" placeholder="请输入工时" v-model="addForm.addFormData10" :disabled="isdisabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData11" label="版本：">
                            <el-input clearable class="input_right" placeholder="请输入版本" v-model="addForm.addFormData11" :disabled="isdisabled"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <span class="form_left">检验方法：</span>
                <Tinymce v-model="addForm.Tinymce" :disabled="isdisabled" height="100px"></Tinymce>
                    
                <span class="form_left">检验记录：</span>
                <Tinymce v-model="addForm.Tinymce2" :disabled="isdisabled" height="100px"></Tinymce>
            </el-form>
        </div>
    </div>
</template>
<script>
import Tinymce from '@/components/Tinymce/index'
export default {
    props: ['title'],
    data () {
        return {
            isdisabled: false,
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
                Tinymce: '',
                Tinymce2: '',
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
        setFormData(formName){
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.$emit('addForm',this.addForm)
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
        Tinymce
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
