<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<h3>${message}</h3>
	<mvc:form action="${pageContext.request.contextPath}/register" modelAttribute="user" method="POST">
	
	Student name : 
	<mvc:input path="username" cssClass=""/> <br/>
	Class Room : 
	<mvc:input path="classRoom"/> <br/>
	<input type="submit" value="insert">
	
	</mvc:form>

</body>
</html>