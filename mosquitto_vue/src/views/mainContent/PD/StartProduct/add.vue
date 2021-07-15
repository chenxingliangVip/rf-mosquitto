<template>
    <div class="addProject add_work">
        <div class="scan">
            <div class="input_img"><img src="@/assets/img/saomiao.png"></div>
            <el-input clearable class="input_right" placeholder="请扫描SRP码" v-model="srp" @change="change"></el-input>
            <div style="clear: both"></div>
        </div>
        <div class="addForm zll-form">
            <el-row :gutter="20">
                <el-col :span="12">
                    <h1 class="title">
                        <img src="@/assets/img/huaxue.png">{{ name }}
                    </h1>
                </el-col>
                <el-col :span="6">
                    <div class="producting" :class="{ 'waitproduct': productState == 1, 'inproduct': productState == 2 }">{{ isproduct }}</div>
                </el-col>
                <el-col :span="6">
                    <p class="time">{{nowDate}} {{nowTime}}</p>
                </el-col>
            </el-row>
            <div class="form_list">
                <el-form :model="addForm" ref="addForm" class="demo-ruleForm">
                    <p class="bm">{{ bm }}</p>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item class="formList" prop="addformdata1" label="产品名称：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata1" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata2" label="产品规格：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata2" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata3" label="产品编码：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata3" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata4" label="计划开始：">
                                <el-date-picker type="date" placeholder="" v-model="addForm.addformdata4" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata5" label="计划结束：">
                                <el-date-picker type="date" placeholder="" v-model="addForm.addformdata5" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item class="formList" prop="addformdata6" label="当前阶段：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata6" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata7" label="生产部门：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata7" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList"></el-form-item>
                            <el-form-item class="formList" prop="addformdata8" label="实际开始：">
                                <el-date-picker type="date" placeholder="" v-model="addForm.addformdata8" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata9" label="实际结束：">
                                <el-date-picker type="date" placeholder="" v-model="addForm.addformdata9" value-format="yyyy-MM-dd" :disabled="isdisabled"></el-date-picker>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item class="formList" prop="addformdata10" label="计划单：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata10" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata11" label="SRP：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata11" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList"></el-form-item>
                            <el-form-item class="formList" prop="addformdata12" label="当前班次：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata12" :disabled="isdisabled"></el-input>
                            </el-form-item>
                            <el-form-item class="formList" prop="addformdata13" label="启动人：">
                                <el-input clearable class="input_right" placeholder="" v-model="addForm.addformdata13" :disabled="isdisabled"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
                <div class="button">
                    <img v-if="productState == 2" class="inproduct" src="@/assets/img/inpd.png">
                    <img v-else @click="goStart()" src="@/assets/img/startpd.png">
                    <!-- <span v-if="productState == 2" class="inproduct">正 在<br>生 产</span> -->
                    <!-- <span v-else @click="goStart()">启 动<br>生 产</span> -->
                </div>
                <div style="clear: both"></div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            isdisabled: true,
            srp: '',
            bm: '',
            name: '',
            isproduct: '',
            productState: 0,
            nowTime: new Date(),
            nowDate: new Date(),
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
                addformdata10: '',
                addformdata11: '',
                addformdata12: '',
                addformdata13: '',
            },
        }
    },
    methods: {
		change(val) {
            if(val !== '') {
                this.productState = 1
                this.bm = 'P191212028'
                this.name = '高分子聚合线·T1线'
                this.isproduct = '待生产'
                this.addForm.addformdata1 = '聚山梨酯'
                this.addForm.addformdata2 = '药用级'
                this.addForm.addformdata3 = 'E010232'
                this.addForm.addformdata4 = '2020-08-22'
                this.addForm.addformdata5 = '2020-08-29'
                this.addForm.addformdata10 = '药用级'
                this.addForm.addformdata11 = 'S191211027'
                this.addForm.addformdata12 = '晚班'
                this.addForm.addformdata13 = '刘海涛'
            }else {
                this.productState = 0
                this.bm = ''
                this.name = ''
                this.isproduct = ''
                this.addForm.addformdata1 = ''
                this.addForm.addformdata2 = ''
                this.addForm.addformdata3 = ''
                this.addForm.addformdata4 = ''
                this.addForm.addformdata5 = ''
                this.addForm.addformdata6 = ''
                this.addForm.addformdata7 = ''
                this.addForm.addformdata8 = ''
                this.addForm.addformdata9 = ''
                this.addForm.addformdata10 = ''
                this.addForm.addformdata11 = ''
                this.addForm.addformdata12 = ''
                this.addForm.addformdata13 = ''
            }
        },
        goStart() {
            if(this.srp == '') {
                return false
            }
            this.productState = 2
            this.addForm.addformdata6 = 'M1'
            this.addForm.addformdata7 = '生产1部'
            this.addForm.addformdata8 = '2020-08-22'
        },
        getdateFormat() {
            //显示时间
            var _this = this;
            let yy = String(new Date().getFullYear());
            let mm = new Date().getMonth() + 1;
            let dd = String(new Date().getDate() < 10 ? "0" + new Date().getDate() : new Date().getDate());
            let hou = String(new Date().getHours() < 10 ? "0" + new Date().getHours() : new Date().getHours());
            let min = String(new Date().getMinutes() < 10 ? "0" + new Date().getMinutes() : new Date().getMinutes());
            let sec = String(new Date().getSeconds() < 10 ? "0" + new Date().getSeconds() : new Date().getSeconds());
            _this.nowTime = hou + ":" + min + ":" + sec;
            _this.nowDate = yy + "-" + mm + "-" + dd;
        },
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
    mounted() {
        this.getdateFormat(); //时间
        setInterval(() => {
            this.getdateFormat();
        }, 1000);
    },
}
</script>

<style scoped lang="scss">
    @import "@/assets/style/dialog.scss";
    @import "@/assets/style/pageStyle.scss";
</style>
