<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/edit" var="editConfirm">
	<c:param name="id" value="${producer.id}"></c:param>
</c:url>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit producer</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.bg-info {
	margin: 0;
}

main {
	padding: 2rem 0 2rem 0;
}

input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}

.form-control {
	width: 50rem;
	margin: auto;
}
</style>
</head>
<body class="bg-info">
	<header>
		<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp"
			flush="true" />
	</header>
	<main>

		<div class="form-horizontal text-center">
			<form action="${editConfirm}" id="producer-form" method="post">
				<div class="form-group">
					<h2>Unesite nove informacije za proizvodjaca</h2>
				</div>
				<div class="input form-group">
					<label>Pib</label> <input class="form-control" type="number" name="pib"
						value="${producer.pib}">
				</div>
				<div class="input form-group">
					<label>Maticni Broj</label> <input class="form-control" type="number" name="maticniBroj"
						value="${producer.maticniBroj}">
				</div>
				<div class="input form-group">

					<label>Adresa</label> <input class="form-control" type="text" name="adresa"
						value="${producer.adresa}">
				</div>
				<div class="input form-group">
					<label>Mesto</label> <select class="form-control" name="idMesta">
						<c:forEach items="${mesta}" var="mesto">
							<option value="${mesto.id}"
								<c:if test="${mesto.id eq procuder.mesto.id}"> selected </c:if>>${mesto.naziv}</option>
						</c:forEach>
					</select>
					<div class="input-submit">
						<input class="btn btn-primary" type="submit" value="Save changes"
							name="button"> <input class="btn btn-primary"
							type="submit" value="Back" name="button">
					</div>
				</div>
			</form>

		</div>
	</main>
</body>
</html>
