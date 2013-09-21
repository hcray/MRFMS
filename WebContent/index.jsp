<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>杭州酷蓝科技会议系统</title>
<style type="text/css">
	label{
	cursor:pointer;
}
	div{
	margin: 5px;
	width: 100%;
	text-align: center;
}
body {
	background-color: #4682B4;
}
</style>
</head>
<body>
	<h2 align="center" style="margin: 60px 0 60px 0;">
		杭州酷蓝科技会议系统
	</h2>
	<form action="loginAction" method="post">
		<div style="margin: 10px; width: 60%; text-align: right;">
			<label for="id_loginName">名称：</label>
			<input type="text" name="user.userName" id="id_userName" size="20"/>
		</div>
		<div style="margin: 10px; width: 60%; text-align: right;">
			<label for="id_password">密码：</label>
			<input type="password" name="user.password" id="id_password" size="20"/>
		
		</div>
		<div style="margin: 10px; width: 60%; text-align: right;">
			<label for="id_verification">验证码：</label>
			<input type="text" name="verification" id="id_verification"/>
		</div>
		<div>
			<input type="submit" value="登录">
		</div>
	</form>
	
</body>
</html>