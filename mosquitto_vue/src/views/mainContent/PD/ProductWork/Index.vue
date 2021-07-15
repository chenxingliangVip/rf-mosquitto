<template>
    <div class="ProductWork">
        <div class="work_list">
            <h2>高分子聚合线 / T1线 </h2>
            <div class="list_nav">
                <div class="list_nav_item">
                    <div class="item">
                        <p><span class="name">产品编码：</span><span class="num">E010232</span></p>
                        <p><span class="name">产品名称：</span><span class="num">聚山梨酯20</span></p>
                        <p><span class="name">产品规格：</span><span class="num">药用级</span></p>
                    </div>
                    <div class="item">
                        <div class="scan">
                            <div class="input_img">批次号</div>
                            <el-input clearable class="input_right" placeholder="" v-model="inputData1" disabled></el-input>
                            <div style="clear: both"></div>
                        </div>
                        <div class="scan">
                            <div class="input_img">状态</div>
                            <el-input clearable class="input_right" placeholder="" v-model="inputData2" disabled></el-input>
                            <div style="clear: both"></div>
                        </div>
                        <div class="scan">
                            <div class="input_img">阶段</div>
                            <el-input clearable class="input_right" placeholder="" v-model="inputData3" disabled></el-input>
                            <div style="clear: both"></div>
                        </div>
                    </div>
                    <div class="item">
                        <p><span class="name">SRP：</span><span class="num">S191211027</span></p>
                        <p><span class="name">启动人：</span><span class="num">刘海涛</span></p>
                        <p><span class="name">启动日期：</span><span class="num">2019-12-12 16:15</span></p>
                    </div>
                    <div class="item">
                        <p><span class="name">生产部门：</span><span class="num">生产1部</span></p>
                        <p><span class="name">当前班组：</span><span class="num">12组 晚班</span></p>
                        <p><span class="name">负责人：</span><span class="num">周正义</span></p>
                    </div>
                    <div style="clear: both"></div>
                </div>
                <div class="button">
                    <span @click="add()">交接班</span>
                    <span class="delete" @click="qcDetect()">QC检测</span>
                </div>
                <div style="clear: both"></div>
            </div>
            <div class="list_nav_last tableList">
                <table>
                    <tr>
                        <th>阶段</th><th>次数</th><th>检验号</th><th>申请时间</th><th>申请人</th><th>状态</th><th>检验组</th><th>检验人</th><th>QC判定</th><th>详细</th>
                    </tr>
                    <tr>
                        <td class="stage" rowspan="2">M1</td>
                        <td rowspan="2">2</td>
                        <td>Q19121301</td>
                        <td>2019-12-13 13:03</td>
                        <td>刘涛</td>
                        <td>未送样</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Q19121301</td>
                        <td>2019-12-13 13:03</td>
                        <td>刘涛</td>
                        <td>代领检</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="stage">M2</td>
                        <td>1</td>
                        <td>Q19121301</td>
                        <td>2019-12-13 13:03</td>
                        <td>刘涛</td>
                        <td>完成</td>
                        <td>分析1组</td>
                        <td>李宏丽</td>
                        <td>合格</td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <div class="bottom">
                <div class="bottom_list">
                    <div class="bottom_nav">
                        <p><span class="name">结项状态：</span><span class="num">已结项</span></p>
                        <p><span class="name">结项日期：</span><span class="num">2019-12-12 15:33</span></p>
                        <p><span class="name">结项人：</span><span class="num">周正义</span></p>
                        <p><span class="name">SRP归档：</span><span class="num">完成</span></p>
                    </div>
                    <div class="bottom_nav">
                        <div class="left">
                            <img src="@/assets/img/print.png">
                        </div>
                        <div class="right">
                            <span class="button delete" :class="{ 'isClose': isClose }" @click="closeDown()">关机</span>
                            <span class="button" :class="{ 'isClose': !isClose }" @click="post()">结项</span>
                        </div>
                    </div>
                    <div class="bottom_nav">
                        <p><span class="name">包装：</span><span class="num">PPR50塑胶桶</span></p>
                        <p><span class="name">数量：</span><span class="num">300</span></p>
                        <p><span class="name">计件：</span><span class="num">托盘</span></p>
                        <p><span class="name">件数：</span><span class="num">7</span></p>
                    </div>
                </div>
                <div class="bottom_last">
                    <span class="dabao" @click="packPaper()">包装贴纸</span>
                </div>
                <div style="clear: both"></div>
            </div>
        </div>
        <!-- 交接弹框 -->
        <div class="zll-dialog">
            <popout title="在产交接班" :visible.sync="addDialog" v-if="addDialog" class="handover_dialog">
                <Add ref="add" slot="content"></Add>
            </popout>
        </div> 
        <!-- qc检测弹框 -->
        <div class="zll-dialog">
            <popout title="QC检测" :visible.sync="qcDialog" v-if="qcDialog">
                <qc-detect ref="add" slot="content" @addForm="getFormData"></qc-detect>
                <template slot="bottom">
                    <p class="zll-botton" @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
                </template>
            </popout>
        </div> 
        <!-- 包装弹框 -->
        <div class="zll-dialog">
            <popout title="包装" :visible.sync="packageDialog" v-if="packageDialog" class="package_dialog">
                <package ref="add" slot="content" @addForm="packageData"></package>
                <template slot="bottom">
                    <p class="zll-botton" @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
                </template>
            </popout>
        </div> 
        <!-- qc结果反馈弹框 -->
        <div class="zll-dialog">
            <popout title="qc结果反馈" :visible.sync="resultDialog" v-if="resultDialog" class="result_dialog">
                <Result ref="add" :timeOut="countdown" slot="content"></Result>
                <template slot="bottom">
                    <p class="zll-botton">报 告</p>
                    <p class="zll-botton save" @click="resultDialog = false">关 闭</p>
                </template>
            </popout>
        </div> 
    </div>
