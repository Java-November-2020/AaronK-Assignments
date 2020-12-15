<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Question</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h2 class="display-2">${ myQuestion.questionText }</h2>
		<a href="/questions">Back to Dashboard</a>
		
		
		<c:forEach items="${myQuestion.tags}" var="mytags">
		<p class="badge badge-success">${ mytags.subject }</p>
			</c:forEach>
		
	</div>
	<div class="mx-auto w-50 p-3 text-center">
		<form:form action="/add/answers" method="POST" modelAttribute="answers">
		    
		    <p>
		        <form:label path="answerText">Your Answer</form:label>
		        <form:errors path="answerText" class="text-danger"/>
		        <form:textarea class="form-control" path="answerText"/>
		    </p>
		    <form:hidden path="question" value="${ myQuestion.id }"/>
		    <input class="btn btn-dark" type="submit" value="submit answer"/>
		</form:form>   
	</div> 	
	
	<div class="container">
		<h2 class="display-3"> All Answers</h2>
		<table class="table table-striped table-dark table-hover">
			<thead>
				<tr>
					<th>Answers</th>
						
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ myQuestion.answers }" var="ans">
				<tr>
					<td>${ ans.answerText }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
		
</body>
</html>