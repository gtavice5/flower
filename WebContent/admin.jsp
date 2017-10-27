<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center;">
	
	<s:form action="checkUser" method="post">
		<s:textfield name="admin.username"></s:textfield>
		<s:password name="admin.password"></s:password>
		<s:hidden name="role" value="admin"></s:hidden>
		<s:submit></s:submit>
	</s:form>




</div>







</body>
</html>