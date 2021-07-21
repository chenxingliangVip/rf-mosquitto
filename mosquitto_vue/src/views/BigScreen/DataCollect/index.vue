<template>
  <div class="DataCollect">
    <nx-full-screen class="allfull screenfull" style="float: right;position: relative;z-index: 1111;"></nx-full-screen>

    <div class="header">
      <p class="title">睿采智连 · 实时数据采集</p>
      <div class="header_left">
        <div :class="['zll-botton',item ==chooseTopic?'':'Info']"  v-for="(item,index) in topics" :key="index" @click="changeTopic(item)">{{item}}</div>
      </div>
      <div class="header_right">
        <div class="TimeForm">
          <p class="time">{{nowDate}} </p>
        </div>
        <div class="user">
          <span>admin</span>
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
            <div class="right">{{chooseMqtData.NCNum}}</div>
          </div>
          <div class="input_style">
            <span class="left">数控系统</span>
            <div class="right">{{chooseMqtData.Model}}</div>
          </div>
          <div class="input_style">
            <span class="left">运行模式</span>
            <div class="right">{{chooseMqtData.Mode}}</div>
          </div>
          <div class="input_style">
            <span class="left">轴名称</span>
            <div class="right">{{chooseMqtData.AxisNames}}</div>
          </div>
          <div class="input_style">
            <span class="left">所有刀具</span>
            <div class="right">{{chooseMqtData.ToolInUseAll}}</div>
          </div>
        </div>
        <div class="nav-main">
          <div class="input_style">
            <span class="left">当前状态</span>
            <div :class="['zll-botton',chooseMqtData.Status =='ALARM'?'bj':'']" >{{chooseMqtData.Status =='ALARM'?'报警':'正常'}}</div>
          </div>
          <div class="input_style">
            <span class="left">时间戳</span>
            <div class="right">{{chooseMqtData.TimeStamp}}</div>
          </div>
          <div class="input_style">
            <span class="left">程序名</span>
            <div class="right">{{chooseMqtData.ProgName}}</div>
          </div>
          <div class="input_style">
            <span class="left">程序段</span>
            <div class="right">{{chooseMqtData.PartNumber}}</div>
          </div>
          <div class="input_style">
            <span class="left">当前刀具</span>
            <div class="right">{{chooseMqtData.ToolInuse}}</div>
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
            <div class="right">{{chooseMqtData.SpindleTemperature}}</div>
          </div>
          <div class="input_style">
            <span class="left">伺服轴 ℃</span>
            <div class="right">{{chooseMqtData.ServoTemperature[0]}},{{chooseMqtData.ServoTemperature[1]}},{{chooseMqtData.ServoTemperature[2]}}</div>
          </div>
          <div class="input_style">
            <span class="left">编码器 ℃</span>
            <div class="right">{{chooseMqtData.EncoderTemperature[0]}},{{chooseMqtData.EncoderTemperature[1]}},{{chooseMqtData.EncoderTemperature[2]}}</div>
          </div>
        </div>
      </div>
      <div class="part-1">
        <div class="nav-main nav-main1">
          <div class="input_style">
            <span class="left">开机时长</span>
            <div class="right">{{chooseMqtData.PowerTime}}</div>
          </div>
          <div class="input_style">
            <span class="left">运行时长</span>
            <div class="right">{{chooseMqtData.OperatingTime}}</div>
          </div>
          <div class="input_style">
            <span class="left">切削时长</span>
            <div class="right">{{chooseMqtData.Cuttingtime}}</div>
          </div>
          <div class="input_style">
            <span class="left">循环时长</span>
            <div class="right">{{chooseMqtData.CycleTime}}</div>
          </div>
        </div>
        <div class="nav-main">
          <div class="input_style">
            <span class="left">绝对位置</span>
            <div class="right position">
              <span class="item1">{{chooseMqtData.AbsPosition[0]}}</span>
              <span class="split">，</span>
              <span class="item2">{{chooseMqtData.AbsPosition[1]}}</span>
              <span class="split">，</span>
              <span class="item1">{{chooseMqtData.AbsPosition[2]}}</span>
            </div>
          </div>
          <div class="input_style">
            <span class="left">相对位置</span>
            <div class="right position">
              <span class="item1">{{chooseMqtData.RelPosition[0]}}</span>
              <span class="split">，</span>
              <span class="item2">{{chooseMqtData.RelPosition[1]}}</span>
              <span class="split">，</span>
              <span class="item1">{{chooseMqtData.RelPosition[2]}}</span>
            </div>
          </div>
          <div class="input_style">
            <span class="left">当前位置</span>
            <div class="right position">
              <span class="item1">{{chooseMqtData.Position[0]}}</span>
              <span class="split">，</span>
              <span class="item2">{{chooseMqtData.Position[1]}}</span>
              <span class="split">，</span>
              <span class="item1">{{chooseMqtData.Position[2]}}</span>
            </div>
          </div>
          <div class="input_style">
            <span class="left">进给量</span>
            <div class="right position">
              <span class="item1">{{chooseMqtData.Distance[0]}}</span>
              <span class="split">，</span>
              <span class="item2">{{chooseMqtData.Distance[1]}}</span>
              <span class="split">，</span>
              <span class="item1">{{chooseMqtData.Distance[2]}}</span>
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
              <div class="right">{{chooseMqtData.Spindlerate}}</div>
              <div class="right right1">{{chooseMqtData.Spindlerateovr}}</div>
              <div class="right">{{chooseMqtData.Spindlerateload[0]}}</div>
            </div>
          </div>
          <div class="input_style">
            <span class="left">进给</span>
            <div class="item">
              <div class="right">{{chooseMqtData.Feedrate}}</div>
              <div class="right right1">{{chooseMqtData.Feedrateovr}}</div>
              <div class="right">{{chooseMqtData.Feedrateload[0]}},{{chooseMqtData.Feedrateload[1]}},{{chooseMqtData.Feedrateload[2]}}</div>
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
        <div class="nav-main" v-for="(item,index) in chooseMqtData.Alarms" :key="index">
          <div class="nav1">
            <div class="right nav">{{item.No}}</div>
          </div>
          <div class="nav2">
            <div class="right nav">{{item.Type}}</div>
          </div>
          <div class="nav3">
            <div class="right nav">{{item.Content}}</div>
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
        nowDate: '',
        allMqtMapDatas:{},
        chooseMqtData:{ServoTemperature:[0.0,0.0,0.0],Spindlerateovr:[0.0,0.0,0.0,0.0]},
        chooseTopic:'',
        topics:[],
      }
    },
    methods: {
      changeTopic(item){
        this.chooseTopic = item;
        let chooses = this.allMqtMapDatas[this.chooseTopic];
        this.chooseMqtData = chooses.length > 0 ?chooses[0]:self.chooseMqtData
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
        _this.nowDate = yy + '/' + mm + '/' + dd +" "+week+" "+hou + ':' + min + ':' + sec
      },
      loginOut() {
        sessionStorage.clear();
        this.$router.push({
          name: 'Login'
        })
      },

      getMqtData(){
        let self = this;
        self.$http({
          url: "/mosquitto/mqt/queryMqtContents",
          method: "post",
          params:{userId:self.userInfo.userId}
        }).then(resp => {
          if (resp.success) {
            self.topics = [];
            self.allMqtMapDatas = resp.result;
            for(let key in resp.result){
              self.topics.push(key);
            }
            if(self.topics.length > 0){
                self.chooseTopic = self.topics[0];
                let chooses = self.allMqtMapDatas[self.chooseTopic];
                self.chooseMqtData = chooses.length > 0 ?chooses[0]:self.chooseMqtData

            }
          }else{
            self.$notify({
              title: '提示',
              message: "获取MQTT数据异常！",
              type: 'error'
            });
          }
        });
      }
    },
    components: {
      nxFullScreen
    },
    mounted() {
      this.userInfo = this.$store.state.user.userInfo;
      setInterval(() => {
        this.getdateFormat()
      }, 1000);
      this.getMqtData();
    },
  }
</script>

<style lang="scss" scoped>
  @import './index.scss';
</style>
