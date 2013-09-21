<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<style type="text/css">
	label{
	cursor:pointer;
}
	div{
	margin: 5px;
	width: 100%;
	text-align: left;
}
</style>
</head>
<body>
	<h2 align="center" style="margin: 60px 0 60px 0;">
		杭州酷蓝科技会议系统
	</h2>
	<form action="<%=path %>/uploadAction" enctype="multipart/form-data" method="post">
		<div>
			<label for="id_uploadfile">文件上传</label>
			<input type="file" name="uploadfile" id="id_uploadifile"/>
		</div>
		<input type="submit" value="上传">
	</form>
	
</body>
</html>