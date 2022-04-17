<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/delete/confirm" var="deleteConfirm">
	<c:param name="id" value="${producer.id}"></c:param>
</c:url>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp" flush="true" />
	<h2>Dobrodosli u home ${user.username}</h2>
	<div>
		<form action="${deleteConfirm}" id="producer-form" method="post">
			<label>Pib</label> <input type="text" name="pib"
				value="${producer.pib}" readonly="readonly"> <label>Maticni Broj</label> <input
				type="text" name="maticniBroj" value="${producer.maticniBroj}" readonly="readonly">
			<label>Adresa</label> <input type="text" name="adresa"
				value="${producer.adresa}" readonly="readonly"> <label>Mesto</label>
				<input type="text" value="${producer.mesto.naziv}" readonly="readonly">
				 <input
				type="submit" value="Confirm delete" name="button"> <input
				type="submit" value="Back" name="button">
		</form>

	</div>
</body>
</html>
