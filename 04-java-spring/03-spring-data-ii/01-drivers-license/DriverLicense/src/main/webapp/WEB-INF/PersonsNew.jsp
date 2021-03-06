<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 class="display-1 text-center">New Person</h1>
	<div class="mx-auto w-50 p-3 text-center">
		<form:form action="/add/person" method="POST" modelAttribute="person">
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName" class="text-danger"/>
		        <form:input path="firstName"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName" class="text-danger"/>
		        <form:textarea path="lastName"/>
		    </p>
		    <input class="btn btn-dark" type="submit" value="Create"/>
		</form:form>   
	</div> 	
	

	
</body>
</html>