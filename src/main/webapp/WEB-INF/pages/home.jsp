<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/add" var="producerAdd" />
<c:url value="/all/producer/edit" var="producerEdit" />
<c:url value="/all/producer " var="producer" />
<c:url value="/all/producer/delete" var="producerDelete" />


<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h2>Dobrodosli u home ${user.username}</h2>
	<div>
		<table>
			<tr>
				<th>id</th>
				<th>pib</th>
				<th>maticnibroj</th>
				<th>adresa</th>
				<th>pttBroj</th>
				<th>naziv Mesta</th>
			</tr>

			<c:forEach items="${producers}" var="producer">
				<tr>
					<td>${producer.id}</td>
					<td>${producer.pib}</td>
					<td>${producer.maticniBroj}</td>
					<td>${producer.adresa}</td>
					<td>${producer.mesto.pttBroj}</td>
					<td>${producer.mesto.naziv}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
