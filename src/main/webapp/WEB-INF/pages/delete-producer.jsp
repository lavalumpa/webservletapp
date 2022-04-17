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
<title>Delete confirm</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.bg-info {
	margin: 0;
}

main {
	padding: 2rem 0 2rem 0;
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
			<div class="form-group">
				<h2>Potvrdite brisanje proizvodjaca</h2>
			</div>
			<form action="${deleteConfirm}" id="producer-form" method="post">
				<div class="input form-group">
					<label>Pib</label> <input class="form-control" type="text"
						name="pib" value="${producer.pib}" readonly="readonly">
				</div>
				<div class="input form-group">
					<label>Maticni Broj</label> <input class="form-control" type="text"
						name="maticniBroj" value="${producer.maticniBroj}"
						readonly="readonly">
				</div>
				<div class="input form-group">
					<label>Adresa</label> <input class="form-control" type="text"
						name="adresa" value="${producer.adresa}" readonly="readonly">
				</div>
				<div class="input form-group">
					<label>Mesto</label> <input class="form-control" type="text"
						value="${producer.mesto.naziv}" readonly="readonly">
				</div>
				<div class="input-submit">
					<input class="btn btn-primary" type="submit" value="Confirm delete"
						name="button"> <input class="btn btn-primary"
						type="submit" value="Back" name="button">
				</div>
			</form>
		</div>
	</main>
</body>
</html>
