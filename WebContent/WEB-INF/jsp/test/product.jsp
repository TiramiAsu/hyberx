<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Product - from</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<jsp:include page="../../include/head.jsp"></jsp:include>

</head>
<body>
<jsp:include page="../../include/nav.jsp"></jsp:include>
<div class="container-fluid">
  <div class="row">

   <jsp:include page="../../include/menu.jsp"></jsp:include>
   <div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
	<form:form modelAttribute="product" method="post"
		action="/hyberx/mvc/product/${action}">
		<fieldset>
			<legend>Product From</legend>
			<form:input path="id" placeholder="default" readonly="true" class="form-control" /><br>
			<form:input path="code" placeholder="Code" class="form-control" /><br>
			<form:input path="company.id" placeholder="Company" class="form-control" /><br>
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
				<th>Order</th>
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
					<td>${s.company.id}</td>
					 <c:set value="${s.orders }" var="subItem"/>
					      <c:forEach items="${subItem }" var="var">
					      ${var.name }<br />
					      </c:forEach>
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
	
	
	</div></div>
	</div>
	<jsp:include page="../../include/foot.jsp"></jsp:include>
</body>
</html>