<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%	String path = request.getContextPath(); %>
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
</style>
</head>
<body>
	<h2 align="center" style="margin: 60px 0 60px 0;">
		杭州酷蓝科技会议系统
	</h2>
	<table border="1" width="100%">
		<tr>
			<td>文件名</td>
			<td>所有者</td>
			<td>路径</td>
			<td>操作</td>
		</tr>
		<s:iterator value="fileList" status="fileBean">
		<tr>
			<td>
				<s:property value="fileName"/>
			</td>
			<td>
				<s:property value="fileOwner"/>
			</td>
			<td>
			<s:property value="filePath"/>
			</td>
			<td>
				&nbsp;
			</td>
		</tr>	
		</s:iterator> 
	</table>
	文件上传：
	<a href="<%=path %>/pages/upload.jsp">上传文件</a>
	
</body>
</html>