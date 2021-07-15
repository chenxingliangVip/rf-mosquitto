<template>
	<div class="Login">
		<div class="Header">
			<h3>
				<img class="logo_img" src="@/assets/img/Login_logo.png">
				<i></i>
				睿采智连
			</h3>
            <div class="header_top_title">
                <span>2020©睿孚科技</span>
                <span class="split">/</span>
                <span>睿采智连数据采集测试端</span>
            </div>
		</div>
		<div class="device_img">
			<img src="@/assets/img/Login_device.png"/>
		</div>
		<div class="loginBody login_input">
			<div class="login-top">
				<div class="tab">
					睿采智连· ReLink
				</div>
			</div>
			<el-form ref="LoginForm" class="demo-ruleForm">
				<el-form-item>
					<el-input v-model="LoginForm1.name" placeholder="请输入用户名" class="loginInput">
						<i slot="prefix" class="el-input__icon el-icon-user"></i>
					</el-input>
				</el-form-item>
				<el-form-item prop="password">
					<el-input type="password" v-model="LoginForm1.password" autocomplete="off" show-password placeholder="请输入密码" @keyup.enter.native="LoginSubmit" class="loginInput">
						<i slot="prefix" class="el-input__icon el-icon-lock"></i>
					</el-input>
				</el-form-item>
				<div class="login-button" @click="LoginSubmit">登 录</div>
			</el-form>
		</div>
		<div class="footer">
			<p>Copyright 2019 © Refull All rights reserved    建议使用“Chrome / IE / 搜狗高速” 浏览器</p>
		</div>
	</div>
</template>

<script>
    import {getRoutePages} from '@/router'
	export default {
		name: 'Login',
		data() {
			return {
				tabType: 1,
				LoginForm1: {
					name: '',
					password: '',
					type: 1,
				},
			}
		},
		methods:{
			LoginSubmit(){
                if(this.LoginForm1.name){
                    if(this.LoginForm1.password){
                        //登录成功
                        sessionStorage.setItem('loginStatus',1) //设置登录状态为已登录
                        sessionStorage.setItem('userInfo', JSON.stringify(this.LoginForm1)) //记录登录信息

                        this.$router.addRoutes([getRoutePages()])//添加路由
                        this.$router.push({
                            name:'DataCollect'
                        })
                        return;
                    }
                    this.$message.error('密码不能为空!');
                    return;
                }else{
                    this.$message.error('用户名不能为空!');
                }
			}
		},
	}
</script>

<style scoped lang="scss">
	.Login {
		background-image: url(../assets/img/banner_bg1.png);
		height: 100%;
		background-size: cover;
		position: relative;
		.Header {
			height: 60px;
			line-height: 60px;
			color: #e31d1a;
			background: rgba(255, 255, 255, .8);
            position: relative;
			h3 {
				width: 100%;
				margin: 0 auto;padding: 0 170px;
				font-size: 22px;
				font-weight: normal;
                position: relative;
                font-family: SimHei;
			}
			span {
				font-weight: 400;
				float: right;
                color: #34bfc6;
			}
			.logo_img {
                position: absolute;
				top: 14px;
                left: 100px;
			}
            .header_top_title {
                position: absolute;
                right: 10px;
                top: 0;
                color: #666;
                font-size: 12px;
                .split {
                    margin: 0 10px;
                }
            }
		}
		.device_img {
			position: absolute;
			top: 50vh;
			left: 15%;
			img {
				height: 100px;
			}
		}
		.loginBody {
			width: 450px;
			position: absolute;
    		right: 15%;
			top: 30vh;
			height: 280px;
			background-color: rgba(255, 255, 255, 1);
            box-shadow: 0 0 20px #34bfc6;    
            padding: 20px;
			.login-top {
				box-sizing: border-box;
				margin-bottom: 20px;
                text-align: center;
                display: flex;
                font-size: 14px;
                color: #c7c7c7;
                .tab {
                	width: 100%;
                	text-align: center;
                	cursor: pointer;
					color: #34bfc6;
                    font-size: 22px;
                }
                .split {
                	width: 20%;
                }
			}
			.login-button {
				cursor: pointer;
				width: 100%;
				text-align: center;
				padding: 10px 0px;
				background-color: #34bfc6;
				margin: 30px auto auto;
				color: #FFFFFF;
				font-size: 14px;
				border-radius: 30px;
				&:active{
                    opacity: 0.8;
                }
            }
            .el-form {
                padding: 0 30px;
            }
		}
		.footer {
			color: #ffffff;
			position: fixed;
			bottom: 0px;
			width: 100%;
			padding: 10px;
			p {
				text-align: center;
			}
		}
	}
</style>
