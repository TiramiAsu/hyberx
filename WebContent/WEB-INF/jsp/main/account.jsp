<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 5% 20%">

	<form:form modelAttribute="account" method="post"
		action="/hyberx/mvc/account/${action}">
		<fieldset>
			<legend>Account From</legend>
			ID:
			<form:input path="id" placeholder="default" readonly="true"
				class="form-control" />
			<br> 帳號:
			<form:input path="name" placeholder="Name" class="form-control" />
			<br> 密碼:
			<form:password path="password" placeholder="Password" class="form-control" />
			<br> 會員編號:
			<form:input path="m_id.id" placeholder="MemberID" readonly="true" class="form-control" />
			<br> 會員狀態:
			<form:input path="status" placeholder="Status" readonly="true" class="form-control" /><br>
			登入錯誤次數:<form:input path="errorTimes" placeholder="Error-Times" readonly="true" class="form-control" /><br>
			<button type="submit" class="btn btn-primary">${action}</button>
		</fieldset>
	</form:form>
	<p />
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>MemberID</th>
				<th>Status</th>
				<th>Error-Times</th>
				<th>Opreate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${accounts}">
				<tr scope="row">
					<td>${a.id}</td>
					<td>${a.name}</td>
					<td>${a.m_id.id}</td>
					<td>${a.status}</td>
					<td>${a.errorTimes}</td>
					<td>
						<button type="button" class="btn btn-outline-primary"
							onclick="location.href='/hyberx/mvc/account/find/${a.id}'">Update</button>
						<button type="button" class="btn btn-outline-danger"
							onclick="location.href='/hyberx/mvc/account/delete/${a.id}'">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" />
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" />
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" />
</body>
</html>
