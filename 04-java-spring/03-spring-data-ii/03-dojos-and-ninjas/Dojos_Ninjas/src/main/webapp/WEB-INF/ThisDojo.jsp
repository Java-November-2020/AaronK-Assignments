<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Song</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
		<h2 class="display-3">${ dojo.name } Dojo Ninjas</h2>
		<table class="table table-striped table-dark table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ dojo.ninjas }" var="ninja">
				<tr>
					<td>${ ninja.firstName }</td>
					<td> ${ ninja.lastName }</td>
					<td>${ ninja.age }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>