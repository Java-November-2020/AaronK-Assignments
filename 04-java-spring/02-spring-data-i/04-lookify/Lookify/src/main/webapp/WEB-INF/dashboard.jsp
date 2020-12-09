<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My dashboard</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="w-50 mx-auto">
		<a class="d-inline" href="/addSong">ADD NEW</a>
		<h2 class="d-inline"><a href="/songs/topTen">Top Ten</a></h2>
		<form action="/songs/search" class="float-right">
			<input type="text" name="artist"/>
			<button class="btn btn-primary">Search Artists</button>
		</form>
	</div>

	<table class="table table-striped w-75 p-3 text-center mx-auto">
	    <thead>
	        <tr>
	            <th scope="col">Song Title</th>
	            <th scope="col">Rating</th>
	            <th scope="col">Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${songs}" var="song">
	        <tr>
	            <td> <a href="/currentsong/${song.id}"><c:out value="${song.title}"/></a></td>
	            <td><c:out value="${song.rating}"/></td>
	            <td> <a href="/delete/${song.id}" class="btn btn-danger">Delete</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>

</body>
</html>