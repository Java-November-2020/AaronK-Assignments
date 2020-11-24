<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Date</title>
<link rel="stylesheet"  type= "text/css" href="css/main.css">
<link rel="stylesheet" href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <!-- that's interesting, line 16, i import my alert from my js file, but don't need to call it in my <h1>? with a class="alert"? -->
</head>


	<h1 class="display-3">The current date is: ${myDate} </h1>
	<a href="/">Return to dashboard.</a>
	
<body>

</body>
</html>