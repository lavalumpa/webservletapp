<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/edit/confirm" var="editConfirm">
	<c:param name="id" value="${oldProducer.id}"></c:param>
</c:url>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm edit</title>
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

.main-form{
	display:flex;
	flex-direction: row;
	justify-content: center;
}


.form{
	margin : 0 2rem 0 2rem;
}

.btn{
	padding: .5rem 1.3rem;
	margin : 1.2rem 2rem 0 2rem;
	font-size: 1.3rem;
	width: 10rem;
}
</style>
</head>
<body class="bg-info">
	<header>
		<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp"
			flush="true" />
	</header>

	<main>
		<form action="${editConfirm}" id="producer-form" method="post">
			<div class="text-center">
				<h2>Potvrdite izmene</h2>
			</div>
			<div class="main-form">
				<div class="form  text-center">
					<div>
						<label>Stari Pib</label> <input class="form-control" type="text"
							name="oldPib" value="${oldProducer.pib}" readonly="readonly">
					</div>
					<div>
						<label>Stari Maticni Broj</label> <input class="form-control"
							type="text" name="oldMaticniBroj"
							value="${oldProducer.maticniBroj}" readonly="readonly">
					</div>
					<div>
						<label>Stara Adresa</label> <input class="form-control"
							type="text" name="oldAdresa" value="${oldProducer.adresa}"
							readonly="readonly">
					</div>
					<div>
						<label>Staro Mesto</label> <input class="form-control" type="text"
							value="${oldProducer.mesto.naziv}" readonly="readonly">
					</div>
				</div>
				<div class="form  text-center">

					<div>
						<label>Novi Pib</label> <input class="form-control" type="text"
							name="pib" value="${newProducer.pib}" readonly="readonly">
					</div>
					<div>

						<label>Novi Maticni Broj</label> <input class="form-control"
							type="text" name="maticniBroj" value="${newProducer.maticniBroj}"
							readonly="readonly">
					</div>
					<div>

						<label>Nova Adresa</label> <input class="form-control" type="text"
							name="adresa" value="${newProducer.adresa}" readonly="readonly">
					</div>

					<div>
						<label>Novo Mesto</label> <input class="form-control" type="text"
							value="${newProducer.mesto.naziv}" readonly="readonly">
					</div>
					<input type="hidden" value="${newProducer.mesto.id}" name="idMesta"
						readonly="readonly">
				</div>
			</div>
			<div class="buttons text-center">
				<input class="btn btn-primary " type="submit" value="Confirm edit"
					name="button"> <input class="btn btn-primary" type="submit"
					value="Discard" name="button">
			</div>
		</form>

	</main>
</body>
</html>
