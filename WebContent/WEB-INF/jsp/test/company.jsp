<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Company - from</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<jsp:include page="../../include/head.jsp"></jsp:include>

</head>
<body>
<jsp:include page="../../include/nav.jsp"></jsp:include>
<div class="container-fluid">
  <div class="row">

   <jsp:include page="../../include/menu.jsp"></jsp:include>
   <div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<form:form modelAttribute="company" method="post"
		action="/hyberx/mvc/company/${action}">
		<fieldset>
			<legend>Company From</legend>
			<form:input path="id" placeholder="default" readonly="true" class="form-control" /><br>
			<form:input path="name" placeholder="Name" class="form-control" /><br>
			<form:input path="address" placeholder="Address" class="form-control" /><br>
			<form:input path="phone" placeholder="Phone" class="form-control" /><br>
			<form:input path="email" placeholder="Email" class="form-control" /><br>
			<form:input path="contact_man" placeholder="Contact_man" class="form-control" /><br>
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
				<th>Email</th>
				<th>Contact_man</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${companys}">
				<tr scope="row">
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.address}</td>
					<td>${s.phone}</td>
					<td>${s.email}</td>
					<td>${s.contact_man}</td>
					<td>
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='/hyberx/mvc/company/find/${s.id}'">Update</button>
					<button type="button" class="btn btn-outline-danger"
						onclick="location.href='/hyberx/mvc/company/delete/${s.id}'">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" />
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" />
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" />
	
	
	</div></div>
	</div>
	<jsp:include page="../../include/foot.jsp"></jsp:include>
</body>
</html>