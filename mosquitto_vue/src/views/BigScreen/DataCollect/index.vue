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
                <div class="nav-main nav-main1">
                    <div class="input_style">
                        <span class="left">设备编号</span>
                        <div class="right">{{formData.data1}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">数控系统</span>
                        <div class="right">{{formData.data2}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">运行模式</span>
                        <div class="right">{{formData.data3}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">轴名称</span>
                        <div class="right">{{formData.data4}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">所有刀具</span>
                        <div class="right">{{formData.data5}}</div>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">当前状态</span>
                        <div class="zll-botton bj">报警</div>
                    </div>
                    <div class="input_style">
                        <span class="left">时间戳</span>
                        <div class="right">{{formData.data6}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">程序名</span>
                        <div class="right">{{formData.data7}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">程序段</span>
                        <div class="right">{{formData.data8}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">当前刀具</span>
                        <div class="right">{{formData.data9}}</div>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">Relink</span>
                        <div class="right sh">
                            <!-- <div class="share">Relink</div> -->
                            <img class="share" src="@/assets/img/shing.png" alt="">
                        </div>
                    </div>
                    <div class="input_style"></div>
                    <div class="input_style">
                        <span class="left">主轴 ℃</span>
                        <div class="right">{{formData.data10}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">伺服轴 ℃</span>
                        <div class="right">{{formData.data11}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">编码器 ℃</span>
                        <div class="right">{{formData.data12}}</div>
                    </div>
                </div>
            </div>
            <div class="part-1">
                <div class="nav-main nav-main1">
                    <div class="input_style">
                        <span class="left">开机时长</span>
                        <div class="right">{{formData.data13}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">运行时长</span>
                        <div class="right">{{formData.data14}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">切削时长</span>
                        <div class="right">{{formData.data15}}</div>
                    </div>
                    <div class="input_style">
                        <span class="left">循环时长</span>
                        <div class="right">{{formData.data16}}</div>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style">
                        <span class="left">绝对位置</span>
                        <div class="right position">
                            <span class="item1">-85.775</span>
                            <span class="split">，</span>
                            <span class="item2">85.678</span>
                            <span class="split">，</span>
                            <span class="item1">287.815</span>
                        </div>
                    </div>
                    <div class="input_style">
                        <span class="left">相对位置</span>
                        <div class="right position">
                            <span class="item1">97.873</span>
                            <span class="split">，</span>
                            <span class="item2">-87.363</span>
                            <span class="split">，</span>
                            <span class="item1">-188.516</span>
                        </div>
                    </div>
                    <div class="input_style">
                        <span class="left">当前位置</span>
                        <div class="right position">
                            <span class="item1">97.873</span>
                            <span class="split">，</span>
                            <span class="item2">-87.363</span>
                            <span class="split">，</span>
                            <span class="item1">-188.516</span>
                        </div>
                    </div>
                    <div class="input_style">
                        <span class="left">进给量</span>
                        <div class="right position">
                            <span class="item1">0.0</span>
                            <span class="split">，</span>
                            <span class="item2">0.0</span>
                            <span class="split">，</span>
                            <span class="item1">0.0</span>
                        </div>
                    </div>
                </div>
                <div class="nav-main">
                    <div class="input_style"></div>
                    <div class="input_style">
                        <span class="left"></span>
                        <div class="right noBorder">
                            <span class="nav">转速</span>
                            <span class="nav">倍率</span>
                            <span class="nav">负载</span>
                        </div>
                    </div>
                    <div class="input_style">
                        <span class="left">主轴</span>
                        <div class="item">
                            <div class="right">{{formData.data21}}</div>
                            <div class="right right1">{{formData.data22}}</div>
                            <div class="right">{{formData.data23}}</div>
                        </div>
                    </div>
                    <div class="input_style">
                        <span class="left">进给</span>
                        <div class="item">
                            <div class="right">{{formData.data24}}</div>
                            <div class="right right1">{{formData.data25}}</div>
                            <div class="right">{{formData.data26}}</div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="part-2">
                <div class="nav-main">
                    <div class="nav1"><p class="nav">报警代码</p></div>
                    <div class="nav2"><p class="nav">代码类型</p></div>
                    <div class="nav3"><p class="nav">报警内容</p></div>
                </div>
                <div class="nav-main" v-for="(item,index) in formData.data27" :key="index">
                    <div class="nav1">
                        <div class="right nav">{{item.data1}}</div>
                    </div>
                    <div class="nav2">
                        <div class="right nav">{{item.data2}}</div>
                    </div>
                    <div class="nav3">
                        <div class="right nav">{{item.data3}}</div>
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