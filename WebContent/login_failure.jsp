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
login failure!<br>
<span><s:property value="%{#request.msg}"/></span>

	<s:if test="#session.role.equals('admin')">
	<jsp:forward page="admin.jsp"></jsp:forward>
	</s:if>
	<s:elseif test="#session.role.equals('users')">
	<jsp:forward page="login.jsp"></jsp:forward>
	</s:elseif>
</body>
</html>