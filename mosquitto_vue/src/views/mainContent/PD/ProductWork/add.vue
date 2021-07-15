<template>
    <div class="addProject jiaojie">
        <h1>在产交接班</h1>
        <div class="addForm zll-form">
            <el-row :gutter="20">
                <el-col :span="8">
                    <div class="in_product">
                        <img src="@/assets/img/huaxue.png">
                        <div class="button">生产中</div>
                        <p><span class="name">产线：</span><span class="num">{{ data1 }}</span></p>
                        <p><span class="name">批次码：</span><span class="num">{{ data2 }}</span></p>
                        <p><span class="name">阶段：</span><span class="num">{{ data3 }}</span></p>
                        <p><span class="name">产品：</span><span class="num">{{ data4 }}</span></p>
                        <p><span class="name">编码：</span><span class="num">{{ data5 }}</span></p>
                        <p><span class="name">规格：</span><span class="num">{{ data6 }}</span></p>
                    </div>
                </el-col>
                <el-col :span="16">
                    <p class="error" v-show="iserror">ID无效，请重新识别</p>
                    <div class="person">
                        <el-row :gutter="20">
                            <el-col :span="8">
                                <div class="person_one">
                                    <p class="name">{{ person1.name }}</p>
                                    <p class="time">{{ person1.time }}</p>
                                    <p class="bm"></p>
                                    <div class="ID">
                                        <span>ID识别</span>
                                        <el-input clearable class="input_right" placeholder="" v-model="person1.idcard" @change="personChange" :disabled="isdisabled"></el-input>
                                    </div>
                                </div>
                            </el-col>
                            <el-col :span="8">
                                <div class="success">
                                    <p v-show="success">交班成功</p>
                                    <img v-show="success" src="@/assets/img/success.png">
                                </div>
                                <div class="hand" v-show="!success">
                                    <span class="handOver" @click="handOver()">交班</span>
                                </div>
                            </el-col>
                            <el-col :span="8">
                                <div class="person_two">
                                    <p class="name">{{ person2.name }}</p>
                                    <p class="time">{{ person2.time }}</p>
                                    <p class="bm">{{ person2.bm }}</p>
                                    <div class="ID">
                                        <el-input clearable class="input_right" placeholder="" v-model="person2.idcard" @change="personChange2" :disabled="isdisabled"></el-input>
                                        <span>ID识别</span>
                                    </div>
                                    <div class="ID">
                                        <el-input clearable class="input_right" placeholder="" v-model="srp" @change="srpChange" :disabled="isdisabled"></el-input>
                                        <span>SRP</span>
                                    </div>
                                </div>
                            </el-col>
                        </el-row>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
export default {
    data () {
        return {
            iserror: false,
            success: false,
            isdisabled: false,
            data1: '高分子聚合线/T1线',
            data2: 'P121212028',
            data3: 'M1',
            data4: '聚山梨酯20',
            data5: 'E010232',
            data6: '药用级',
            person1: {
                name: '',
                time: '',
                idcard: '',
            },
            person2: {
                name: '',
                time: '',
                bm: '',
                idcard: '',
            },
            srp: ''
        }
    },
    methods: {
        personChange(val) {
            if(val !== '') {
                this.person1.name = '胡晓鸥'
                this.person1.time = '晚班 16:00-24:00'
            }
        },
        personChange2(val) {
            if(this.person1.idcard == '') {
                this.$message.error("请先扫描交接人")
                return false
            }
            if(val !== '') {
                this.person2.name = '许好'
                this.person2.time = '白班 08:00-16:00'
                this.iserror = true
            }
        },
        srpChange(val) {
            if(this.person1.idcard == '' ||  this.person2.idcard == '') {
                this.$message.error("请先扫描交接人")
                return false
            }
            if(val !== '') {
                this.person2.bm = 'S191212028'
            }
        },
        handOver() {
            if(this.person1.idcard == '' && this.person2.idcard == '' && this.srp == '') {
                return false
            }else {
                this.success = true
                this.isdisabled = true
            }
        }
    },
}
</script>

<style scoped lang="scss">
    @import "@/assets/style/dialog.scss";
    @import "@/assets/style/pageStyle.scss";
</style>
