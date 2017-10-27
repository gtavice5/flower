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
<link rel="stylesheet" type="text/css" href="css/jkxygoods.css">
<title>Insert title here</title>
</head>
<body>
	<div class="onegoods">
		<s:form theme="simple" action="shoppingAction" method="post">
			<img src="pic/<s:property value="#request.goods.imgUrl"/>"
				style="width: 400px; height: 400px;" />
			<br>
			<s:property value="#request.goods.goodsName" />
			<br>
			<s:property value="#request.goods.price" />元
<br>
<span>商品描述：</span><br>
<s:property value="#request.goods.description" /><br><br>
数量<s:textfield size="4" name="num"></s:textfield>
			<input type="hidden" name="id"
				value="<s:property value="#request.goods.id"/>" />
			<input type="hidden" name="goodsName"
				value="<s:property value="#request.goods.goodsName"/>" />
			<s:submit value="购买"></s:submit>
		</s:form>
	</div>



</body>
</html>