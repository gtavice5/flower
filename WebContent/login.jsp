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
<jsp:include page="head.jsp"></jsp:include>
<div style="clear: both;float: right; padding-top: 100px;padding-right: 500px;">
<div>
	<s:property value="#request.msg"/><br><br>
	用户登录
	
	<s:form action="checkUser" method="post">
		<s:textfield name="users.userName"></s:textfield>
		<s:password name="users.password"></s:password>
		<s:hidden name="role" value="users"></s:hidden>
		<s:submit></s:submit>
	</s:form>
</div>




</div>







</body>
</html>