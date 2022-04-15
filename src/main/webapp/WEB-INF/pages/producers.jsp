<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/add" var="producerAdd" />



<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp"  flush="true"/>
	<h2>Dobrodosli u home ${user.username}</h2>
	<div>
		<table>
			<tr>
				<th>pib</th>
				<th>maticnibroj</th>
				<th>adresa</th>
				<th>pttBroj</th>
				<th>naziv Mesta</th>
				<th>Podesavanja</th>
			</tr>

			<c:forEach items="${producers}" var="producer">
				<tr>
					<td>${producer.pib}</td>
					<td>${producer.maticniBroj}</td>
					<td>${producer.adresa}</td>
					<td>${producer.mesto.pttBroj}</td>
					<td>${producer.mesto.naziv}</td>
					<td>
						<form action="/all/producer?id=${producer.id}">
							<input type="submit"  name="edit" value="edit"> <input
								type="submit" name="delete" value="delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<p> Click <a href="${producerAdd}">here</a> to add product </p>
		</div>
	</div>
</body>
</html>
