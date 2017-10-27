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
			<div style="padding-left: 200px; width: 600px;">
				<s:action name="browseCategory" executeResult="false" />
				<s:set value="#request.goods" id="goods"></s:set>
				<s:form action="addOrUpdateGoods.action" method="post"
					enctype="multipart/form-data">
					<tr>
						<td></td>
						<td>请在此修改花品的信息</td>
					</tr>

					<!-- 使用struts标签value赋值 struts标签里面内部不能再套struts标签赋值-->
					<s:textarea label="品名" name="goods.goodsName"
						value="%{#goods.goodsName}"></s:textarea>
					<!-- 不使用struts标签value赋值 -->
					<tr>
						<td>价格</td>
						<td><input type="text" name="goods.price"
							value="<s:property value="#goods.price"/>"><label>元</label></td>
					</tr>
					<tr>
						<td>商品描述</td>
						<td><input type="text" name="goods.description"
							value="<s:property value="#goods.description"/>"></td>
					</tr>
					<s:set value="#request.categorys" id="category"></s:set>
					<s:select label="分类" list="#category" listKey="id"
						listValue="categoryName" name="goods.category.id"
						value="%{#goods.category.id}"></s:select>
					<tr>
						<td></td>
						<td><input type="file" name="upload"
							value="<s:property value="#goods.imgUrl"/>"> <img
							alt="" src="pic/<s:property value="#goods.imgUrl"/>"
							style="width: 200px;height: 200px;"></td>
					</tr>
					<s:hidden name="goods.id" value="%{#goods.id}"></s:hidden>
					<s:hidden name="picture" value="%{#goods.imgUrl}"></s:hidden>
					原picturename:<input type="text" value="<s:property value="#goods.imgUrl"/>">

					<s:submit value="修改"></s:submit>
				</s:form>
			</div>










		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>

</body>
</html>