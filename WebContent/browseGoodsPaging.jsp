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
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">

			<s:action name="browseCategory" executeResult="true"></s:action>

		</div>
		<div class="right">
			<div></div>

			<s:iterator value="#request.goodsList" id="goods">
				<div class="newgoods">
					<s:form theme="simple" action="shoppingAction" method="post">
						<img src="pic/<s:property value="#goods.imgUrl"/>" 
						onclick="window.location.href='showOneGoods?goodsId=<s:property value="#goods.id"/>'"
						style="width: 100px;height: 100px;"/>
						<br>
						<s:property value="#goods.goodsName" />
						<br>
						<s:property value="#goods.price" />元
						<br>
						数量<s:textfield size="4" name="num"></s:textfield>
						<input type="hidden" name="id"
							value="<s:property value="#goods.id"/>" />
						<input type="hidden" name="goodsName"
							value="<s:property value="#goods.goodsName"/>" />
						<s:submit value="购买"></s:submit>
					</s:form>
				</div>
			</s:iterator>
			<div style="clear: both;">
			
				<s:set name="pager" value="#request.page" />
					<s:if test="#pager.hasFirst">
						<a href="browseGoodsPaging.action?currentPage=1">首页</a>
					</s:if>
					<s:if test="#pager.hasPrevious">
						<a href="browseGoodsPaging.action?currentPage=
							<s:property value="#pager.currentPage-1"/>">上一页</a>
						
					</s:if>
					<s:if test="#pager.hasNext">
						<a href="browseGoodsPaging.action?currentPage=
							<s:property value="#pager.currentPage+1"/>">下一页</a>
					</s:if>
					<s:if test="#pager.hasLast">
						<a href="browseGoodsPaging.action?currentPage=
							<s:property value="#pager.totalPage"/>">尾页</a>
					</s:if>
					<br>
					当前第
					<s:property value="#pager.currentPage"/>
					页，总共
					<s:property value="#pager.totalPage"/>
					页
			</div>

		</div>
	</div>
<jsp:include page="foot.jsp"></jsp:include>













</body>
</html>