<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages!</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="mx-auto jumbotron border border-dark mt-4 text-info bg-warning" style="width: 600px;">	
		<h1 class="text-center">Coding Languages</h1>
	</div>
	<table class="table table-striped w-75 p-3 text-center mx-auto">
	    <thead>
	        <tr>
	        	<th scope="col">ID</th>
	            <th scope="col">Name</th>
	            <th scope="col">Creator</th>
	            <th scope="col">Version</th>
	            <th scope="col">Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="language">
	        <tr>
	        	<td><c:out value="${language.id}"/></td>
	            <td> <a href="/currentlanguage/${language.id}"> <c:out value="${language.name}"/></a></td>
	            <td><c:out value="${language.creator}"/></td>
	            <td><c:out value="${language.version}"/></td>
	            <td><a href="/update/${language.id}" class="btn btn-secondary">Edit Entry</a>  <a href="/delete/${language.id}" class="btn btn-danger">Delete</a>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<div class="mx-auto w-50 p-3 text-center">
		<h1 class="text-success">New Language</h1>
		<form:form action="/language/add" method="post" modelAttribute="language">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name" class="text-danger"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator" class="text-danger"/>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="version">Version</form:label>
		        <form:errors path="version" class="text-danger"/>
		        <form:input type="number" path="version"/>
		    </p> 
		    <input class="btn btn-dark" type="submit" value="Submit"/>
		</form:form>   
	</div> 
	
</body>
</html>