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
<title>首页</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
		<s:action name="browseCategory" executeResult="true"></s:action>
		</div>
		<div class="right">
		<s:action name="browseNewGoods" executeResult="true"></s:action>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>