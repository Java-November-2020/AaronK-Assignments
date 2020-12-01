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
	<div class="mx-auto jumbotron border border-success mt-4" style="width: 600px;">	
		<h1 class="text-center">Hello World!</h1>
		<a href="/books/new">create a book</a>
	</div>
	<h1>All Books</h1>
<table class="table table-striped">
    <thead>
        <tr>
        	<th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Language</th>
            <th scope="col">Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
        <tr>
        	<td ><c:out value="${book.id}"/></td>
            <td ><c:out value="${book.title}"/></td>
            <td ><c:out value="${book.description}"/></td>
            <td ><c:out value="${book.language}"/></td>
            <td ><c:out value="${book.number_of_pages}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
	
</body>
</html>