<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
			<jsp:include page="${location }"></jsp:include>			
			</div>

		</div>
	</div>

	<jsp:include page="/WEB-INF/include/foot.jsp"></jsp:include>

</body>
</html>