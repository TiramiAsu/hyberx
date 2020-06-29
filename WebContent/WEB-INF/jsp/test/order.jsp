<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVC - from</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding: 5% 10%">
	<form:form modelAttribute="order" method="post"
		action="/hyberx/mvc/order/${action}">
		<fieldset>
			<legend>產 品 訂 單</legend>
			<form:input path="id" placeholder="default" readonly="true" class="form-control" /><br>
			<form:input path="name" placeholder="產品名稱" class="form-control" /><br>
			<form:input path="price" placeholder="價錢" class="form-control" /><br>
			<form:input path="remark" placeholder="附註" class="form-control" /><br>
			<button type="submit" class="btn btn-primary">${action}</button>
		</fieldset>
	</form:form>
	<p />
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>訂單名稱</th>
				<th>價錢</th>
				<th>備註</th>
				<th>建立日期</th>
				<th>修改日期</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${orders}">
				<tr scope="row">
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.price}</td>
					<td>${s.remark}</td>
					<td>${s.time_build}</td>
					<td>${s.time_modify}</td>
					<td>
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='/hyberx/mvc/order/find/${s.id}'">Update</button>
					<button type="button" class="btn btn-outline-danger"
						onclick="location.href='/hyberx/mvc/order/delete/${s.id}'">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" />
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" />
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" />
</body>
</html>