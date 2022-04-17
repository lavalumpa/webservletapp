<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/all/home" var="home" />


<html>
<head>
<meta charset="ISO-8859-1">
<title>Bad request</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	padding-top: 80px;
}

body {
	background-color: #8e4a5a;
	color: #d3e3ff;
}

.link{
	color:#5b8d7a

}

.link:hover {
	color:#68efbd;

}

</style>


</head>
<body class=" d-flex flex-column justify-content-center text-center">
	<div class="container">
		<h2 class="">Greska u poslatom zahtevu</h2>
		<div >
			<a class="link" href="${home}">Home strana</a>
		</div>
	</div>
</body>
</html>
