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

</head>
<body>

	<jsp:include page="/WEB-INF/include/nav.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<jsp:include page="/WEB-INF/include/menu.jsp"></jsp:include>

			<!-- Main -->
			<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<form:form modelAttribute="account" method="post"
					action="${(apis.addUrl != null) ? apis.addUrl : apis.modifyUrl}">
					<%-- action="/hyberx/mvc/accounts/${action}" --%>
					<fieldset>
						<legend>Account From</legend>
						ID:
						<form:input path="id" placeholder="default" readonly="true"
							class="form-control" />
						<br> 帳號:
						<form:input path="name" placeholder="Name" class="form-control" />
						<br> 密碼:
						<form:password path="password" placeholder="Password"
							class="form-control" />
						<br> 會員編號:
						<form:input path="m_id.id" placeholder="MemberID" readonly="true"
							class="form-control" />
						<br> 會員狀態:
						<form:input path="status" placeholder="Status" readonly="true"
							class="form-control" />
						<br> 登入錯誤次數:
						<form:input path="errorTimes" placeholder="Error-Times"
							readonly="true" class="form-control" />
						<br>
						<%--button type="submit" class="btn btn-primary">${action}</button--%>
						<button type="submit" class="btn btn-primary" >${(apis.addName != null) ? apis.addName : apis.modifyName}</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/hyberx/mvc/accounts'">${apis.cancelName}</button>
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
										onclick="location.href='/hyberx/mvc/accounts/find/${a.id}'">${apis.findName}</button>
									<button type="button" class="btn btn-outline-danger"
										onclick="location.href='/hyberx/mvc/accounts/delete/${a.id}'">${apis.removeName}</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>

	<jsp:include page="/WEB-INF/include/foot.jsp"></jsp:include>

</body>
</html>