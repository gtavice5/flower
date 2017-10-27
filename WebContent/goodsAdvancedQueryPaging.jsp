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
			<form action="shoppingAction" method="post">
			<img src="pic/<s:property value="#goods.imgUrl"/>" style="width: 100px;height: 100px;"/>
			<br>
			<s:property value="#goods.goodsName"/>
			<br>
			<s:property value="#goods.price"/>元
			<br>
			数量<s:textfield size="4" name="num"></s:textfield>
			<br>
			<input type="hidden" name="id" value="<s:property value="#goods.id"/>">
			<input type="hidden" name="goodsName" value="<s:property value="#goods.goodsName"/>">
			<!-- this代表html控件本身, .form代表这个控件所在的form, .action代表这个form的action -->
			<s:submit value="购买"></s:submit>
			</form>
			</div>
			</s:iterator>
			
			
			
			
			
			
			
			
			
			
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript">
	var msg = "${requestScope.tipMessage}";
	if (msg != "") {
		alert(msg);
	}
</script>
</html>