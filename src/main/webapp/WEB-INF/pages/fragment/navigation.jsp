<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/product/add" var="productAdd"/>
<c:url value="/all/products" var="productsView"/>
<c:url value="/all/logout" var="logout"/>

<div>
	<nav>
	<a href="${productAdd}">Add product</a>
	<a href="${productsView}">View products</a>
	
	<a href="${logout}">Logout</a>
	</nav>
</div>