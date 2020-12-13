<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Wizard</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 class="display-1 text-center">New Wizard</h1>
	<div class="mx-auto w-50 p-3 text-center">
		<form:form action="/wizard/new" method="POST" modelAttribute="wizard">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name" class="text-danger"/>
		        <form:textarea class="form-control" path="name"/>
		    </p>
		    <p>
		        <form:label path="background">Background</form:label>
		        <form:errors path="background" class="text-danger"/>
		        <form:textarea class="form-control" path="background"/>
		    </p>
		    <p>
		        <form:label path="money">Money</form:label>
		        <form:errors path="money" class="text-danger"/>
		        <form:input class="form-control" type="number" path="money"/>
		    </p>
		    <input class="btn btn-dark" type="submit" value="Add New Wizard!"/>
		</form:form>   
	</div> 	
	

	
</body>
</html>