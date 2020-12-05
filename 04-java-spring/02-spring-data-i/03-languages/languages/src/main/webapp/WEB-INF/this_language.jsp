<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This language</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="jumbotron text-center">
		<p> <span class="font-weight-bold">Name:</span> <c:out value="${language.name}"/></p>
		<p><span class="font-weight-bold">Creator:</span> <c:out value="${language.creator}"/></p>
		<p><span class="font-weight-bold">Version:</span> <c:out value="${language.version}"/></p>
		<a href="/language">Dashboard</a>
		<br>
		<a href="/update/${id}">Edit Entry</a>
		<form action="/delete/${language.id}" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
		</form>
		
		
	</div>

</body>
</html>