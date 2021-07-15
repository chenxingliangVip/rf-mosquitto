<template>
    <div class="Statistics" v-bind:style="style">
		<nx-full-screen class="allfull screenfull" style="float: right"></nx-full-screen>
        <div class="header"></div>
        <div class="main_contain">
            <el-row :gutter="10">
                <el-col :span="16" class="col_list">
                    <p class="tab_name"><i class="el-icon-d-arrow-right"></i>产品状态</p>
                    <div class="echart1" ref="echart1"></div>
                </el-col>
                <el-col :span="8" class="col_list">
                    <p class="tab_name"><i class="el-icon-d-arrow-right"></i>各生产部准点率</p>
                    <div class="echart2" ref="echart2"></div>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="8" class="col_list">
                    <p class="tab_name"><i class="el-icon-d-arrow-right"></i>入库产品目录</p>
                    <div class="table_list">
                        <table>
                            <tr>
                                <th width="10%">序号</th><th width="25%">入库时间</th><th width="25%">产品名称</th><th width="25%">批号</th><th width="15%">入库量（t）</th>
                            </tr>
                            <tr v-for="(item, index) in tableList" :key="index">
                                <td width="10%">{{ index + 1 }}</td>
                                <td width="25%"></td>
                                <td width="25%"></td>
                                <td width="25%"></td>
                                <td width="15%"></td>
                            </tr>
                        </table>
                    </div>
                </el-col>
                <el-col :span="16" class="col_list">
                    <p class="tab_name"><i class="el-icon-d-arrow-right"></i>各生产部月度累计入库量（t）</p>
                    <div class="echart3" ref="echart3"></div>
                </el-col>
            </el-row>
            <div class="col_list">
                <p class="tab_name"><i class="el-icon-d-arrow-right"></i>分析数据</p>
                <el-row class="bottom_nav">
                    <el-col :span="6">
                        <p class="nav">
                            <span class="nav_left">检测样品数：</span>
                            <span class="nav_right">20199</span>
                        </p>
                    </el-col>
                    <el-col :span="6">
                        <p class="nav">
                            <span class="nav_left">一次检样合格率：</span>
                            <span class="nav_right">90%</span>
                        </p>
                    </el-col>
                    <el-col :span="6">
                        <p class="nav">
                            <span class="nav_left">差错率：</span>
                            <span class="nav_right">1%</span>
                        </p>
                    </el-col>
                    <el-col :span="6">
                        <p class="nav">
                            <span class="nav_left">及时率：</span>
                            <span class="nav_right">90%</span>
                        </p>
                    </el-col>
                </el-row>
            </div>
        </div>
    </div>
</template>

<script>
import resize from '@/assets/js/resize'
import echartOption from './echart'
import nxFullScreen from '@/components/nx-full-screen/index'
export default {
    data() {
        return {
            style: {}, //缩放样式
            tableList: [
                {}
            ]
        }
    },
    methods: {
        pageShow() { 
            this.style = resize.setScale();
            window.onresize = () => {
                this.style = resize.setScale();
            }
        },
        getEchartData1() {  //echart1 产品状态
            let echart1 = this.$echarts.init(this.$refs.echart1);
            echart1.setOption(echartOption.option1)
        },
        getEchartData2() {  //echart2 各生产部准点率
            let echart2 = this.$echarts.init(this.$refs.echart2);
            echart2.setOption(echartOption.option2)
        },
        getEchartData3() {  //echart3 各生产部准点率
            let echart3 = this.$echarts.init(this.$refs.echart3);
            echart3.setOption(echartOption.option3)
        },
    },
    mounted() {
        // this.pageShow()
        this.getEchartData1()
        this.getEchartData2()
        this.getEchartData3()
    },
    components: {
        nxFullScreen
    },
}
</script>

<style lang="scss" scoped>
@import '@/assets/style/statisticChart.scss'
</style>