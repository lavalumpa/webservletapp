<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/producer/add" var="producerAdd"/>
<c:url value="/all/producer/all" var="producersView"/>
<c:url value="/all/logout" var="logout"/>

<div>
	<nav>
	<a href="${producerAdd}">Add product</a>
	<a href="${producersView}">View products</a>
	
	<a href="${logout}">Logout</a>
	</nav>
</div>