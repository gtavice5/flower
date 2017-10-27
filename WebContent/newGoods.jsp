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
<link rel="stylesheet" type="text/css" href="css/jkxygoods.css">
<title>Insert title here</title>
</head>
<body>
<div>
<div>新品展示</div><br>
<s:set value="#request.newGoodsList" id="newGoods"></s:set>
<s:iterator value="#newGoods" id="goods">
<div class="newgoods">
<s:form theme="simple" action="shoppingAction" method="post">
<img src="pic/<s:property value="#goods.imgUrl"/>" 
onclick="window.location.href='showOneGoods?goodsId=<s:property value="#goods.id"/>'"
style="width: 100px;height: 100px;"/>
<br>
<s:property value="#goods.goodsName"/>
<br>
<s:property value="#goods.price"/>元
<br>
数量<s:textfield size="4" name="num"></s:textfield>
<input type="hidden" name="id" value="<s:property value="#goods.id"/>" />
<input type="hidden" name="goodsName" value="<s:property value="#goods.goodsName"/>" />
<s:submit value="购买"></s:submit>
</s:form>
</div>
</s:iterator>
</div>



</body>
</html>