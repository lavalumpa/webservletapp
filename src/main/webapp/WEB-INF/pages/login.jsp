<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/all/login" var="urlLogin"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Prijavite se na nasu aplikaciju ${user.username}</h2>

	<div>
		<form action="${urlLogin}" method="post">


			username:
			<div>
				<input type="text" name="username">
			</div>

			password:
			<div>
				<input type="password" name="password">
			</div>
			<div>
				${message}
			</div>

			<div>
				<input type="submit" name="login" value="Prijavi se">
			</div>
		</form>
	</div>
</body>
</html>