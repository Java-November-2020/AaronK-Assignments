<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Assignment</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="jumbotron text-center">
		<h1><c:out value="${book.title}"/></h1>
		<p> <span class="font-weight-bold">Description:</span> <c:out value="${book.description}"/></p>
		<p><span class="font-weight-bold">Language:</span> <c:out value="${book.language}"/></p>
		<p><span class="font-weight-bold">Number of pages:</span> <c:out value="${book.number_of_pages}"/></p>
		<a href="/update/${id}">Edit Book</a>
		<form action="/delete/${book.id}" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>