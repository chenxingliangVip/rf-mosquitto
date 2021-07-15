<template>
    <div class="addProject package">
        <h2>P191212028 / 聚山梨酯20 / 5吨</h2>
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <div class="pack_list">
                    <el-row>
                        <el-col :span="8">
                            <div class="logo">包材</div>
                            <div class="imgsrc">
                                <img src="@/assets/img/package1.png">
                            </div>
                        </el-col>
                        <el-col :span="16">
                            <el-form-item class="formList" prop="addformdata1" label="类别：">
                                <el-select clearable class="input_right" placeholder="请选择类别" v-model="addForm.addformdata1">
                                    <el-option label="PPR塑桶" value="PPR塑桶"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata2" label="型号：">
                                <el-select clearable class="input_right" placeholder="请选择型号" v-model="addForm.addformdata2">
                                    <el-option label="PPR50" value="PPR50"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata3" label="单重：">
                                <el-input clearable class="input_right" placeholder="请输入单重" v-model="addForm.addformdata3"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </div>
                <div class="pack_list">
                    <el-row>
                        <el-col :span="8">
                            <div class="logo">计件</div>
                            <div class="imgsrc">
                                <img src="@/assets/img/package2.png">
                            </div>
                        </el-col>
                        <el-col :span="16">
                            <el-form-item class="formList" prop="addformdata4" label="方式：">
                                <el-select clearable class="input_right" placeholder="请选择方式" v-model="addForm.addformdata4">
                                    <el-option label="托盘" value="托盘"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata5" label="数量：">
                                <el-input clearable class="input_right" placeholder="请输入数量" v-model="addForm.addformdata5"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata6" label="件量：">
                                <el-input clearable class="input_right" placeholder="请输入件量" v-model="addForm.addformdata6"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </div>
                <div class="pack_list">
                    <el-row>
                        <el-col :span="8">
                            <div class="logo">标签</div>
                            <div class="imgsrc">
                                <img src="@/assets/img/package3.png">
                            </div>
                        </el-col>
                        <el-col :span="16">
                            <el-form-item class="formList" prop="addformdata7" label="数量：">
                                <el-input clearable class="input_right" placeholder="请输入数量" v-model="addForm.addformdata7"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata8" label="打印人：">
                                <el-input clearable class="input_right" placeholder="请输入打印人" v-model="addForm.addformdata8"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata9" label="打印日期：">
                                <el-date-picker type="date" placeholder="请选择打印日期" v-model="addForm.addformdata9"></el-date-picker>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </div>
            </el-form>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            addForm: { 
                addformdata1: '',
                addformdata2: '',
                addformdata3: '',
                addformdata4: '',
                addformdata5: '',
                addformdata6: '',
                addformdata7: '',
                addformdata8: '',
                addformdata9: '',
            },
            rules: {
                addformdata1:[
                    { required: true, message: '请选择类别', trigger: 'change' },
                ],
                addformdata2:[
                    { required: true, message: '请选择型号', trigger: 'change' },
                ],
                addformdata3:[
                    { required: true, message: '请输入单重', trigger: 'blur' },
                ],
                addformdata4:[
                    { required: true, message: '请选择方式', trigger: 'change' },
                ],
                addformdata5:[
                    { required: true, message: '请输入数量', trigger: 'blur' },
                ],
                addformdata6:[
                    { required: true, message: '请输入件量', trigger: 'blur' },
                ],
                addformdata7:[
                    { required: true, message: '请输入数量', trigger: 'blur' },
                ],
                addformdata8:[
                    { required: true, message: '请输入打印人', trigger: 'blur' },
                ],
                addformdata9:[
                    { required: true, message: '请选择打印日期', trigger: 'change' },
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
}
</script>

<style scoped lang="scss">
    @import "@/assets/style/dialog.scss";
    @import "@/assets/style/pageStyle.scss";
</style>
