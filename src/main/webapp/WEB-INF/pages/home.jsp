<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/add" var="producerAdd"/>
<c:url value="/all/producer/all" var="producersView"/>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/fragment/navigation.jsp"  flush="true"/>
	<h2>Dobrodosli u home ${user.username}</h2>
	<div>
		
		<div>
			<a href="${producersView}">View all producers
			</a>
			<a href="${producerAdd}">Add producer
			</a>
		</div>
	</div>
</body>
</html>
