<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Choose Your Card</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
			function submitthecard(form) {
				alert(form.playerchoice.value);
				
			}
			
			function setcard(card) {
				alert(card.id);
				var form1 = document.forms["choosecardform"];
				alert(form1.id);
				form1.playerchoice.value = card.id;
				alert(form1.playerchoice.value);
			}
		</script>
		
		<style>
		
		
		</style>
	</head>

	<body>
	
		<h1 class="roundlabel">ROUND </h1>
		<div id="roundnum"><c:out value="${deck.getRoundnum()}" /></div><br/><br/><br/>
		<h2 class="instructions">Select a card from "your hand" to play this round.</h2>

		<form action="SelectWinner.html" id="choosecardform" method="POST" onsubmit="submitthecard(this)">
		<input type="radio" name="choosecard" value="wc1">
		<input type="text" name="playerchoice"/>
		
		<div id="blackcardstock">
			<div class="bc">
				<c:out value="${blackcard.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card0" onclick="setcard(this)">
			<div class="wc" id="wc0">
				<c:out value="${card0.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card1" onclick="setcard(this)">
			<div class="wc" id="wc1">
				<c:out value="${card1.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card2" onclick="setcard(this)">
			<div class="wc" id="wc2">
				<c:out value="${card2.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card3" onclick="setcard(this)">
			<div class="wc" id="wc3">
				<c:out value="${card3.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card4" onclick="setcard(this)">
			<div class="wc" id="wc4">
				<c:out value="${card4.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card5" onclick="setcard(this)">
			<div class="wc" id="wc5">
				<c:out value="${card5.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card6" onclick="setcard(this)">
			<div class="wc" id="wc6">
				<c:out value="${card6.toString()}" />
			</div>
		</div>
		
		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />
		<input type="submit" value="Submit" />
		
		</form>
	</body>
</html>