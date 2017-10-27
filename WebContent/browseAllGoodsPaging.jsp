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
	<div class="content">
		<div class="left">
		</div>
		<div class="right">
			<s:iterator value="#request.goodsList" id="goods">
			<div class="newgoods">
			<form action="goodsAction" method="post">
			<img src="pic/<s:property value="#goods.imgUrl"/>" style="width: 100px;height: 100px;"/>
			<br>
			<s:property value="#goods.goodsName"/>
			<br>
			<s:property value="#goods.price"/>元
			<br>
			<input type="hidden" name="goodsId" value="<s:property value="#goods.id"/>">
			<input type="hidden" name="goodsName" value="<s:property value="#goods.goodsName"/>">
			<!-- this代表html控件本身, .form代表这个控件所在的form, .action代表这个form的action -->
			<input type="submit" value="修改" onclick="this.form.action='displayOneGoods'">
			<input type="submit" value="删除" onclick="this.form.action='deleteOneGoods'">
			</form>
			</div>
			</s:iterator>
			
			
			
			
			
			
			
			
			
			
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</div>
</body>
</html>