<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Select the Winner!</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		var cards = [ "localPlayer", "Blinky", "Pinky", "Inky", "Clyde" ];
		
			function showcards() {
				for(var i = 0; i < cards.length; i++) {
					var thiscard = cards[i];
					var mycard = document.getElementById(thiscard);
					mycard.setAttribute("name", thiscard);
					mycard.setAttribute("class", "cardstock");
					mycard.setAttribute("onclick", "setcard(this)");
					mycard.setAttribute("ondblclick", "submitthecard()");
//					mycard.innerHTML = thiscard.toString();
				}
			}
			
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
				form1.roundwinner.value = selectedcard;
				console.log(selectedcard);
				document.getElementById(selectedcard).style.transitionDuration = "3s";
				document.getElementById(selectedcard).style.boxShadow = "inset 0px 0px 15px 3px silver, 3px 3px 50px 25px gold";
				document.getElementById(selectedcard).style.transform = "translateZ(200px) rotateY(-30deg) rotateX(20deg)";
			}
		</script>
		
		<style>
		
		</style>
	</head>

	<body onload="showcards()">
		<h1 class="roundlabel">ROUND</h1>
		<div id="roundnum">${deck.getRoundnum()}</div>						
		<h2 class="instructions">Select the best card for this round.</h2>
		
		<form action="EndOfRound.html" id="choosecardform" method="POST" onsubmit="submitthecard(this)">								<!-- 	form action sends to EndOfRoundController.java -->
		<input type="hidden" name="roundwinner" />

		<div id="blackcardstock">
			<div class="bc">
				${blackcard.toString()}
			</div>
		</div>
		
		<div id="localPlayer">	${playersChoices[0].toString()}</div>
		<div id="Blinky">		${playersChoices[1].toString()}</div>
		<div id="Pinky">		${playersChoices[2].toString()}</div>
		<div id="Inky">			${playersChoices[3].toString()}</div>
		<div id="Clyde">		${playersChoices[4].toString()}</div>
		
<%-- 		<div class="cardstock" id="localPlayer" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc0">
				${playersChoices[0].toString()}
			</div>
		</div>
		
		<div class="cardstock" id="Blinky" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc1">
				${playersChoices[1].toString()}
			</div>
		</div>
		
		<div class="cardstock" id="Pinky" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc2">
				${playersChoices[2].toString()}
			</div>
		</div>
		
		<div class="cardstock" id="Inky" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc3">
				${playersChoices[3].toString()}
			</div>
		</div>
		
		<div class="cardstock" id="Clyde" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc4">
				${playersChoices[4].toString()}
			</div>
		</div> --%>

		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />	<!-- 	sends blackcardID as string to EndOfRoundController.java -->
		<input type="submit" value="Submit" />
		
		</form>
	</body>
</html>