<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%	String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/style/style.css">
<title>杭州酷蓝科技会议系统</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.1.js"></script>
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
	//上传文件
	function ftn_upload(){
		window.open ('<%=path%>/pages/upload.jsp','newwindow','height=550,width=550,top=100,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')
	}
	
	//删除文件
	function deleteFile(td){
		var filepath = $(td).parent("td").parent("tr").children("td").first().next().next().next().html();
		$("#id_filepath").val(filepath);
		document.getElementsByName("deleteFrom")[0].submit();
	
	}
</script>
</head>
<body>
	<h2 align="center" style="margin: 60px 0 60px 0;">
		杭州酷蓝科技会议系统
	</h2>
	<table width="100%" class="standardTb">
		<tr>
			<td class="standardTd">文件名</td>
			<td class="standardTd">所有者</td>
			<td class="standardTd">路径</td>
			<td class="standardTd">操作</td>
		</tr>
		<s:iterator value="fileList" status="fileBean">
		<tr>
			<td class="standardTd">
				<s:property value="fileName"/>
			</td>
			<td class="standardTd">
				<s:property value="fileOwner"/>
			</td>
			<td class="standardTd">
			<s:property value="filePath"/>
			</td>
			<td class="standardTd">
				<a href="deleteFileAction?fileName=<s:property value="fileName"/>">删除</a>
				<a href="download.action?fileName=<s:property value="fileName"/>">下载</a>
			</td>
		</tr>	
		</s:iterator> 
	</table>
	文件上传：
	<a href="<%=path %>/pages/upload.jsp">上传文件</a>
	<form action="<%=path%>/deleteFileAction" method="post" name="deleteFrom">
		<input type="hidden" name="filePath" id="id_filepath"/>
	</form>
	
</body>
</html>