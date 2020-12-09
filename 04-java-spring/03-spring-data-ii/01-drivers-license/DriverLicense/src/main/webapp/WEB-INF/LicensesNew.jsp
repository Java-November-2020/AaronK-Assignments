<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new License</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<h1 class="display-1 text-center">New License</h1>
	<div class="mx-auto w-50 p-3 text-center">
		<form:form action="/add/license" method="POST" modelAttribute="license">
		    <p>
		        <form:label path="person">Person</form:label>
		        <form:errors path="person" class="text-danger"/>
 				<form:select class="form-control" path="person">
			        <c:forEach items="${ person }" var="p">
			        	<form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
			        </c:forEach>
		        </form:select>		    
		    </p>
		    <p>
		        <form:label path="state">State</form:label>
		        <form:errors path="state" class="text-danger"/>
		        <form:textarea class="form-control" path="state"/>
		    </p>
		    <p>
		        <form:label path="expiration_date">Expiration Date</form:label>
		        <form:errors path="expiration_date" class="text-danger"/>
		        <form:input class="form-control" type="date" path="expiration_date"/>
		    </p>
		    <input class="btn btn-dark" type="submit" value="Add License"/>
		</form:form>   
	</div> 	


</body>
</html>