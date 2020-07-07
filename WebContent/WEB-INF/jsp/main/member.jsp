<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HyberX</title>


<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>

<script type="text/javascript">
var dberror="${dberror }";
if ( dberror !="") {
	alert( dberror );
}
</script>
</head>
<body>

	<jsp:include page="/WEB-INF/include/nav.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<jsp:include page="/WEB-INF/include/menu.jsp"></jsp:include>

			<!-- Main -->
			<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<form:form modelAttribute="member" method="post"
					action="${(apis.addUrl != null) ? apis.addUrl : apis.modifyUrl}">
					<%-- action="/hyberx/mvc/members/${action}" --%>
					<fieldset>
						<legend>Member From</legend>
						ID:
						<form:input path="id" placeholder="${id }" readonly="true"
							class="form-control" />
						<br> 名稱:
						<form:input path="name" placeholder="Name" class="form-control" />
						<br> 地址:
						<form:input path="address" placeholder="Address"
							class="form-control" />
						<br> 電話:
						<form:input path="phone" placeholder="Phone" class="form-control" />
						<br> E-mail:
						<form:input path="email" placeholder="E-Mail" class="form-control" />
						<br>
						<button type="submit" class="btn btn-primary" >${(apis.addName != null) ? apis.addName : apis.modifyName}</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/hyberx/mvc/members'">${apis.cancelName}</button>
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
										onclick="location.href='/hyberx/mvc/members/find/${m.id}'">${apis.findName}</button>
									<button type="button" class="btn btn-outline-danger"
										onclick="location.href='/hyberx/mvc/members/delete/${m.id}'">${apis.removeName}</button>
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
			</div>

		</div>
	</div>

	<jsp:include page="/WEB-INF/include/foot.jsp"></jsp:include>

</body>
</html>