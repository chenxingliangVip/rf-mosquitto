<template>
    <div class="addProject UserAdd">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-row :gutter="20">
                    <el-col :span="4">
                        <div class="upLoad">
                            <img-upload :imgList.sync="imgSrc" :disabled="disabled"></img-upload>
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addFormData1" label="姓名：">
                            <el-input clearable class="input_right" placeholder="请输入姓名" v-model="addForm.addFormData1" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData2" label="性别：" style="width: 50%; float: left">
                            <el-select clearable v-model="addForm.addFormData2" placeholder="请选择性别" :disabled="disabled">
                                <el-option label="男" value="男"></el-option>
                                <el-option label="女" value="女"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData3" label="生日：" style="width: 50%; float: right">
                            <el-date-picker clearable type="date"  placeholder="请选择生日" v-model="addForm.addFormData3" :disabled="disabled"></el-date-picker>
                        </el-form-item>
                        <div style="clear: both"></div>
                        <el-form-item class="formList" prop="addFormData4" label="身份证号：">
                            <el-input clearable class="input_right" placeholder="请输入身份证号" v-model="addForm.addFormData4" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData5" label="住址：">
                            <el-input clearable class="input_right" placeholder="请输入住址" v-model="addForm.addFormData5" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData6" label="开户行：">
                            <el-input clearable class="input_right" placeholder="请输入开户行" v-model="addForm.addFormData6" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData7" label="银行卡：">
                            <el-input clearable class="input_right" placeholder="请输入银行卡" v-model="addForm.addFormData7" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData8" label="就业号：">
                            <el-input clearable class="input_right" placeholder="请输入就业号" v-model="addForm.addFormData8" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData9" label="社保号：">
                            <el-input clearable class="input_right" placeholder="请输入社保号" v-model="addForm.addFormData9" :disabled="disabled"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item class="formList" prop="addFormData10" label="手机号：">
                            <el-input clearable class="input_right" placeholder="请输入手机号" v-model="addForm.addFormData10" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData11" label="入职日期：">
                            <el-date-picker clearable type="date"  placeholder="请选择入职日期" v-model="addForm.addFormData11" :disabled="disabled"></el-date-picker>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData12" label="性质：">
                            <el-input clearable class="input_right" placeholder="请输入性质" v-model="addForm.addFormData12" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData13" label="工号：">
                            <el-input clearable class="input_right" placeholder="请输入工号" v-model="addForm.addFormData13" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData14" label="部门：">
                            <el-input clearable class="input_right" placeholder="请输入部门" v-model="addForm.addFormData14" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData15" label="职务：">
                            <el-input clearable class="input_right" placeholder="请输入职务" v-model="addForm.addFormData15" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData16" label="工资：">
                            <el-input clearable class="input_right" placeholder="请输入工资" v-model="addForm.addFormData16" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData17" label="基数：">
                            <el-input clearable class="input_right" placeholder="请输入基数" v-model="addForm.addFormData17" :disabled="disabled"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row class="bottom">
                    <el-col :span="12" :offset="4">
                        <el-form-item class="formList" prop="addFormData18" label="用户名：">
                            <el-input clearable class="input_right" placeholder="请输入用户名" v-model="addForm.addFormData18" :disabled="disabled"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData19" label="密码：">
                            <el-input clearable class="input_right" show-password placeholder="请输入密码" v-model="addForm.addFormData19" :disabled="disabled"></el-input>
                            <div class="addNew">
                                <span class="password" @click="setPass()"> 初始密码</span>
                            </div>
                        </el-form-item>
                        <el-form-item class="formList" prop="addFormData20" label="状态：">
                            <el-select clearable class="input_right" v-model="addForm.addFormData20" placeholder="请选择状态" :disabled="disabled">
                                <el-option label="停用" value="停用"></el-option>
                                <el-option label="启用" value="启用"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </div>
    </div>
