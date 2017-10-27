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
	<div class="head_left">
		<img src="pic/logo.jpg" height="100">
	</div>
</body>
<div class="head_right">
	<b>管理员登录页面admin.jsp 用户名密码都是admin</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
	<a href="index.jsp" target="_top">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<s:if test="#session.users!=null">
		<a href="logOut.action" target="_top">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="toAdvancedQuery.action" target="_top">高级查询</a>
	</s:if>
	<s:else>
		<a href="login.jsp" target="_self">登录</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp" target="_self">注册</a>
	</s:else>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="showCart.jsp"
		target="_blank" >购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div></div>
	<br>



</div>










</html>