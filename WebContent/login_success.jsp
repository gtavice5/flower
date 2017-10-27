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
	<s:if test="#session.role.equals('admin')">
	<jsp:forward page="admin_main.jsp"></jsp:forward>
	</s:if>
	<s:elseif test="#session.role.equals('users')">
	<jsp:forward page="index.jsp"></jsp:forward>
	</s:elseif>
</body>
</html>