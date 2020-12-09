<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten by Rating</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 class="display-2 text-center">Top 10 songs by Rating</h1>
	<table class="table table-striped table-dark w-50 p-3 text-center mx-auto">
		<thead>
			<tr>
				<th>Rating</th>
				<th>Song Title</th>
				<th>Artist</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${songs}" var="song">
			<tr>
				<td>${ song.rating }</td>				
				<td><a href="/currentsong/${ song.id }">${ song.title }</a></td>
				<td>${song.artist}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="text-center">	
		<a href="/dashboard">Dashboard</a>
	</div>
	

</body>
</html>