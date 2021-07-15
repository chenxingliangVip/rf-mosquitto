<template>
    <div class="addProject">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-row :gutter="20">
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addformdata1" label="产品：">
                            <el-input clearable class="input_right" placeholder="请输入产品" v-model="addForm.addformdata1"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata2" label="编号：">
                            <el-input clearable class="input_right" placeholder="请输入编号" v-model="addForm.addformdata2"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata3" label="规格：">
                            <el-select clearable class="input_right" placeholder="请选择规格" v-model="addForm.addformdata3">
                                <el-option label="药用级" value="药用级"></el-option>
                                <el-option label="工业级" value="工业级"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata4" label="批次号：">
                            <el-input clearable class="input_right" placeholder="请输入批次号" v-model="addForm.addformdata4"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata5" label="阶段：">
                            <el-select clearable class="input_right" placeholder="请选择阶段" v-model="addForm.addformdata5">
                                <el-option label="M1" value="M1"></el-option>
                                <el-option label="M2" value="M2"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata6" label="中间体：">
                            <el-select clearable class="input_right" placeholder="请选择中间体" v-model="addForm.addformdata6">
                                <el-option label="聚山梨酯20-中间体1" value="聚山梨酯20-中间体1"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item class="formList" prop="addformdata7" label="检验号：">
                            <el-input clearable class="input_right" placeholder="请输入检验号" v-model="addForm.addformdata7"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata8" label="生产部门：">
                            <el-select clearable class="input_right" placeholder="请选择生产部门" v-model="addForm.addformdata8">
                                <el-option label="聚合部" value="聚合部"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata9" label="生产班组：">
                            <el-select clearable class="input_right" placeholder="请选择生产班组" v-model="addForm.addformdata9">
                                <el-option label="生产1组" value="生产1组"></el-option>
                                <el-option label="生产3组" value="生产3组"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata10" label="送样人：">
                            <el-input clearable class="input_right" placeholder="请输入送样人" v-model="addForm.addformdata10"></el-input>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata11" label="送样日期：">
                            <el-date-picker type="date" class="input_right" placeholder="请选择订单日期" v-model="addForm.addformdata11" value-format="yyyy-MM-dd"></el-date-picker>
                        </el-form-item>
                        <el-form-item class="formList" prop="addformdata12" label="标签数量：">
                            <el-input clearable class="input_right" placeholder="请输入标签数量" v-model="addForm.addformdata12"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            addForm: { 
                addformdata1: '聚山梨酯20',
                addformdata2: 'E010232',
                addformdata3: '药用级',
                addformdata4: 'P191212028',
                addformdata5: 'M2',
                addformdata6: '聚山梨酯20-中间体1',
                addformdata7: 'J191212028',
                addformdata8: '聚合部',
                addformdata9: '生产3组',
                addformdata10: '许小曼',
                addformdata11: '2020-08-12',
                addformdata12: '5',
            },
            rules: {
                addformdata1:[
                    { required: true, message: '请输入产品', trigger: 'blur' },
                ],
                addformdata2:[
                    { required: true, message: '请输入编号', trigger: 'blur' },
                ],
                addformdata3:[
                    { required: true, message: '请选择规格', trigger: 'change' },
                ],
                addformdata4:[
                    { required: true, message: '请输入批次号', trigger: 'blur' },
                ],
                addformdata5:[
                    { required: true, message: '请选择阶段', trigger: 'change' },
                ],
                addformdata6:[
                    { required: true, message: '请选择中间体', trigger: 'change' },
                ],
                addformdata7:[
                    { required: true, message: '请输入检验号', trigger: 'blur' },
                ],
                addformdata8:[
                    { required: true, message: '请选择生产部门', trigger: 'change' },
                ],
                addformdata9:[
                    { required: true, message: '请选择生产班组', trigger: 'change' },
                ],
                addformdata10:[
                    { required: true, message: '请输入送样人', trigger: 'blur' },
                ],
                addformdata11:[
                    { required: true, message: '请选择送样日期', trigger: 'change' },
                ],
                addformdata12:[
                    { required: true, message: '请输入标签数量', trigger: 'blur' },
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
</style>
