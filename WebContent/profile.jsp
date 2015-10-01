<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>profile</title>
		<style>
		body {
				height: 700px;
				background-image: url("images/rainbowbck.jpg");
				background-size: cover;
				background-repeat: no-repeat;
				background-position: center;
				
				font-family: helvetica;
				font-size: 1.5em;
			}
			
		</style>
	</head>

	<body>
		<h1>Profile.jsp</h1>
		
		Welcome ${localPlayer.getNickname()}
		
		<form action="StartGame.html" method="POST" >
		<div id="record">Your record:<br/></div>
			
			<div>Games played:<c:out value="${localPlayer.getGamesPlayed()}" /> </div>   
			<div>Hands won:		<c:out value="${localPlayer.getHandsWon()}" /></div>
			<div>Horrible Points:<c:out value="${localPlayer.getHorriblePoints()}" /></div>
		
			
			<input type="submit" value="PLAY!" />
		</form>
	</body>
</html>