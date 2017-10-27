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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left"></div>
		<div class="right">
			<div style="padding-left: 200px;width: 600px;">	
				<s:form action="addOrUpdateGoods.action" method="post" enctype="multipart/form-data">
					<tr>
						<td></td>
						<td>请在此输入新花品的信息</td>
					</tr>
					
					<s:textfield label="品名" name="goods.goodsName"></s:textfield>
					
					<tr>
						<td>价格</td>
						<td><input type="text" name="goods.price"><label>元</label></td>
					</tr>
					<tr>
						<td>商品描述</td>
						<td><input type="text" name="goods.description"></td>
					</tr>
					<s:action name="browseCategory" executeResult="false"></s:action>
					
					<s:set value="#request.categorys" id="category"></s:set>
					<s:property value="#category.size"/>
					<!-- value="%{#goods.category.id}"中%{ }作用是告诉解释器，这之间的代码为OGNL表达式，这很有用。 -->
					<s:select label="分类" list="#request.categorys" listKey="id"
						listValue="categoryName" name="goods.category.id"
						value="%{#goods.category.id}"></s:select>
					
					<s:file name="upload" label="图片"></s:file>
					<s:submit value="添加"></s:submit>
				</s:form>
			</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</div>

</div>





</body>
</html>