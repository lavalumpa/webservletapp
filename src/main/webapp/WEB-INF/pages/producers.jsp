<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/add" var="producerAdd" />



<html>
<head>
<meta charset="ISO-8859-1">
<title>Producers</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body class="bg-info">
	<header>
		<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp"
			flush="true" />
	</header>
	<main>

		<h2>Tabela proizvodjaca</h2>
		<div>
			<table class="table text-center table-bordered">
				<thead >
					<tr >
						<th  class="text-center" >Pib</th>
						<th  class="text-center">Maticni broj</th>
						<th  class="text-center">Adresa</th>
						<th  class="text-center">pttBroj</th>
						<th  class="text-center">Naziv Mesta</th>
						<th  class="text-center">Podesavanja</th>
					</tr>
				</thead>
				<c:forEach items="${producers}" var="producer">
					<tr>
						<td>${producer.pib}</td>
						<td>${producer.maticniBroj}</td>
						<td>${producer.adresa}</td>
						<td>${producer.mesto.pttBroj}</td>
						<td>${producer.mesto.naziv}</td>
						<td><c:url var="buttonLink" value="/all/producer">
								<c:param name="id" value="${producer.id}"></c:param>
							</c:url>

							<form action="${buttonLink}" method="post">
								<input class="btn btn-primary" type="submit" name="button"
									value="edit"> <input class="btn btn-primary"
									type="submit" name="button" value="delete">
							</form>
							</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<p>
					Click <a href="${producerAdd}">here</a> to add product
				</p>
			</div>
		</div>
	</main>
</body>
</html>
