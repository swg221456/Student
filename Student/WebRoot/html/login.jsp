<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>高校人才资源管理平台</title>

	<!--图标样式-->
	<link rel="stylesheet" href="../layui/css/layui.css">
	<link rel="stylesheet" href="../css/login2.css">
	<link rel="stylesheet" href="../css/login.css">
	

<style>
	.bo1{ background:url("../image/login1.jpg") no-repeat 0px center}
	.bo2{ background:url("../image/login2.jpg") }
	{ background:url("../image/bd.jpg") no-repeat center center; background-size:100% 100%;-moz-background-size:100% 100%;}
</style>

</head>

<body>
<p id="Layer1" style="position:absolute; left:0px; top:0px; width:100%; height:100%"> 

	 <img src="../image/bd.jpg" width="100%" height="100%"/> 
	<div class="container" id="container">
	<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login">
		<div class="form-container sign-up-container ">
			
		</div>
		<div class="form-container sign-in-container ">
		
			<form class="layui-form" action="">
			<h2>学生信息管理系统</h2>
				<h1>登&nbsp录</h1>
				<input  id="user_name" name="user_name"  placeholder="账号" />
				<input  id="user_password" name="user_password" type="password" placeholder="密码" />
				
				<button class="layui-btn layui-btn-fluid" id="login-button" type="button">登录</button>
			</form>
		</div>
		<div class="overlay-container " >
			<div class="overlay">
				<div class="overlay-panel overlay-left bo1">
					
				</div>
				<div class="overlay-panel overlay-right bo2">
					
				</div>
			</div>
		</div>
		
      
	</div>
	</div>





	<script src="../js/jquery-3.3.1.js" ></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script src="../js/login.js"></script>
	
	
</body>

</html>