<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Choose Card from your Hand</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<style>
		
		</style>
		
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				var text = "in document.ready";
				
				
	  	
			}); //	end document.ready
			
			function successRoundNum(returnedData, status) {
				console.log("in successRoundNum." + returnedData)
				$("#roundnum").html(returnedData);
			}
			
			function successBlackCard(returnedData, status) {
				console.log("in successBlackCard." + returnedData)
				var bc = document.getElementById("blackcard");
				bc.setAttribute("class", "blackcard");
				bc.innerHTML = returnedData.questionText;
			}
			
			function successPlayerHand(returnedData, status) {
				console.log("in successPlayerHand." + returnedData)
				for(var x = 0; x < returnedData.length; x++)
//					console.log("In successPlayerHand loop. returnedData[x] = " + returnedData[x].cardText);
					showWC(returnedData[x].cardText, x);
					x++;
			}
				
			function showWC(text, i) {	
				var cards = [ "card0", "card1", "card2", "card3", "card4", "card5", "card6" ];
			
				var cardobj = document.getElementById(cards[i]);
				var logo = document.createElement("img");
				var vote = document.createElement("img");
				var cardtext = document.createElement("div");
				cardobj.setAttribute("class", "cardstock");
				
				logo.setAttribute("src", "images/RRLogo.gif");
				logo.setAttribute("alt", "RRlogo");
				logo.setAttribute("height", "40px");
				logo.setAttribute("width", "40px");
				logo.setAttribute("class", "logo");
				cardobj.appendChild(logo);
				
				vote.setAttribute("src", "images/settings.png");
				vote.setAttribute("alt", "settings");
				vote.setAttribute("height", "20px");
				vote.setAttribute("width", "20px");
				vote.setAttribute("class", "settings");
				cardobj.appendChild(vote);
				
				cardtext.innerHTML = text;
				console.log(text);
				if(text.length <= 75) {
					cardtext.setAttribute("class", "answertext");
				} else {
					cardtext.setAttribute("class", "answertext_sml");
				}
			
				cardobj.appendChild(cardtext);
			}					
		</script>
		
	</head>

	<body>
		<h1 class="roundlabel">ROUND </h1>
		<div id="roundnum"></div>
		<h2 class="instructions">Select a card from "your hand" to play this round.</h2>
	
		<div id="blackcard"></div>
		
		<div id="playercards">
			<div id="card0"></div>
			<div id="card1"></div>
			<div id="card2"></div>
			<div id="card3"></div>
			<div id="card4"></div>
			<div id="card5"></div>
			<div id="card6"></div>
		</div>
		

		
		
	</body>
</html>