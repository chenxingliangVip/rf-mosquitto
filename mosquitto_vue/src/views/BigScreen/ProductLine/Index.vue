<template>
    <div class="ProductLine" v-bind:style="style">
		<nx-full-screen class="allfull screenfull" style="float: right"></nx-full-screen>
        <div class="header">
            <p>威尔药业 · 产线实时看板</p>
        </div>
        <div class="main_contain">
            <el-row :gutter="10">
                <el-col :span="8" class="col_list">
                    <p class="tab_name">
                        <span class="name">名称：</span>
                        <span class="value">聚山梨酯20</span>
                    </p>
                    <p class="tab_name">
                        <span class="name">规格：</span>
                        <span class="value">药用级</span>
                    </p>
                    <p class="tab_name">
                        <span class="name">编码：</span>
                        <span class="value">E010232</span>
                    </p>
                </el-col>
                <el-col :span="8" class="col_list">
                    <p class="tab_name">
                        <span class="name">开始时间：</span>
                        <span class="value"></span>
                    </p>
                    <p class="tab_name">
                        <span class="name">结束时间：</span>
                        <span class="value"></span>
                    </p>
                </el-col>
                <el-col :span="8" class="col_list">
                    <p class="tab_name">
                        <span class="name">开始时间：</span>
                        <span class="value"></span>
                    </p>
                    <p class="tab_name">
                        <span class="name">结束时间：</span>
                        <span class="value"></span>
                    </p>
                </el-col>
            </el-row>
            <div class="progress">
                <h1>P191212028    <span>/</span>    聚合生产线·JD01</h1>
                <div class="echart" ref="echart"></div>
            </div>
            <el-row :gutter="10">
                <el-col :span="12" class="col_list">
                    <p class="tab_name">
                        <span class="name">生产部门：</span>
                        <span class="value">2部</span>
                    </p>
                    <p class="tab_name">
                        <span class="name">生产部门：</span>
                        <span class="value">2组</span>
                    </p>
                </el-col>
                <el-col :span="12" class="col_list">
                    <p class="tab_name">
                        <span class="name">班  次：</span>
                        <span class="value">白班 08:00 – 16:00</span>
                    </p>
                    <p class="tab_name">
                        <span class="name">负责人：</span>
                        <span class="value">徐小伟</span>
                    </p>
                </el-col>
            </el-row>
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
        getEchartData() {  //进度条
            let echart = this.$echarts.init(this.$refs.echart);
            echart.setOption(echartOption.option)
        },
    },
    mounted() {
        // this.pageShow()
        this.getEchartData()
    },
    components: {
        nxFullScreen
    },
}
</script>

<style lang="scss" scoped>
@import '@/assets/style/ProductLine.scss'
</style>