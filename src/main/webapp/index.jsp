<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/all/login" var="urlLogin"/>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<h2>Dobrodosli u demo aplikaciji</h2>
<div>
		<a href="${urlLogin}">Prijavi se</a>
	</div>
</body>
</html>
