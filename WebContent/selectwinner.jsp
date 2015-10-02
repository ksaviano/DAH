<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Select the Winner!</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
			function submitthecard(form) {
				
			}
			
			function setcard(card) {
				var form1 = document.forms["choosecardform"];
				form1.roundwinner.value = card.id;
			}
		
		</script>
		
		<style>
		
		</style>
	</head>

	<body>
		<h1 class="roundlabel">ROUND</h1>
		<div id="roundnum"><c:out value="${deck.getRoundnum()}" /></div>						
		<h2 class="instructions">Select the best card for this round.</h2>
		
		<form action="EndOfRound.html" id="choosecardform" method="POST" onsubmit="submitthecard(this)">								<!-- 	form action sends to EndOfRoundController.java -->
		<input type="hidden" name="roundwinner" />

		<div id="blackcardstock">
			<div class="bc">
				<c:out value="${blackcard.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="localPlayer" onclick="setcard(this)">
			<div class="wc" id="wc0">
				<c:out value="${playersChoices[0].toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="Blinky" onclick="setcard(this)">
			<div class="wc" id="wc1">
				<c:out value="${playersChoices[1].toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="Pinky" onclick="setcard(this)">
			<div class="wc" id="wc2">
				<c:out value="${playersChoices[2].toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="Inky" onclick="setcard(this)">
			<div class="wc" id="wc3">
				<c:out value="${playersChoices[3].toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="Clyde" onclick="setcard(this)">
			<div class="wc" id="wc4">
				<c:out value="${playersChoices[4].toString()}" />
			</div>
		</div>

		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />	<!-- 	sends blackcardID as string to EndOfRoundController.java -->
		<input type="submit" value="Submit" />
		
		</form>
	</body>
</html>