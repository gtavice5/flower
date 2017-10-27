<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			<s:form theme="simple" action="goodsAdvancedQuery" method="post">
			<table>
				<tr>
					<td>商品分类：</td>
					<td><select name="categoryId">
					<s:iterator value="#request.categorys" id="category">
					<option value="<s:property value="#category.id"/>">
					<s:property value="#category.categoryName"/>
					</option>
					</s:iterator>
					</select><br></td>
				</tr>
				<tr>
					<td>商品名称：</td>
					<td><input type="text" name="goodsName"></td>
				</tr>
				<tr>
					<td>商品描述：</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td>价格大于：</td>
					<td><input type="text" name="higher"></td>
				</tr>
				<tr>
					<td>价格小于：</td>
					<td><input type="text" name="lower"></td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit value="查询"></s:submit></td>
				</tr>
			</table>
			</s:form>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>