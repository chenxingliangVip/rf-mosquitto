<template>
    <div class="addProject">
        <div class="logo_list logo_list1">
            <p class="txt">LOGO图片上传：</p>
            <div class="upLoad">
                <img-upload :imgList.sync="addForm.imgSrc1"></img-upload>
            </div>
            <span class="tipMsg"><i class="el-icon-warning"></i>文件格式为PNG/JPG，高度尺寸不超过50px</span>
        </div>
        <div class="logo_list">
            <p class="txt">浏览器LOGO上传：</p>
            <div class="upLoad">
                <img-upload :imgList.sync="addForm.imgSrc2" isIco="ico"></img-upload>
                <span class="tipMsg"><i class="el-icon-warning"></i>文件格式为ico</span>
            </div>
        </div>
        <div style="clear: both"></div>
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-form-item class="formList" prop="addFormData1" label="系统标题：">
                    <el-input clearable class="input_right" placeholder="请输入系统标题" v-model="addForm.addFormData1"></el-input>
                </el-form-item>
            </el-form>
        </div>
        <div class="logo_list">
            <p class="txt">背景图片上传：</p>
            <div class="upLoad">
                <img-upload :imgList.sync="addForm.imgSrc2" isIco="ico"></img-upload>
                <span class="tipMsg"><i class="el-icon-warning"></i>文件格式为PNG/JPG</span>
            </div>
        </div>
    </div>
</template>
<script>
import imgUpload from "./imgUpload";
export default {
    data() {
        return {
            addForm: {
                addFormData1: "",
                imgSrc1: {},
                imgSrc2: {},
            },
            rules: {
                addFormData1: [
                    {
                        required: true,
                        message: "请输入系统标题",
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    methods: {
        setFormData(formName) {
            console.log(this.addForm.imgSrc1)
            if (!this.addForm.imgSrc1.file) {
                this.$message.warning("请上传LOGO图片！");
                return false;
            }
            if (!this.addForm.imgSrc2.file) {
                this.$message.warning("请上传浏览器LOGO！");
                return false;
            }
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.$emit("addForm", this.addForm);
                } else {
                    return false;
                }
            });
        },
    },
    components: {
        imgUpload,
    },
};
</script>
<style lang="scss" scoped>
@import "@/assets/style/dialog.scss";
.logo_list {
    width: 50%;
    float: left;
    border: 1px solid #e6e6e6;
    padding: 10px 15px 20px;
    border-radius: 4px;
    height: 230px;
    &.logo_list1 {
        width: calc(50% - 20px);
        margin-right: 20px;
    }
    .txt {
        font-size: 12px;
        color: #606266;
        margin-bottom: 10px;
    }
    .upLoad {
        width: 140px;
        margin: 0 auto;
    }
    .tipMsg {
        display: block;
        padding: 5px;    
        width: 200px;
        margin: 5px auto 0;
        font-size: 12px;
        color: #606266;
        i {
            color: #4791d2;
            font-size: 14px;
            margin-right: 5px;
        }
    }
}
</style>