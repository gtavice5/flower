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

	<s:iterator value="#request.categorys" id="category">
	<a href="browseGoodsPaging.action?categoryId=
	<s:property value="#category.id"/>&currentPage=1" 
	target="_self">
	<s:property value="#category.categoryName"/>
	</a>
	<br><br>
	</s:iterator>

</body>
</html>