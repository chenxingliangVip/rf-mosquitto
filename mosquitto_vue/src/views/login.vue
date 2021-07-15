<template>
	<div class="Login">
		<div class="Header">
			<h3>
				<img class="logo_img" src="@/assets/img/logo_icon.png">
				<i></i>
				威尔生产运营管理系统
				<span>欢迎您，请登录</span>
			</h3>
		</div>
		<div class="LoginBody Login_input">
			<div class="Login-top">威尔生产运营管理系统</div>
			<el-form :model="LoginForm" ref="LoginForm" class="demo-ruleForm LoginForm">
				<el-form-item>
					<el-input v-model="LoginForm.name" placeholder="请输入用户名" class="LoginInput">
						<i slot="prefix" class="el-input__icon el-icon-user"></i>
					</el-input>
				</el-form-item>
				<el-form-item prop="password">
					<el-input type="password" v-model="LoginForm.password" autocomplete="off" show-password placeholder="请输入密码" @keyup.enter.native="LoginSubmit" class="LoginInput">
						<i slot="prefix" class="el-input__icon el-icon-lock"></i>
					</el-input>
				</el-form-item>
				<el-form-item prop="password">
					<el-checkbox class="remember" v-model="LoginForm.remember">记住用户</el-checkbox>
				</el-form-item>
					<div class="Login-button" @click="LoginSubmit">登 录</div>
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
				LoginForm: {
					name: '',
					password: '',
					remember: false
				},
			}
		},
		methods:{
			LoginSubmit(){
        let self = this;
        let param = {userAccount:self.LoginForm.name,password:self.LoginForm.password};
        self.$http({
          url: "/mosquitto/login",
          method: "post",
          params:param
        }).then(resp => {

        });
			}
		},
	}
</script>

<style scoped lang="scss">
	$baseColor: #34BFC6;
	.Login {
		background-image: url(../assets/img/banner_bg2.png);
		height: 100%;
		background-size: cover;
		width: 100%;
		.Header {
			height: 60px;
			line-height: 60px;
			color: #fff;
			background: #368ae0;
			h3 {
				width: 100%;
				margin: 0 auto;padding: 0 100px;
				font-size: 24px;
				font-weight: normal;
			}
			span {
				font-size: 14px;
				font-weight: 400;
				float: right;
			}
			.logo_img {
				height: 60px;
				float: left;
			}
		}
		.LoginBody {
			width: 600px;
			margin: 0 auto;
			height: 380px;
			background-color: rgba(241,169,169, 0.8);
			margin-top: calc(50vh - 280px);
			box-shadow: 0 0 20px #ffffff;
			padding: 40px 50px;
			border-radius: 10px;
			.Login-top {
				font-size: 24px;
				box-sizing: border-box;
				color: #ffffff;
				margin-bottom: 30px;
				text-align: center;
			}
			.Login-button {
				cursor: pointer;
				width: 80%;
				text-align: center;
				padding: 10px 0px;
				background-color: $baseColor;
				margin: 0 auto;
				color: #ffffff;
				font-size: 14px;
				border-radius: 25px;
				&:active{
                    opacity: 0.8;
                }
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
