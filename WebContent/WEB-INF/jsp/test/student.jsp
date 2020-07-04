<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>[ TEST ] Student</title>

  <jsp:include page="../../include/head.jsp"></jsp:include>

</head>
<body>

  <jsp:include page="../../include/nav.jsp"></jsp:include>

  <div class="container-fluid">
    <div class="row">

      <jsp:include page="../../include/menu.jsp"></jsp:include>

      <!-- Main -->
      <div class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

        <form:form modelAttribute="student" method="post" action="/hyberx/mvc/student/${action}">
          <fieldset>
            <legend>Student From</legend>
            <form:input path="id" placeholder="default" readonly="true" class="form-control" /><br>
            <form:input path="name" placeholder="Name" class="form-control" /><br>
            <form:input path="age" placeholder="Age" class="form-control" /><br>
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
      </div>

    </div>
  </div>

  <jsp:include page="../../include/foot.jsp"></jsp:include>

</body>
</html>