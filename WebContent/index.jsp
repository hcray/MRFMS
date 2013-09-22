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
<script type="text/javascript">
	function ftn_submit(){
		var username = document.getElementById("id_userName").value;
		var password = document.getElementById("id_password").value;
		if(username == null || username == ""){
			alert("请输入用户名");
		}else if(password == null || password == ""){
			alert("请输入密码");
		}else{
			document.getElementsByName("loginform")[0].submit();
		}
	}

</script>
</head>
<body>
	<h2 align="center" style="margin: 60px 0 60px 0;">
		杭州酷蓝科技会议系统
	</h2>
	<form action="loginAction" method="post" name="loginform">
		<table width="100%">
			<tr>
				<td width="50%" style="text-align: right;">
					<label for="id_userName">名&nbsp;&nbsp;称：</label>
				</td>
				<td width="50%" style="text-align: left;">
					<input type="text" name="user.userName" id="id_userName" size="20"/>
				</td>
			</tr>
			<tr>
				<td width="50%" style="text-align: right;">
					<label for="id_password">密&nbsp;&nbsp;码：</label>
				</td>
				<td width="50%" style="text-align: left;">
					<input type="password" name="user.password" id="id_password" size="20"/>
				</td>
			</tr>
			<tr>
				<td width="50%" style="text-align: right;">
					<label for="id_verification">验证码：</label>
				</td>
				<td width="50%" style="text-align: left;">
					<input type="text" name="verification" id="id_verification"/>
				</td>
			</tr>
		</table>
		<div>
			<input type="button" value="登录" onclick="ftn_submit()">
		</div>
	</form>
	
</body>
</html>