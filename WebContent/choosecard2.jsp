<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Choose Your Card</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		
			var cards = [ "card0", "card1", "card2", "card3", "card4", "card5", "card6" ];
			
			function showcards() {
				for(var i = 0; i < cards.length; i++) {
					var thiscard = cards[i];
					var node = document.getElementById(thiscard);
  					var elem1 = document.createElement("img");
					var elem2 = document.createElement("img");
					var textdiv = document.createElement("div");
					

					elem1.setAttribute("src", "images/RRlogo.jpg");
					elem1.setAttribute("alt", "RRlogo");
					elem1.setAttribute("height", "40px");
					elem1.setAttribute("width", "40px");
					elem1.setAttribute("class", "logo");
					node.appendChild(elem1);
					
					elem2.setAttribute("src", "images/settings.png");
					elem2.setAttribute("alt", "settings");
					elem2.setAttribute("height", "20px");
					elem2.setAttribute("width", "20px");
					elem2.setAttribute("class", "settings");
					node.appendChild(elem2); 
					
					textdiv.innerHTML = "Hello this text is way longer!";	// text from AJAX
					node.appendChild(textdiv);
					node.setAttribute("name", thiscard);
					node.setAttribute("class", "cardstock");
					node.setAttribute("onclick", "setcard(this)");
					node.setAttribute("ondblclick", "submitthecard()");
					
					
	
//					node.setAttribute("innerHTML", t);
//					elem3.setAttribute("span", t);
//					node.appendChild(t);

					
//					node.innerHTML = "${card0.toString()}";

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
			
			function govote(card) {
				document.getElementById(card);
				console.log("in govote");
			}
			
			
		</script>
		
		<style>
		
		
		</style>
	</head>

	<body>
		<h1 class="roundlabel">ROUND</h1>
		<div id="roundnum"></div>
		<h2 class="instructions">Select a card from "your hand" to play this round.</h2>

		<form action="SelectWinner.html" id="choosecardform" method="POST" onsubmit="submitthecard()">
		
		<div id="blackcard"></div>
		
		<div id="card0"></div>
		<div id="card1"></div>
		<div id="card2"></div>
		<div id="card3"></div>
		<div id="card4"></div>
		<div id="card5"></div>
		<div id="card6"></div>
		
		<div class="submitbtn">
		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />
		<input type="hidden" name="playerchoice"/>
		<input type="submit" value="Submit" />
		</div>
		</form>
	</body>
</html>