</template>

<script>
    import Add from "./add"
    import qcDetect from "./qc"
    import Package from "./package"
    import Result from "./result"
    export default {
        data () {
            return {
                inputData1: 'P191212028',
                inputData2: '生产中',
                inputData3: 'M2',
                isClose: false,
                addDialog: false, //交接弹框
                qcDialog: false, //qc检测弹框
                packageDialog: false, //包装弹框
                resultDialog: true, //qc结果反馈
                countdown:'5',
                timer: null,
            }
        },
        methods: {
            add(){//交接班
                this.addDialog = true
            },
            qcDetect() {//QC检测
                this.qcDialog = true
            },
            getFormData(data) {
                console.log(data)
                this.qcDialog = false
            },
            packPaper() {//包装
                this.packageDialog = true   
            },
            packageData(data) {
                console.log(data)
                this.packageDialog = false   
            },
            closeDown() {//关机
                if( !this.isClose) {
                    this.$confirm('确定关机？', '提示', {       
                        distinguishCancelAndClose: true,
                        cancelButtonText: '取消',
                        confirmButtonText: '确定',
                    }).then(() => {
                        this.$message.success("已关机")
                        this.isClose = true
                    }).catch(() => {
                            
                    });
                }else {
                    return false
                }
            },
            post() {//结项
                if( !this.isClose) {
                    return false
                }else {
                    this.$confirm('确定结项？', '提示', {       
                        distinguishCancelAndClose: true,
                        cancelButtonText: '取消',
                        confirmButtonText: '确定',
                    }).then(() => {
                        this.$message.success("已结项")
                    }).catch(() => {
                            
                    });
                }
            },
            sendCode(){
                this.countdown--;  //定时器减1
                this.timer = setInterval(() =>{
                    //创建定时器
                    if(this.countdown === 1){
                        this.clearTimer();  //关闭定时器
                        this.resultDialog = false
                    }else{
                         this.countdown--;
                    }
                },1000);
            },
            clearTimer(){  //清除定时器
                clearInterval(this.timer);
                this.timer = null;
            },
        },
        mounted(){
            this.sendCode(); 
        },
        components:{
           Add, qcDetect, Package, Result
        },
    }
</script>
<style scoped lang="scss">
    @import "@/assets/style/SearchTop.scss";
    @import "@/assets/style/pageStyle.scss";
</style>
