<template>
    <div class="addProject">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-form-item class="formList" prop="addFormData1" label="初始密码：">
                    <el-input clearable class="input_right" show-password placeholder="请输入初始密码" v-model="addForm.addFormData1"></el-input> 
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            addForm: {
                addFormData1: '',
            },
            rules: {
                addFormData1:[
                    { required: true, message: '请输入初始密码', trigger: 'blur' },
                ],
            }
        };
    },
    methods: {
        setFormData(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.$emit('addForm',this.addForm)
                }else {
                    return false
                }
            })
        },
    },
};
</script>
<style lang="scss" scoped>
@import "@/assets/style/dialog.scss";
</style>