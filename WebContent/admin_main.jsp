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
<title>管理员菜单</title>
</head>
<body>
	<a href="<%=basePath %>index.jsp">首页</a><br><br>
	<a href="<%=basePath %>addNewGoods.jsp" target="_blank">添加新花品</a><br><br>
	<a href="manageGoods.action" target="_blank">管理花品</a><br><br>
	<a href="logOut.action" target="_top">注销</a>
</body>
</html>