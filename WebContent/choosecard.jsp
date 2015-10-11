<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Choose Your Card</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		
			var cards = [ "card0", "card1", "card2", "card3", "card4", "card5", "card6" ];
			
			function submitthecard() {
				document.getElementById("choosecardform").submit();
			}
			
			function setcard(card) {
				for(var i = 0; i < cards.length; i++) {
					document.getElementById(cards[i]).style.transitionDuration = "0s";
					document.getElementById(cards[i]).style.boxShadow = "10px 10px 15px lightsteelblue";
					document.getElementById(cards[i]).style.transitionDuration = "2s";
					document.getElementById(cards[i]).style.transform = null;
					
				}
				var form1 = document.forms["choosecardform"];
				var selectedcard = card.id;
				form1.playerchoice.value = selectedcard;
				console.log(selectedcard);
				document.getElementById(selectedcard).style.transitionDuration = "3s";
				document.getElementById(selectedcard).style.boxShadow = "inset 0px 0px 15px 3px silver, 3px 3px 50px 25px gold";
				document.getElementById(selectedcard).style.transform = "translateZ(200px) rotateY(-30deg) rotateX(20deg)";
			}
			
		</script>
		
		<style>
		
		
		</style>
	</head>

	<body>
	
		<h1 class="roundlabel">ROUND </h1>
		<div id="roundnum"><c:out value="${deck.getRoundnum()}" /></div><br/><br/><br/>
		<h2 class="instructions">Select a card from "your hand" to play this round.</h2>

		<form action="SelectWinner.html" id="choosecardform" method="POST" onsubmit="submitthecard()">
		<input type="hidden" name="playerchoice"/>
		
		<div id="blackcardstock">
			<div class="bc">
				<c:out value="${blackcard.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card0" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc0">
				<c:out value="${card0.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card1" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc1">
				<c:out value="${card1.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card2" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc2">
				<c:out value="${card2.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card3" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc3">
				<c:out value="${card3.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card4" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc4">
				<c:out value="${card4.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card5" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc5">
				<c:out value="${card5.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="card6" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc6">
				<c:out value="${card6.toString()}" />
			</div>
		</div>
		
		<div class="submitbtn">
		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />
		<input type="submit" value="Submit" />
		</div>
		</form>
	</body>
</html>