<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<meta charset="UTF-8">
<title>[ TEST ] Student</title>

<jsp:include page="../../include/head.jsp"></jsp:include>

</head>
<body><%--  style="padding: 5% 20%" --%>
	<jsp:include page="../../include/nav.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<jsp:include page="../../include/menu.jsp"></jsp:include>

			<!-- Main -->
			<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<form:form modelAttribute="studentVo" method="post"
					action="${(apis.addUrl != null) ? apis.addUrl : apis.modifyUrl}">
					<fieldset>
						<legend>Student From</legend>
						<form:input path="student.id" placeholder="default"
							readonly="true" class="form-control" />
						<br>
						<form:input path="basicInfo.name" placeholder="Name"
							class="form-control" />
						<br>
						<form:input path="basicInfo.age" placeholder="Age"
							class="form-control" />
						<br>
						<button type="submit" class="btn btn-primary">${(apis.addName != null) ? apis.addName : apis.modifyName}</button>
						<button type="button" class="btn btn-primary"
							onclick="location.href='${apis.cancelUrl}'">${apis.cancelName}</button>
					</fieldset>
				</form:form>
				<p />
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Age</th>
							<th>Opreate</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${students}">
							<tr scope="row">
								<td>${s.id}</td>
								<td>${s.basicInfo.name}</td>
								<td>${s.basicInfo.age}</td>
								<td>
									<button type="button" class="btn btn-outline-primary"
										onclick="location.href='/hyberx/mvc/student/find/${s.id}'">${apis.findName}</button>
									<button type="button" class="btn btn-outline-danger"
										onclick="location.href='/hyberx/mvc/student/remove/${s.id}'">${apis.removeName}</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
				<script
					src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
				<script
					src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
			</div>

		</div>
	</div>

	<jsp:include page="../../include/foot.jsp"></jsp:include>
</body>

</html>

<%--
<form:form modelAttribute="student" method="post"
	action="/hyberx/mvc/student/${action}">
	<fieldset>
		<legend>Student From</legend>
		<form:input path="id" placeholder="default" readonly="true"
			class="form-control" />
		<br>
		<form:input path="name" placeholder="Name" class="form-control" />
		<br>
		<form:input path="age" placeholder="Age" class="form-control" />
		<br>
		<button type="submit" class="btn btn-primary">${action}</button>
	</fieldset>
</form:form>
<p />
<table class="table">
	<thead class="thead-light">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Opreate</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="s" items="${students}">
			<tr scope="row">
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.age}</td>
				<td>
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='/hyberx/mvc/student/find/${s.id}'">Update</button>
					<button type="button" class="btn btn-outline-danger"
						onclick="location.href='/hyberx/mvc/student/delete/${s.id}'">Delete</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
 --%>
=======
	<meta charset="UTF-8">
	<title>SpringMVC - from</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<jsp:include page="../../include/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../../include/nav.jsp"></jsp:include>

 <div class="container-fluid">
  <div class="row">

   <jsp:include page="../../include/menu.jsp"></jsp:include>

   <!-- Main -->
   <div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
    <form:form modelAttribute="studentVo" method="post"
     action="${(apis.addUrl != null) ? apis.addUrl : apis.modifyUrl}">
     <fieldset>
      <legend>Student From</legend>
      <form:input path="student.id" placeholder="default"
       readonly="true" class="form-control" />
      <br>
      <form:input path="basicInfo.name" placeholder="Name"
       class="form-control" />
      <br>
      <form:input path="basicInfo.age" placeholder="Age"
       class="form-control" />
      <br>
      <button type="submit" class="btn btn-primary">${(apis.addName != null) ? apis.addName : apis.modifyName}</button>
      <button type="button" class="btn btn-primary"
       onclick="location.href='${apis.cancelUrl}'">${apis.cancelName}</button>
     </fieldset>
    </form:form>
    <p />
    <table class="table">
     <thead class="thead-light">
      <tr>
       <th>ID</th>
       <th>Name</th>
       <th>Age</th>
       <th>Opreate</th>
      </tr>
     </thead>
     <tbody>
      <c:forEach var="s" items="${students}">
       <tr scope="row">
        <td>${s.id}</td>
        <td>${s.basicInfo.name}</td>
        <td>${s.basicInfo.age}</td>
        <td>
         <button type="button" class="btn btn-outline-primary"
          onclick="location.href='/hyberx/mvc/student/find/${s.id}'">${apis.findName}</button>
         <button type="button" class="btn btn-outline-danger"
          onclick="location.href='/hyberx/mvc/student/remove/${s.id}'">${apis.removeName}</button>
        </td>
       </tr>
      </c:forEach>
     </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script
     src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script
     src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
   </div>

  </div>
 </div>

 <jsp:include page="../../include/foot.jsp"></jsp:include>
</body>

</html>
>>>>>>> bob
