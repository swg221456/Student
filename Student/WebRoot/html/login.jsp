<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息管理</title>

	<!--图标样式-->
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="。。/css/login2.css">


</head>

<body>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="adduser.action" class="layui-form">
				<h1>注&nbsp册</h1>
				<input id="account" name="account" type="text" placeholder="账号" />
				<input  id="pwd" name="pwd" type="password" placeholder="密码" />
				<div class="usertype layui-input-inline">
					<select  id="usetype" name="usertype" lay-verify="required">
						<option value="1">请选择用户类型</option>
						<option value="2" selected="2">学生用户</option>
						<option value="3" selected="3">教师用户</option>
					</select>
				</div>
				<button>注册</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="login.action">
				<h1>登&nbsp录</h1>
				<input  id="account" name="account"  placeholder="账号" />
				<input  id="pwd" name="pwd" type="password" placeholder="密码" />
				<a href="#">忘记密码？</a>
				<button>登录</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>欢迎回来！</h1>
					<p>您需要先登录，才能进行操作。</p>
					<button class="ghost" id="signIn">登录</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>你好朋友！</h1>
					<p>还没有账号？点击下方按钮进行注册。</p>
					<button class="ghost" id="signUp">注册</button>
				</div>
			</div>
		</div>
	</div>



	<script src="。。/js/login.js"></script>
	<script src="。。/layui/layui.all.js"></script>


</body>

</html>