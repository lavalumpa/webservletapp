<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/edit" var="editConfirm" >
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
		<form action="${editConfirm}" id="producer-form" method="post">
			<label>Pib</label> <input type="text" name="pib"
				value="${producer.pib}"> <label>Maticni Broj</label> <input
				type="text" name="maticniBroj" value="${producer.maticniBroj}">
			<label>Adresa</label> <input type="text" name="adresa"
				value="${producer.adresa}"> <label>Mesto</label> <select
				name="idMesta">
				<c:forEach items="${mesta}" var="mesto">
					<option value="${mesto.id}"
						<c:if test="${mesto.id eq procuder.mesto.id}"> selected </c:if>>${mesto.naziv}</option>
				</c:forEach>
			</select> <input type="submit" value="Save changes" name="button"> <input
				type="submit" value="Back" name="button">
		</form>

	</div>
</body>
</html>
