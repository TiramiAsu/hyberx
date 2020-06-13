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
<body style="padding: 5% 20%">
	<form:form modelAttribute="product" method="post"
		action="/hyberx/mvc/product/${action}">
		<fieldset>
			<legend>Student From</legend>
			<form:input path="id" placeholder="default" readonly="true" class="form-control" /><br>
			<form:input path="code" placeholder="Code" class="form-control" /><br>
			<form:input path="company" placeholder="Company" class="form-control" /><br>
			<form:input path="name" placeholder="Name" class="form-control" /><br>
			<form:input path="cost" placeholder="Cost" class="form-control" /><br>
			<form:input path="type" placeholder="Type" class="form-control" /><br>
			<form:input path="area" placeholder="Area" class="form-control" /><br>
			<button type="submit" class="btn btn-primary">${action}</button>
		</fieldset>
	</form:form>
	<p />
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Code</th>
				<th>Company</th>
				<th>Name</th>
				<th>Cost</th>
				<th>Type</th>
				<th>Area</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${products}">
				<tr scope="row">
					<td>${s.id}</td>
					<td>${s.code}</td>
					<td>${s.company}</td>
					<td>${s.name}</td>
					<td>${s.cost}</td>
					<td>${s.type}</td>
					<td>${s.area}</td>
					<td>
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='/hyberx/mvc/product/find/${s.id}'">Update</button>
					<button type="button" class="btn btn-outline-danger"
						onclick="location.href='/hyberx/mvc/product/delete/${s.id}'">Delete</button>
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