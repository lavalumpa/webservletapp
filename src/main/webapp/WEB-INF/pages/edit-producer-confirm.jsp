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
<title>Index</title>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp" flush="true" />
	<h2>Dobrodosli u home ${user.username}</h2>
	<div>
		<form action="${editConfirm}" id="producer-form" method="post">
			<div>
				<label>Stari Pib</label> <input type="text" name="oldPib"
					value="${oldProducer.pib}" readonly="readonly"> <label>Stari
					Maticni Broj</label> <input type="text" name="oldMaticniBroj"
					value="${oldProducer.maticniBroj}" readonly="readonly"> <label>Stara
					Adresa</label> <input type="text" name="oldAdresa"
					value="${oldProducer.adresa}" readonly="readonly"> <label>Staro
					Mesto</label> <input type="text" value="${oldProducer.mesto.naziv}"
					readonly="readonly">
			</div>
			<div>

				<label>Novi Pib</label> <input type="text" name="pib"
					value="${newProducer.pib}" readonly="readonly"> <label>Novi
					Maticni Broj</label> <input type="text" name="maticniBroj"
					value="${newProducer.maticniBroj}" readonly="readonly"> <label>Nova
					Adresa</label> <input type="text" name="adresa"
					value="${newProducer.adresa}" readonly="readonly"> <label>Novo
					Mesto</label> <input type="text" value="${newProducer.mesto.naziv}"
					readonly="readonly"> <input type="hidden"
					value="${newProducer.mesto.id}" name="idMesta" readonly="readonly">	
					
			</div>
			<input type="submit" value="Confirm edit" name="button"> <input
				type="submit" value="Discard" name="button">
		</form>

	</div>
</body>
</html>
