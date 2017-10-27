<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="ss" uri="/struts-dojo-tags"%>
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
<ss:head />
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCategory" executeResult="true"></s:action>
		</div>
		<div class="right">
			<div style="padding-left: 200px; width: 600px;">
				<s:form action="addUser.action" method="post">
					<s:textfield label="用户名" name="users.userName" />
					<s:password label="密码" name="users.password" />
					<s:textfield label="真实姓名" name="users.realName"></s:textfield>
					<s:textfield label="密保问题" name="users.pwdQuestion"></s:textfield>
					<s:textfield label="密保答案" name="users.pwdQuestionAnswer"></s:textfield>
					<s:textfield label="地址" name="users.address"></s:textfield>
					<s:textfield label="电话号码" name="users.phoneNO"></s:textfield>
					<s:textfield label="email" name="users.email"></s:textfield>
					<s:submit value="注册"></s:submit>
				</s:form>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</div>













</body>
</html>