</template>
<script>
import { checkPhone, idCard, Name, number} from '@/assets/js/verify'
import imgUpload from './imgUpload'
export default {
    props: ['titleTxt'],
    data(){
        return {
            disabled: false,
            imgSrc: {},
            addForm:{
                addFormData1: '',//姓名
                addFormData2: '',//性别
                addFormData3: '',//生日
                addFormData4: '',//身份证号
                addFormData5: '',//住址
                addFormData6: '',//开户行
                addFormData7: '',//银行卡
                addFormData8: '',//就业号
                addFormData9: '',//社保号
                addFormData10: '',//手机号
                addFormData11: '',//入职日期
                addFormData12: '',//性质
                addFormData13: '',//工号
                addFormData14: '',//部门
                addFormData15: '',//职务
                addFormData16: '',//工资
                addFormData17: '',//基数
                addFormData18: '',//用户名
                addFormData19: '',//密码
                addFormData20: '',//状态
            },
            rules: {
                addFormData1:[
                    { required: true, validator: Name, trigger: 'blur' },
                ],
                addFormData2:[
                    { required: true, message: '请选择性别', trigger: 'blur' },
                ],
                addFormData3:[
                    { required: true, message: '请选择生日', trigger: 'change' },
                ],
                addFormData4:[
                    { required: true, validator: idCard, trigger: 'blur' },
                ],
                addFormData5:[
                    { required: true, message: '请输入住址', trigger: 'blur' },
                ],
                addFormData6:[
                    { required: true, message: '请输入开户行', trigger: 'blur' },
                ],
                addFormData7:[
                    { required: true, message: '请输入银行卡', trigger: 'blur' },
                    { validator: number }
                ],
                addFormData8:[
                    { required: true, message: '请输入就业号', trigger: 'blur' },
                ],
                addFormData9:[
                    { required: true, message: '请输入社保号', trigger: 'blur' },
                    { validator: number }
                ],
                addFormData10:[
                    { required: true, validator: checkPhone, trigger: 'blur' },
                ],
                addFormData11:[
                    { required: true, message: '请选择入职日期', trigger: 'change' },
                ],
                addFormData12:[
                    { required: true, message: '请输入性质', trigger: 'blur' },
                ],
                addFormData13:[
                    { required: true, message: '请输入工号', trigger: 'blur' },
                ],
                addFormData14:[
                    { required: true, message: '请输入部门', trigger: 'blur' },
                ],
                addFormData15:[
                    { required: true, message: '请输入职务', trigger: 'blur' },
                ],
                addFormData16:[
                    { required: true, message: '请输入工资', trigger: 'blur' },
                    { validator: number }
                ],
                addFormData17:[
                    { required: true, message: '请输入基数', trigger: 'blur' },
                ],
                addFormData18:[
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                ],
                addFormData19:[
                    { required: true, message: '请输入密码', trigger: 'blur' },
                ],
                addFormData20:[
                    { required: true, message: '请选择状态', trigger: 'change' },
                ],
            },
        }
    },
    methods: {
        setPass() {
            this.addForm.addFormData19 = '123456'
        },
        setFormData(formName){
            if(!this.imgSrc.file) {
                this.$message.warning('请上传照片！');
                return false
            }
            let addForm = {
                ...this.addForm,
                'imgSrc': {...this.imgSrc},
            }
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.$emit('addForm', addForm)
                }else {
                    return false
                }
            })
        },
    },
    mounted(){
        if( this.titleTxt == '查看') {
            this.disabled = true
        }
    },
    components: {
        imgUpload
    }
}
</script>
<style lang="scss" scoped>
    @import "@/assets/style/dialog.scss";
    .UserAdd {
        .upLoad {
            margin-top: 15px;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
        }
        .bottom {
            border-top: 1px solid #DCDFE6; 
            margin-top: 15px;
            .input_right {
                width: calc( 100% - 100px );
            }
        }
        .addNew {
            float: right;
            text-align: right;
            height: 26px;
            line-height: 26px;
            cursor: pointer;
            font-size: 12px;
            margin-top: 3px;
            span {
                background: #fd6b6b;
                color: #ffffff;
                border-radius: 14px;
                text-align: center;
                display: inline-block;
                padding: 0 10px;
                &:hover {
                    opacity: .8;
                    transition: all .3s;
                }
            }
        }
    }
</style>