<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Overflow Dashboard</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
		<h2 class="display-3">Questions Dashboard</h2>
		<table class="table table-striped table-dark table-hover">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
						
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ questions }" var="question">
				<tr>
				<td> <a href="/question/${question.id}"> <c:out value="${question.questionText}"/></a></td>
				<td> 
					<c:forEach items="${ question.tags }" var="tag">
					<span>${ tag.subject }</span>
					</c:forEach>
				</td>
								
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="/newQuestion">Add a new question</a>
	</div>

</body>
</html>