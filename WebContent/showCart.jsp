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
		<div class="left">

			<s:action name="browseCategory" executeResult="true"></s:action>

		</div>
		<div class="right">
			<s:set value="#session.cart.items" id="items"></s:set>
			<s:if test="#items.size!=0">
				<s:iterator value="#items" id="item">
					<div style="text-align: left;">
						<s:form action="updateCart.action" method="post">
							<!-- value代表泛型里面的键值对的V值 -->
							<div class="goodscheck">
								花名：
								<s:property value="value.goodsName" />
							</div>
							<div class="goodscheck">
								价格：
								<s:property value="value.price" />
							</div>
							<div class="goodscheck">
								数量：
								<input size="4" type="text" name="num" value="<s:property value="value.num"/>">
							</div>
							<input type="hidden" name="id" value="<s:property value="value.id"/>">
							<input type="hidden" name="goodsName" value="<s:property value="value.goodsName"/>">
							<div class="goodscheck"><input type="submit" value="更新"></div>
							
						</s:form>
						<form action="checkOut.action"><input type="submit" value="提交订单"></form>
					</div>
				</s:iterator>
			</s:if>
			<s:else>
			购物车里还没有鲜花！
		</s:else>
		</div>
		
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>