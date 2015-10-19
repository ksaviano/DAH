<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Player Profile</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		
			var val = document.getElementById("roundselect");
			
			function updateTextInput(value) {
				document.querySelector('#roundselect').value=value; 
				
			}
			function outputUpdate(vol) {
				document.querySelector('#roundselect').value = vol;
			}
		</script>
		
		<style>
		
			
		</style>
	</head>

	<body>
		<h1>Player Profile</h1>
		
		<h2 class = "instructions">Welcome, ${localPlayer.getNickname()}</h2>
		<div class = "avatar">
			<img src=${localPlayer.getAvatar()} alt="player_avatar" height=140px width=128px;>
			<script>console.log("${localPlayer.getAvatar()}")</script>
			
		</div>
		<br><br><br><br>
		
		<form action="StartGame.html" method="POST" >
		
		<table>
		<tr><td><div id="record">Your record:<br/></div></td></tr>
		<tr><td><div>Games played:</div></td>			<td><div>${localPlayer.getGamesPlayed()}</div></td></tr>   
		<tr><td><div>Hands won:</div></td>				<td><div>${localPlayer.getHandsWon()}</div>
		<tr><td><div>Horrible Points:</div></td>		<td><div>${localPlayer.getHorriblePoints()}</div>
		</table>
		
		<div class="roundselector"><label for="roundsel">Rounds</label>
		<input type="range" min="3" max="10" value="5" id="roundsel" name="roundsel" step="1" oninput="outputUpdate(value)">
		<output for="roundsel" id="roundselect">5</output></div>
		
		<input type="submit" value="PLAY GAME!">
		</form>
	</body>
</html>