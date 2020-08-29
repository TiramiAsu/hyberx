<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVC - from</title>
<%--link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"--%>
<jsp:include page="/WEB-INF/include/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/include/nav.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/WEB-INF/include/menu.jsp"></jsp:include>
			<!-- Main -->
			<div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<form:form modelAttribute="order" method="post"
					action="/hyberx/mvc/order/${action}">
					<fieldset>
						<legend>產 品 訂 單</legend>
						<form:input path="id" placeholder="default" readonly="true"
							class="form-control" />
						<br>
						<form:input path="name" placeholder="產品名稱" class="form-control" />
						<br>
						<form:input path="price" placeholder="價錢" class="form-control" />
						<br>
						<form:input path="remark" placeholder="附註" class="form-control" />
						<br>
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
			</div>
		</div>
	</div>
	<div id = "table"/> 
	
	<script>
	$( document ).ready(function() {
	    console.log( "ready!" );
	    initTable()
	});
	
	  function initTable() {
    $('#table').bootstrapTable('destroy').bootstrapTable({
	      	data: [
	      		{
	      			state: 'd',
	      			id: '1',
	      			name: 'bob',
	      			price: 44,
	      			operate: 's'
	      		}],
	      		data: [
		      		{
		      			state: 'd',
		      			id: '2',
		      			name: 'bob2',
		      			price: 70,
		      			operate: 'uuuu'
		      		}],
	      		columns:[
		        {
		          field: 'state',
		          checkbox: true,
		          align: 'center',
		          valign: 'middle'
		        }, {
		          title: 'Item ID',
		          field: 'id',
		          align: 'center',
		          valign: 'middle',
		          sortable: true
		        },
		        {
		          field: 'name',
		          title: 'Item Name',
		          sortable: true,
		          align: 'center'
		        }, {
		          field: 'price',
		          title: 'Item Price',
		          sortable: true,
		          align: 'center'
		        }, {
		          field: 'operate',
		          title: 'Item Operate',
		          align: 'center',
		          clickToSelect: false
		        }
		      ]
		    })
														
		  }						
	</script>
	
	<jsp:include page="/WEB-INF/include/foot.jsp"></jsp:include>
</body>
</html>