<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>End of Game</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		
		</script>
		
		<style>
		
		</style>
	</head>

	<body>
		<h1 class=:roundlabel>END OF GAME</h1>
		
		<h2 class="instructions">Game over!</h2>
		<h2 class="instructions">The results are:</h2>
		<form action="EndOfGame.html" method="POST" >
		
<table>
<tr><th><div class="left">Player Name</div></th>												<th><div class="right">Points</div></th></tr>
<tr><td><div class="left"><c:out value="${players.getLocalPlayer().toString()}" /></div></td>	<td><div class="right"><c:out value="${players.getPoints(0)}" /></div></td></tr>
<tr><td><div class="left"><c:out value="${players.getGhostPlayer(1).toString()}" /></div></td>	<td><div class="right"><c:out value="${players.getPoints(1)}" /></div></td></tr>
<tr><td><div class="left"><c:out value="${players.getGhostPlayer(2).toString()}" /></div></td>	<td><div class="right"><c:out value="${players.getPoints(2)}" /></div></td></tr>
<tr><td><div class="left"><c:out value="${players.getGhostPlayer(3).toString()}" /></div></td>	<td><div class="right"><c:out value="${players.getPoints(3)}" /></div></td></tr>
<tr><td><div class="left"><c:out value="${players.getGhostPlayer(4).toString()}" /></div></td>	<td><div class="right"><c:out value="${players.getPoints(4)}" /></div></td></tr>
<tr><td></td><td>		<input type="submit" value="PLAY NEW GAME!" /></td></tr>
</table>		


		
		</form>
	</body>
</html>