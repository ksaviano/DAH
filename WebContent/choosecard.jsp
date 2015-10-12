<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Choose Your Card</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		
			var cards = [ "card0", "card1", "card2", "card3", "card4", "card5", "card6" ];
			
			function showcards() {
				for(var i = 0; i < cards.length; i++) {
					var thiscard = cards[i];
					var mycard = document.getElementById(thiscard);
					mycard.setAttribute("name", thiscard);
					mycard.setAttribute("class", "cardstock");
					mycard.setAttribute("onclick", "setcard(this)");
					mycard.setAttribute("ondblclick", "submitthecard()");
//					mycard.innerHTML = thiscard;
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

	<body onload="showcards()">
	
		<h1 class="roundlabel">ROUND </h1>
		<div id="roundnum">${deck.getRoundnum()}</div><br/><br/><br/>
		<h2 class="instructions">Select a card from "your hand" to play this round.</h2>

		<form action="SelectWinner.html" id="choosecardform" method="POST" onsubmit="submitthecard()">
		<input type="hidden" name="playerchoice"/>
		
		<div id="blackcardstock">
			<div class="bc">
				${blackcard.toString()}
			</div>
		</div>
				
		<div id="card0">${card0.toString()}</div>
		<div id="card1">${card1.toString()}</div>
		<div id="card2">${card2.toString()}</div>
		<div id="card3">${card3.toString()}</div>
		<div id="card4">${card4.toString()}</div>
		<div id="card5">${card5.toString()}</div>
		<div id="card6">${card6.toString()}</div>
		
		
		
<%-- 		<div class="cardstock" id="card0" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc0">
				${card0.toString()}
			</div>
		</div>
		
		<div class="cardstock" id="card1" onclick="setcard(this)" ondblclick="submitthecard()">
			<div class="wc" id="wc1">
				${card1.toString()}
			</div>
		</div>
		
		<div class="cardstock" id="card2" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc2">
				${card2.toString()}
			</div>
		</div>
		
		<div class="cardstock" id="card3" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc3">
				${card3.toString()}
			</div>
		</div>
		
		<div class="cardstock" id="card4" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc4">
				${card4.toString()}
			</div>
		</div>
		
		<div class="cardstock" id="card5" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc5">
				${card5.toString()}
			</div>
		</div>
		
		<div class="cardstock" id="card6" onclick="setcard(this)" ondblclick="submitthecard(this)">
			<div class="wc" id="wc6">
				${card6.toString()}
			</div>
		</div> --%>
		
		<div class="submitbtn">
		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />
		<input type="submit" value="Submit" />
		</div>
		</form>
	</body>
</html>