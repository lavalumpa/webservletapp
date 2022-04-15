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
		<form id="producer-form">
		<label>Pib</label>
		<input type="text" name="pib" value="pib">
		<label>Maticni Broj</label>
		<input type="text" name="maticniBroj" value="maticniBroj">
		<label>Adresa</label>
		<input type="text" name="adresa" value="adresa">
		<input type="submit">
		</form>
		<label>Mesto</label>
		<select form="producer-form">
			<c:forEach items="${producers}" var="producer">
			</c:forEach>
		</select>
	</div>
</body>
</html>
