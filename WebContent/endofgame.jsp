<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>End of Game</title>
	</head>

	<body>
		<h1>END OF GAME</h1>
		
		<h2>Game over: the results are:</h2>
		
		<table border="1" class="left">
			<tr><th>Player Name</th>											<th>Points</th></tr>
			<tr><td><c:out value="${players.getLocalPlayer().toString()}" />	<td><c:out value="${players.getPoints(0)}" /></td></tr>
			<tr><td><c:out value="${players.getGhostPlayer(1).toString()}" />	<td><c:out value="${players.getPoints(1)}" /></td></tr>
			<tr><td><c:out value="${players.getGhostPlayer(2).toString()}" />	<td><c:out value="${players.getPoints(2)}" /></td></tr>
			<tr><td><c:out value="${players.getGhostPlayer(3).toString()}" />	<td><c:out value="${players.getPoints(3)}" /></td></tr>
			<tr><td><c:out value="${players.getGhostPlayer(4).toString()}" />	<td><c:out value="${players.getPoints(4)}" /></td></tr>
		</table>
		
		<form action="EndOfGame.html" method="POST" >
		
		<table border="1" class="left">
			 <tr><td> <input type="submit" value="PLAY NEW GAME!" /> </td> </tr>
		</table>
		
		</form>
	</body>
</html>