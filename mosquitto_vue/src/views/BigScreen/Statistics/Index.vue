<template>
    <div class="Statistics Statistics2" v-bind:style="style">
		<nx-full-screen class="allfull screenfull" style="float: right; position: relative;    z-index: 111;"></nx-full-screen>
        <div class="header">
            <p>威尔药业 · 智慧生产大数据平台</p>
            <div class="TimeForm">
                <p class="time">{{nowDate}} {{nowWeek}} {{nowTime}} </p>
            </div>
        </div>
        <div class="main_contain">
            <el-row :gutter="6">
                <el-col :span="16" class="col_list">
                    <p class="tab_name"><i class="el-icon-d-arrow-right"></i>产品状态</p>
                    <div class="echart1" ref="echart1"></div>
                </el-col>
                <el-col :span="8" class="col_list">
                    <p class="tab_name"><i class="el-icon-d-arrow-right"></i>各生产部准点率</p>
                    <div class="echart2" ref="echart2"></div>
                </el-col>
            </el-row>
            <el-row :gutter="6">
                <el-col :span="8" class="col_list">
                    <p class="tab_name"><i class="el-icon-d-arrow-right"></i>入库产品目录</p>
                    <div class="table_list">
                        <table>
                            <tr>
                                <th width="10%">序号</th><th width="25%">入库时间</th><th width="25%">产品名称</th><th width="25%">批号</th><th width="15%">入库量（t）</th>
                            </tr>
                            <tr v-for="(item, index) in tableList" :key="index">
                                <td width="10%">{{ index + 1 }}</td>
                                <td width="25%">{{ item.tableData1 }}</td>
                                <td width="25%">{{ item.tableData2 }}</td>
                                <td width="25%">{{ item.tableData3 }}</td>
                                <td width="15%">{{ item.tableData4 }}</td>
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
                        <div class="nav">
                            <p class="nav_right">20199</p>
                            <p class="nav_left">检测样品数</p>
                        </div>
                    </el-col>
                    <el-col :span="6">
                        <div class="nav">
                            <p class="nav_right">90%</p>
                            <p class="nav_left">一次检样合格率</p>
                        </div>
                    </el-col>
                    <el-col :span="6">
                        <div class="nav">
                            <p class="nav_right">0.5%</p>
                            <p class="nav_left">差错率</p>
                        </div>
                    </el-col>
                    <el-col :span="6">
                        <div class="nav">
                            <p class="nav_right">96%</p>
                            <p class="nav_left">及时率</p>
                        </div>
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
            nowTime: '',
            nowDate: '',
            nowWeek: '',
            tableList: [
                {
                    tableData1: "2020-01-05",
                    tableData2: "聚山梨酯80",
                    tableData3: "20200101",
                    tableData4: "6",
                }, {
                    tableData1: "2020-01-01",
                    tableData2: "PEG 400",
                    tableData3: "20200102",
                    tableData4: "12",
                }, {
                    tableData1: "2020-01-01",
                    tableData2: "PEG 4000",
                    tableData3: "20200101",
                    tableData4: "12",
                }, {
                    tableData1: "2019-12-25",
                    tableData2: "聚山梨酯80",
                    tableData3: "20200101",
                    tableData4: "6",
                }, {
                    tableData1: "2019-12-20",
                    tableData2: "PEG 400",
                    tableData3: "20200102",
                    tableData4: "12",
                }, {
                    tableData1: "2019-12-18",
                    tableData2: "PEG 4000",
                    tableData3: "20200101",
                    tableData4: "12",
                }, {
                    tableData1: "2019-12-10",
                    tableData2: "聚山梨酯80",
                    tableData3: "20200102",
                    tableData4: "6",
                }, {
                    tableData1: "2019-12-08",
                    tableData2: "PEG 400",
                    tableData3: "20200102",
                    tableData4: "12",
                }, {
                    tableData1: "2019-12-07",
                    tableData2: "PEG 4000",
                    tableData3: "20200101",
                    tableData4: "12",
                },
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
            echart3.setOption(echartOption.option4)
        },
        getdateFormat() { //显示时间
            var _this = this;
            let wk = new Date().getDay()
            let yy = String(new Date().getFullYear())
            let mm = new Date().getMonth() + 1
            let dd = String(new Date().getDate() < 10 ? '0' + new Date().getDate() : new Date().getDate())
            let hou = String(new Date().getHours() < 10 ? '0' + new Date().getHours() : new Date().getHours())
            let min = String(new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes())
            let sec = String(new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds())
            let weeks = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
            let week = weeks[wk]

            _this.nowTime = hou + ':' + min + ':' + sec;
            _this.nowDate = yy + '/' + mm + '/' + dd
            _this.nowWeek = week
        },
        barActive() {
            let echart = this.$echarts.init(this.$refs.echart1);
            let index = -1 //高亮所在下标
            let index2 = -1 //高亮所在下标
            let dataLength = echartOption.option1.series[0].data.length
            let echart2 = this.$echarts.init(this.$refs.echart2);
            let dataLength2 = echartOption.option2.series[0].data.length
            setInterval(()=>{
                // 清除之前的高亮
                echart.dispatchAction({
                    type: 'downplay',
                    seriesIndex: 0,
                    dataIndex: index
                })
                index = (index + 1) % dataLength
                // 当前下标高亮
                echart.dispatchAction({
                    type: 'highlight',
                    seriesIndex: 0,
                    dataIndex: index
                })
				echart.dispatchAction({
					type: 'showTip',
					seriesIndex: 0,
					dataIndex: index
				});
                // 清除之前的高亮
                echart2.dispatchAction({
                    type: 'downplay',
                    seriesIndex: 0,
                    dataIndex: index2
                })
                index2 = (index2 + 1) % dataLength2
                // 当前下标高亮
                echart2.dispatchAction({
                    type: 'highlight',
                    seriesIndex: 0,
                    dataIndex: index2
                })
				echart2.dispatchAction({
					type: 'showTip',
					seriesIndex: 0,
					dataIndex: index2
				});
                if (index > dataLength) {
                    index = 0
                }
                if (index2 > dataLength2) {
                    index2 = 0
                }
            }, 2000)
        }
    },
    mounted() {
        // this.pageShow()
        this.getEchartData1()
        this.getEchartData2()
        this.getEchartData3()
        this.barActive()
		setInterval(() => {
            this.getdateFormat()
        }, 1000);
    },
    components: {
        nxFullScreen
    },
}
</script>

<style lang="scss" scoped>
@import '@/assets/style/statisticChart.scss'
</style>