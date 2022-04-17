<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/add" var="producerAdd" />
<c:url value="/all/producer/all" var="producersView" />



<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.bg-info {
	margin: 0;
}

main {
	padding: 2rem 0 2rem 0;
}

.product-links>div {
	padding: 2.2rem 0 0 0;
}
</style>
</head>
<body class="bg-info">
	<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp" flush="true" />

	<main class="text-center">
		<h2>Dobrodosli u home ${user.username}</h2>
		<div class="product-links">
			<div>
				<a href="${producersView}">View all producers </a>
			</div>
			<div>
				<a href="${producerAdd}">Add producer </a>
			</div>
		</div>
	</main>
</body>
</html>
