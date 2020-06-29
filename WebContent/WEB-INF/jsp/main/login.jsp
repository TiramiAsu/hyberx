<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 5% 20%">
	<form:form modelAttribute="account" method="post"
		action="/hyberx/mvc/account/account_verify">
		<fieldset>
			<legend>Login From</legend>
			<form:input path="name" placeholder="Name" class="form-control" /><br>
			<form:password path="password" placeholder="Password" class="form-control" /><br>
			<button type="submit" class="btn btn-primary">登入</button>
			<button type="button" class="btn btn-outline-secondary"
						onclick="location.href='/hyberx/mvc/account/register'">註冊帳號</button>
		</fieldset>
	</form:form>
	<p />
	
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" />
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" />
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" />
</body>
</html>