<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body ng-app="app" ng-controller="mainCtrl">
<div class="container">

	<div class="card">
	  <div class="card-header">
	    <a href="${pageContext.request.contextPath}/register">
   		<button class="btn btn-primary">Add User</button></a>
   		<br/>
	  </div>
	  <div class="card-block">
	    <table class="table table-striped">
		<tr>
			<th>User Name</th>
			<th>Class Roo</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${students}" var="element"> 
		  <tr>
		    <td>${element.username}</td>
		    <td>${element.classRoom}</td>
		    <td>
		    	<a href="${pageContext.request.contextPath}/delete/${element.id}">
		    		<button class="btn btn-warning">Delete</button>
		    	</a>
		    	<a href="${pageContext.request.contextPath}/update/${element.id}">
		    		<button class="btn btn-success">Update</button>
		    	</a>
		    </td>
		  </tr>
		</c:forEach>
	</table>
	  </div>
	</div>
</div>
<script  src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
<script>
	app = angular.module("app", []);
	app.controller("mainCtrl", function($http, $scope){
		$http.get("http://localhost:8080/get").then(function(response){
			console.log(response);
		})
	});
</script>
</body>
</html>