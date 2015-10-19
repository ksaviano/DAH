<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Choose Card from your Hand</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		<link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
		
		<style>
		
		</style>
		
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
		<script src="js/code.js"></script>
		<script>
				var cards = [ "card0", "card1", "card2", "card3", "card4", "card5", "card6" ];
			$(document).ready(function() {
console.log("in document.ready");	
				phaseI();
			}); //	end document.ready
			
			// Utility function: displays standard whitecard
			function showWC(text, i) {	
				var cardobj = document.getElementById(cards[i]);
				var logo = document.createElement("img");
				var vote = document.createElement("img");
				var cardtext = document.createElement("div");
				
				logo.setAttribute("src", "/DAH/images/RRLogo.gif");
				logo.setAttribute("alt", "RRlogo");
				logo.setAttribute("height", "40px");
				logo.setAttribute("width", "40px");
				logo.setAttribute("class", "logo");
				cardobj.appendChild(logo);
				
				vote.setAttribute("src", "/DAH/images/settings.png");
				vote.setAttribute("alt", "settings");
				vote.setAttribute("height", "20px");
				vote.setAttribute("width", "20px");
				vote.setAttribute("class", "settings");
				vote.setAttribute("onclick", "govote(this)");
				cardobj.appendChild(vote);
				
				cardtext.innerHTML = text;
				cardobj.setAttribute("class", "cardstock");
				cardobj.setAttribute("name", cards[i]);
				cardobj.setAttribute("onclick", "setcard(this)");
				if(document.getElementById("decisions") != null) {
					cardobj.setAttribute("ondblclick", "phaseIII()");
				} else {
					cardobj.setAttribute("ondblclick", "phaseII()");					
				}
console.log(text);
				if(text.length <= 75) {
					cardtext.setAttribute("class", "answertext");
				} else {
					cardtext.setAttribute("class", "answertext_sml");
				}
				cardobj.appendChild(cardtext);
			}	
			
			//	Utility function: highlights card from single click
			function setcard(card) {
				var cardnames = document.getElementsByClassName("cardstock");
				for(var i = 0; i < cardnames.length; i++) {
					cardnames[i].style.transitionDuration = "0s";
					cardnames[i].style.boxShadow = "10px 10px 15px lightsteelblue";
					cardnames[i].style.transitionDuration = "2s";
					cardnames[i].style.transform = null;
					
				}
				if(document.getElementById("decisions") != null) {
console.log("in setcard(card) when decisions" + card.id)
					form1 = document.forms["selectwinnerform"];
					document.getElementById("winningplayer").value = card.id;
				} else {
					var form1 = document.forms["choosecardform"];
				}
				document.getElementById("playerchoice").value = card.id;
				card.style.transitionDuration = "3s";
				card.style.boxShadow = "inset 0px 0px 15px 3px silver, 3px 3px 50px 25px gold";
				card.style.transform = "translateZ(200px) rotateY(-30deg) rotateX(20deg)";
			}
			
			//	Utility function: not implemented (v0.9) allows player to vote on card categories when settings icon is clicked
			function govote(card) {
				document.getElementById(card);
console.log("in govote - not currently implemented, but the link is there!");
			}

			
			//	Phase I:	start of round - new blackcard, display player's 7 cards
			//				on return from StartGameController
			function phaseI() {
				var gamefield = document.getElementById("gamefield1");
console.log(document.getElementById("blackcard"));
				if(!document.getElementById("blackcard")) {
					//	round 1 - initialize standard gamefield
					var rndblockdiv = document.createElement("div");
					var blackcarddiv = document.createElement("div");
					
					rndblockdiv.setAttribute("id", "rndblockdiv");
					rndblockdiv.setAttribute("name", "rndblockdiv");
					rndblockdiv.setAttribute("class", "rounddiv");
						var rndlbl = document.createElement("h1");
						rndlbl.setAttribute("id", "roundlabel");
						rndlbl.setAttribute("name", "roundlabel");
						rndlbl.setAttribute("class", "roundlabel");
						rndlbl.innerHTML = "Round";
						var roundnum = document.createElement("div");
						roundnum.setAttribute("id", "roundnum");
						roundnum.setAttribute("name", "roundnum");
						roundnum.setAttribute("class", "roundnum");
						var instructions = document.createElement("h2");
						instructions.setAttribute("id", "instructions");
						instructions.setAttribute("name", "instructions");
						instructions.setAttribute("class", "instructions");
						instructions.innerHTML = "Select a card from your hand to play this round."
					rndblockdiv.appendChild(rndlbl);
					rndblockdiv.appendChild(roundnum);
					rndblockdiv.appendChild(instructions);
					
					blackcarddiv.setAttribute("id", "blackcard");
					blackcarddiv.setAttribute("name", "blackcard");
					blackcarddiv.setAttribute("class", "blackcard");
				
				gamefield.appendChild(rndblockdiv);
				gamefield.appendChild(blackcarddiv);
				} else {
					gamefield.removeChild(document.getElementById("decisions"));
					
				}
				//	round 2 - < endofgame
				var playercardsdiv = document.createElement("div");
					playercardsdiv.setAttribute("id", "playercards");
					playercardsdiv.setAttribute("name", "playercards");
						var form = document.createElement("form");
						form.setAttribute("id", "choosecardform");
						form.setAttribute("name", "choosecardform");
						form.setAttribute("method", "POST");
							var playerchoice = document.createElement("input");
							playerchoice.setAttribute("id", "playerchoice");
							playerchoice.setAttribute("name", "playerchoice");
							playerchoice.setAttribute("type", "text");
							playerchoice.setAttribute("class", "input");
						form.appendChild(playerchoice);
					playercardsdiv.appendChild(form);

						for(var i = 0; i < 7; i++) {
							var cardname = "card" + i;
							var thiscard = document.createElement("div");
							thiscard.setAttribute("id", cardname);
							thiscard.setAttribute("name", cardname);
							playercardsdiv.appendChild(thiscard);
						}
				gamefield.appendChild(playercardsdiv);
				
				getRoundNum();
				getRoundBlackCard();
				getPlayerHand();	
		}			//	End of Phase I
			
			
			//	Phase II:	player chooses card from their hand to play
			//				on return from AJAX call: set div to select winner
			function phaseII() {
				if(!document.getElementById("decisions")) {
//					phaseIII();
				}
console.log("in submitthecard()" + $("#choosecardform").serialize());
				$.ajax({
					url: "REST/setPlayerChoice",
					method: "POST",
					dataType: "json",
					data: $("#choosecardform").serialize(),
					success: (function(returnedData, status) {
console.log("Back from setPlayerChoice" + returnedData);
						document.getElementById("instructions").innerHTML = "Now select the card that is the best answer for this black card!";
						var gamediv = document.getElementById("gamefield1");
						gamediv.removeChild(document.getElementById("playercards"));
						var decisions = document.createElement("div");
						gamediv.appendChild(decisions).setAttribute("id", "decisions");
						var form = document.createElement("form");
							form.setAttribute("id", "selectwinnerform");
							form.setAttribute("name", "selectwinnerform");
							form.setAttribute("method", "POST");
							form.setAttribute("class", "hiddenfield");
						decisions.appendChild(form);
						var input = document.createElement("input");
							input.setAttribute("id", "playerchoice");
							input.setAttribute("name", "playerchoice");
							input.setAttribute("type", "text");
						form.appendChild(input);
						var input2 = document.createElement("input");
							input2.setAttribute("id", "winningplayer");
							input2.setAttribute("name", "winningplayer");
							input2.setAttribute("type", "text");
						form.appendChild(input2);	
						for(var x = 0; x < returnedData.length; x++) {
							decisions.appendChild(document.createElement("div")).setAttribute("id", cards[x]);
							showWC(returnedData[x].cardText, x);
						}
					}),
					error: function(xmlhttp, status) {
						console.error("DEBUG... gameplay.jsp/submitthecard().ajax.failure: " + status);
					}
				})
			}		//	End of Phase II
			
			// Phase III:	player chooses from their own pick & ghost picks winner for round
			//				on return from AJAX call: show winning card & next round button
			function phaseIII() {
				$.ajax({
					url: "REST/selectWinner",
					method: "POST",
					dataType: "json",
					data: $("#selectwinnerform").serialize(),
					success: (function(returnedData, status) {
console.log("Back from submitthewinner()" + returnedData);
						document.getElementById("instructions").innerHTML = "The winner for this round!";
						var gamediv = document.getElementById("gamefield1");
						var decdiv = document.getElementById("decisions");
						var avatar = returnedData.winneravatar;
						var wc = returnedData.winningcard;
						var x = returnedData.x;
						var ttlrounds = returnedData.totalRndNum;
console.log("avatar: " + avatar + " wc: " + wc + " x: " + x);
						
						// push back/fade losing cards
						for(var j = 0; j < 5; j++) {
							var thiscard = "card" + j;
							document.getElementById(thiscard).setAttribute("class", "fadecard");
						}
						var winningcard = "card" + x;
						decdiv.removeChild(document.getElementById(winningcard));

						// create new winning card (push forward, selected css class)
						var wincard = document.createElement("div");
						
						wincard.setAttribute("id", winningcard);
						decdiv.appendChild(wincard);
console.log("now with the wincard: " + document.getElementById(winningcard));
						showWC(wc.cardText, x);
						wincard.setAttribute("class", "wincard");
						wincard.removeAttribute("onclick");
						wincard.removeAttribute("ondblclick");
						setcard(wincard);
						
						// create new avatar of winner
						var winavatardisp = document.createElement("div");
						winavatardisp.setAttribute("id", "winavatardisp");
						winavatardisp.setAttribute("class", "winavatardisp");
						var winavatar = document.createElement("img");
						winavatar.setAttribute("id", "playeravatar");
						winavatar.setAttribute("name", "playeravatar");
						winavatar.setAttribute("class", "winavatar");
						winavatar.setAttribute("src", avatar);
						winavatar.setAttribute("height", "140px");
						winavatar.setAttribute("width", "128px");
						winavatar.setAttribute("alt", "winneravatar");
						decdiv.appendChild(winavatardisp);
						winavatardisp.appendChild(winavatar);
						
						// add button to go to next round
						var nextroundbtn = document.createElement("div");
						nextroundbtn.setAttribute("id", "nextroundbtn");
						nextroundbtn.setAttribute("name", "nextroundbtn");
						nextroundbtn.setAttribute("class", "labelbtn");
						gamediv.appendChild(nextroundbtn);
							// button will check for round #
console.log(document.getElementById("roundnum").innerHTML + " " + ttlrounds);
 						if(document.getElementById("roundnum").innerHTML < ttlrounds) {
							// if still game:
								// remove all children
							nextroundbtn.innerHTML = "Play Next Round!";
							$("#nextroundbtn").click(function() {
								phaseIV();
							});
							
						} else {
							nextroundbtn.innerHTML = "End of Game"
							$("#nextroundbtn").click(function() {
								phaseEnd();
							});
						} 
					}),
					error: function(xmlhttp, status) {
						console.error("DEBUG... gameplay.jsp/submitthecard().ajax.failure: " + status);
					}
				})
			}		//	end of Phase III
			
			function phaseIV() {
				//	controller will deal next round (end of round controller)
				//	remove decisions - ready screen for phase I)
				$.ajax({
					url: "REST/endRound",
					method: "POST",
					dataType: "json",
					data: $("#selectwinnerform").serialize(),
					success: (function(returnedData, status) {
						document.getElementById("gamefield1").removeChild(document.getElementById("nextroundbtn"));
						phaseI();						
						
					}),
					error: function(xmlhttp, status) {
						console.error("DEBUG... gameplay.jsp/submitthecard().ajax.failure: " + status);
					}
				})			
			}		//	end of Phaes IV
			
			function phaseEnd() {
				//	controller will deal with end of game (end of Game controller)
				document.getElementById("selectwinnerform").setAttribute("action", "DBCommit");
				document.getElementById("selectwinnerform").submit();
			}		//	end of Phase End
			
		</script>
		
	</head>

	<body>
	<div id="gamefield1" class="gamefieldfront">
<!-- 		<h1 class="roundlabel">ROUND </h1>
		<div id="roundnum"></div>
		<h2 id="instructions" class="instructions">Select a card from "your hand" to play this round.</h2>
	
		<div id="blackcard"></div>
		
		<div id="playercards">
		<form id="choosecardform" name="choosecardform" method="POST" action="REST/setPlayerChoice">
			<input type="text" id="playerchoice" name="playerchoice">
		</form>
			<div id="card0"></div>
			<div id="card1"></div>
			<div id="card2"></div>
			<div id="card3"></div>
			<div id="card4"></div>
			<div id="card5"></div>
			<div id="card6"></div>
		</div> -->
	</div>
		
	</body>
</html>