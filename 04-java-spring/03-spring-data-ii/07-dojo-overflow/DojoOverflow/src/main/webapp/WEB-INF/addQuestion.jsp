<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post a Question here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 class="display-1 text-center">Add a Question</h1>
	<div class="mx-auto w-50 p-3 text-center">
		<form:form action="/addQuestion" method="POST" modelAttribute="newQuest">
		    <p class="form-group" >
		        <form:label path="question">What is Your Question?</form:label>
		        <form:errors path="question" class="text-danger"/>
		        <form:textarea class="form-control" path="question"/>
		    </p>
		    <p class="form-group">
		        <form:label path="tags">Tags</form:label>
		        <form:errors path="tags" class="text-danger"/>
		        <form:input class="form-control" path="tags"/>
		    </p>
		    
		    <input class="btn btn-dark" type="submit" value="Submit"/>
		</form:form>   
	</div> 	

</body>
</html>