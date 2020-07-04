<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
=======
    pageEncoding="UTF-8"%>
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 5% 20%">
	register.jsp

	<form:form modelAttribute="account" method="post"
		action="/hyberx/mvc/account/${action}">
		<fieldset>
			<legend>Register From</legend>
			ID:
			<form:input path="id" placeholder="default" readonly="true"
				class="form-control" />
			<br> 帳號:
			<form:input path="name" placeholder="UserName" class="form-control" />
			<br> 密碼:
			<form:password path="password" placeholder="Password"
				class="form-control" />
			<br> 姓名:
			<form:input path="m_id.name" placeholder="MemberName"
				class="form-control" />
			<br> 地址:
			<form:input path="m_id.address" placeholder="Address"
				class="form-control" />
				<br> 電話:
			<form:input path="m_id.phone" placeholder="Address"
				class="form-control" />
			<br> E-Mail:
			<form:input path="m_id.email" placeholder="E-Mail"
				class="form-control" />
			<br>
			<button type="submit" class="btn btn-primary">${action}</button>
		</fieldset>
	</form:form>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" />
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" />
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" />
=======
</head>
<body>
register.jsp
>>>>>>> 9110d1d3f27cfde3bb720c39fd67ef7fa9b46be4
</body>
</html>
