<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Display the Winner!</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		
		</script>
		
		<style>
		
		</style>
	</head>

	<body>
		<h1 class="roundlabel">ROUND</h1>
		<div id="roundnum">${endOfRound}</div>
		<h2 class="instructions">The winner of the round has been selected!</h2>
		
		<form action="NextRound.html" method="POST" >
		<div id="blackcardstock">
			<div class="bc">
				${blackcard.toString()}
			</div>
		</div>
		
		<div class="cardstock" id="winningcard">
			<div class="wc" id="wc0">
				${winningCard.toString()}
			</div>
		</div>
		
		<div>
			<div>
				<script>console.log("${winavatar}")</script>
				<img src=${winavatar} alt="winner_avatar" height=140px width=128px;>
			</div>
		</div>

		<input type="submit" value="PLAY NEXT ROUND!" /> 

		
		</form>
	</body>
</html>