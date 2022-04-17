<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/all/login" var="urlLogin" />


<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

.container{
	padding-top : 80px;
}	

</style>


</head>
<body class="bg-info d-flex flex-column justify-content-center text-center">
	<div class="container">
	<h2 class="" >Dobrodosli u demo aplikaciji</h2>
	<div class="">
		<a   href="${urlLogin}">Prijavi se</a>
	</div>
	</div>
</body>
</html>
