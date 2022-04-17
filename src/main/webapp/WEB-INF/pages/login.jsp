<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/all/login" var="urlLogin"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Login</title>

<style type="text/css">
.input {
 padding : 2rem 4rem 0 0 ;
}

.input-submit {
 padding : 10px 0 0 0 ;
}

.form{
 padding: 1.2rem 0 0 0;
}

.header{
 padding: 3rem 0 0 0;
}


</style>
</head>
<body class="bg-info d-flex flex-column justify-content-center text-center">
	<h2 class="header">Prijavite se na nasu aplikaciju ${user.username}</h2>

	<div class="form">
		<form action="${urlLogin}" method="post">


			
			<div class="input">
			<label for="username">username:</label>
				<input type="text" name="username">
			</div>

			
			<div class="input">
			<label for="password">password:</label>
				<input type="password" name="password">
			</div>
			<div>
				${message}
			</div>

			<div class="input-submit">
				<input class="btn btn-primary" type="submit" name="login" value="Prijavi se">
			</div>
		</form>
	</div>
</body>
</html>