<template>
    <div class="DataCollect">
		<nx-full-screen class="allfull screenfull" style="float: right;position: relative;z-index: 1111;"></nx-full-screen>
        
        <div class="header">
            <p class="title">睿采智连 · 实时数据采集</p>
            <div class="header_left">
                <div class="zll-botton">rfsys</div>
                <div class="zll-botton Info">T1</div>
                <div class="zll-botton Info">T2</div>
            </div>
            <div class="header_right">
                <div class="TimeForm">
                    <p class="time">{{nowDate}} {{nowWeek}} {{nowTime}} </p>
                </div>
                <div class="user">
                    <span>{{userName}}</span>
                    <span class="el-icon-caret-bottom"></span>
                    <div class="loginOut">
                        <p class="out" @click="loginOut">退出登录</p>
                    </div>
                </div> 
            </div>
        </div>

        <div class="main_contain">
            <div class="part-1">
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">设备编号</span>
                        <el-input class="right" v-model="formData.data1" placeholder="请输入设备编号"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">数控系统</span>
                        <el-input class="right" v-model="formData.data2" placeholder="请输入数控系统"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">运行模式</span>
                        <el-input class="right" v-model="formData.data3" placeholder="请输入运行模式"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">轴名称</span>
                        <el-input class="right" v-model="formData.data4" placeholder="请输入轴名称"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">所有刀具</span>
                        <el-input class="right" v-model="formData.data5" placeholder="请输入所有刀具"></el-input>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">当前状态</span>
                        <div class="zll-botton right bj">报警</div>
                    </div>
                    <div class="input_style">
                        <span class="left">时间戳</span>
                        <el-input class="right" v-model="formData.data6" placeholder="请输入时间戳"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">程序名</span>
                        <el-input class="right" v-model="formData.data7" placeholder="请输入程序名"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">程序段</span>
                        <el-input class="right" v-model="formData.data8" placeholder="请输入程序段"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">当前刀具</span>
                        <el-input class="right" v-model="formData.data9" placeholder="请输入当前刀具"></el-input>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">Relink</span>
                        <div class="right sh">
                            <div class="share">Relink</div>
                        </div>
                    </div>
                    <div class="input_style"></div>
                    <div class="input_style">
                        <span class="left">主轴 ℃</span>
                        <el-input class="right" v-model="formData.data10" placeholder="请输入主轴"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">伺服轴 ℃</span>
                        <el-input class="right" v-model="formData.data11" placeholder="请输入伺服轴"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">编码器 ℃</span>
                        <el-input class="right" v-model="formData.data12" placeholder="请输入编码器"></el-input>
                    </div>
                </div>
            </div>
            <div class="part-1">
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">开机时长</span>
                        <el-input class="right" v-model="formData.data13" placeholder="请输入开机时长"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">运行时长</span>
                        <el-input class="right" v-model="formData.data14" placeholder="请输入运行时长"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">切削时长</span>
                        <el-input class="right" v-model="formData.data15" placeholder="请输入切削时长"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">循环时长</span>
                        <el-input class="right" v-model="formData.data16" placeholder="请输入循环时长"></el-input>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">绝对位置</span>
                        <el-input class="right" v-model="formData.data17" placeholder="请输入绝对位置"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">相对位置</span>
                        <el-input class="right" v-model="formData.data18" placeholder="请输入相对位置"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">当前位置</span>
                        <el-input class="right" v-model="formData.data19" placeholder="请输入当前位置"></el-input>
                    </div>
                    <div class="input_style">
                        <span class="left">进给量</span>
                        <el-input class="right" v-model="formData.data20" placeholder="请输入进给量"></el-input>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style"></div>
                    <div class="input_style">
                        <span class="left"></span>
                        <div class="right">
                            <span class="nav">转速</span>
                            <span class="nav">倍率</span>
                            <span class="nav">负载</span>
                        </div>
                    </div>
                    <div class="input_style">
                        <span class="left">主轴</span>
                        <div class="right">
                            <el-input class="nav" v-model="formData.data21" placeholder="请输入转速"></el-input>
                            <el-input class="nav" v-model="formData.data22" placeholder="请输入倍率"></el-input>
                            <el-input class="nav" v-model="formData.data23" placeholder="请输入负载"></el-input>
                        </div>
                    </div>
                    <div class="input_style">
                        <span class="left">进给</span>
                        <div class="right">
                            <el-input class="nav" v-model="formData.data24" placeholder="请输入转速"></el-input>
                            <el-input class="nav" v-model="formData.data25" placeholder="请输入倍率"></el-input>
                            <el-input class="nav" v-model="formData.data26" placeholder="请输入负载"></el-input>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="part-2">
                <div class="nav-main">
                    <div class="nav1">报警代码</div>
                    <div class="nav2">代码类型</div>
                    <div class="nav3">报警内容</div>
                </div>
                <div class="nav-main" v-for="(item,index) in formData.data27" :key="index">
                    <div class="nav1">
                        <el-input class="nav" v-model="item.data1" placeholder=""></el-input>
                    </div>
                    <div class="nav2">
                        <el-input class="nav" v-model="item.data2" placeholder=""></el-input>
                    </div>
                    <div class="nav3">
                        <el-input class="nav" v-model="item.data3" placeholder=""></el-input>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import nxFullScreen from '@/components/nx-full-screen/index'
export default {
    data() {
        return {
            nowTime: '',
            nowDate: '',
            nowWeek: '',
            userName: '',
            formData: {
                data1:'600LA',
                data2:'FANUC',
                data3:'MEM',
                data4:'X，Y，Z',
                data5:'Null',
                data6:'2021-07-06  14:31:38',
                data7:'456',
                data8:'144',
                data9:'0',
                data10:'25',
                data11:'0,0,0',
                data12:'36,36,41',
                data13:'60:07:00',
                data14:'60:07:00',
                data15:'60:07:00',
                data16:'60:07:00',
                data17:'-85.775，   85.678，  287.815',
                data18:'97.873，  -87.363， -188.516',
                data19:'97.873，  -87.363， -188.516',
                data20:'0.0，  0.0， 0.0',
                data21:'0',
                data22:'80',
                data23:'12.8',
                data24:'0',
                data25:'0',
                data26:'0',
                data27: [
                    {data1: '100',data2: 'SW',data3: '繁体字乱码',},
                    {data1: '1001',data2: 'EX',data3: 'EMERGENCY STOP IS ACTIVATED',},
                    {data1: '12',data2: '',data3: '',},
                ] 
            }
        }
    },
    methods: {
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
        loginOut() {
            sessionStorage.clear();
             this.$router.push({
                name:'Login'
            })
        },
    },
    components: {
        nxFullScreen
    },
    mounted() {
		setInterval(() => {
            this.getdateFormat()
        }, 1000);

        let userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
        this.userName = userInfo.name
    },
}
</script>

<style lang="scss" scoped>
@import './index.scss';
</style>