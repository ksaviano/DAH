<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Developers Against Humanity</title>
	</head>

	<body>
	
		<h1>Welcome to DAH! Please login below:</h1>
		<form action="login.html" method="POST">
		
		<c:out value="${error}"/>
		<p>
		<table border="1" class="left">
			<tr><td>Username:</td>		<td><input type="text" 		name="username" ></td></tr>
			<tr><td>Password:</td>		<td><input type="password" 	name="password" ></td></tr>
			<tr><td></td>				<td><input type="submit" 	value="Login"></td></tr>
		</table>
		</form>
		<p><p>
		<form action="NewPlayer" method="POST" >
			Click <a href="newplayer.jsp">here</a> to create new player account.
		</form>
	</body>
</html>