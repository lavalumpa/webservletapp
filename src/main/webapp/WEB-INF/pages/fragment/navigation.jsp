<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/all/home" var="home" />
<c:url value="/all/producer/add" var="producerAdd" />
<c:url value="/all/producer/all" var="producersView" />
<c:url value="/all/logout" var="logout" />

<div class="navbar bg-primary" style="height: 5rem;">

	<nav >

		<div  class="d-inline-block align-middle" style="height:100%">

			<a  style="color:#d9edf7" href="${home}">Home</a> <a style="color:#d9edf7"  href="${producerAdd}">Add producers</a>
			<a style="color:#d9edf7"  href="${producersView}">View producers</a> <a style="color:#d9edf7"  class="pull-right"
				href="${logout}">Logout</a>

		</div>
	</nav>
</div>