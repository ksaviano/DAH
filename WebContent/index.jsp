<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Developers Against Humanity</title>
		
		<style>
		
			body {
				height: 700px;
				background-image: url("images/rainbowbck.jpg");
				background-size: cover;
				background-repeat: no-repeat;
				background-position: center;
				
				font-family: Helvetica;
			} 
			
			#usrname {
				float: left;
				font-size: 1.5em;
				margin-right: 20px;
				
			}
			
			#username div {
				float: clear;
				fontsize: 1.5em;
				background: transparent;
			}
			
			#passwrd {
				margin-left: 20px;
				float: left;
				font-size: 1.5em;
			}
			
			#submit {
				float: clear;
			}
			
		</style>
		
	</head>

	<body>
	
		<h1>Welcome to DAH! Please login below:</h1>
		<form action="login.html" method="POST">
		
		<c:out value="${error}"/>
		<p></p>
		<div id="usrname">
			<p>Username:</p>
			<div class="input">
				<input type="text" 		name="username">
			</div>
		</div>
		<div id="passwrd">
			<p>Password:</p>
			<div class="input">
				<input type="password" 	name="password" >
			</div>
		</div>
		<div id="submit">
			<p><input type="submit" 	value="Login"></p>
		</div>
		</form>
		
		<form action="NewPlayer" method="POST" >
			Click <a href="newplayer.jsp">here</a> to create new player account.
		</form>
	</body>
</html>