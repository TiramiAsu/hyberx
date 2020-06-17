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

	<form:form modelAttribute="member" method="post"
		action="/hyberx/mvc/member/${action}">
		<fieldset>
			<legend>Member From</legend>
			ID:<form:input path="id" placeholder="${id }" readonly="true"
				class="form-control" /><br>
			名稱:<form:input path="name" placeholder="Name" class="form-control" /><br>
			地址:<form:input path="address" placeholder="Address" class="form-control" /><br>
			電話:<form:input path="phone" placeholder="Phone" class="form-control" /><br>
			E-mail:<form:input path="email" placeholder="E-Mail" class="form-control" /><br>
			<button type="submit" class="btn btn-primary">${action}</button>
		</fieldset>
	</form:form>
	<p />
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>E-Mail</th>
				<th>Opreate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${members}">
				<tr scope="row">
					<td>${m.id}</td>
					<td>${m.name}</td>
					<td>${m.address}</td>
					<td>${m.phone}</td>
					<td>${m.email}</td>
					<td>
						<button type="button" class="btn btn-outline-primary"
							onclick="location.href='/hyberx/mvc/member/find/${m.id}'">Update</button>
					<button type="button" class="btn btn-outline-danger"
							onclick="location.href='/hyberx/mvc/member/delete/${m.id}'">Delete</button>
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