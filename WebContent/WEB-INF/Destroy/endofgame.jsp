<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<tr><th><div class="left">Player Name</div></th><th></th><th><div class="right">Points</div></th></tr>
<tr>
	<td><div class="left">${players.getLocalPlayer().toString()}</div></td>
	<td><img src=${players.getAvatars(0)} alt="avatar" height=140px width=128px;></td>	
	<td><div class="right">${players.getPoints(0)}</div></td>
</tr>
<tr>
	<td><div class="left">${players.getGhostPlayer(1).toString()}</div></td>
	<td><img src=${players.getAvatars(1)} alt="avatar" height=140px width=128px;></td>	
	<td><div class="right">${players.getPoints(1)}</div></td>
</tr>
<tr>
	<td><div class="left">${players.getGhostPlayer(2).toString()}</div></td>
	<td><img src=${players.getAvatars(2)} alt="avatar" height=140px width=128px;></td>	
	<td><div class="right">${players.getPoints(2)}</div></td>
</tr>
<tr>
	<td><div class="left">${players.getGhostPlayer(3).toString()}</div></td>
	<td><img src=${players.getAvatars(3)} alt="avatar" height=140px width=128px;></td>	
	<td><div class="right">${players.getPoints(3)}</div></td>
</tr>
<tr>
	<td><div class="left">${players.getGhostPlayer(4).toString()}</div></td>
	<td><img src=${players.getAvatars(4)} alt="avatar" height=140px width=128px;></td>	
	<td><div class="right">${players.getPoints(4)}</div></td>
</tr>
<tr><td></td><td>		<input type="submit" value="PLAY NEW GAME!" /></td></tr>
</table>		


		
		</form>
	</body>
</html>