<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>End Game</title>
		<link rel="stylesheet" type="text/css" href="/DAH/CSS/dahstyle.css">
		<link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
		
		<style>
					
		</style>
		
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
		<script src="/DAH/js/code.js"></script>
		<script>
			$(document).ready(function() {
				showScores();
				
				$("#playagainbtn").click(function() {
					document.getElementById("finaloptionsform").submit();					
				})
				
				$("#logoutquitbtn").click(function() {
								document.getElementById("finaloptionsform").submit();				
				})
				
			})
			
			function showScores() {
console.log("in endgame.jsp.showScores()");
			$.ajax({
				url: "REST/getEndGameResults",
				data: "",
				type: "GET",
				dataType: "json",
				success: (function(returnedData, status) {
					var player = returnedData.players.localPlayer;
					var players = returnedData.players.players;
					var gameres = returnedData.gameresults;
							
					var maindiv = document.getElementById("endofgamediv");
					var gameresults = document.createElement("div");
					var finaloptions = document.createElement("div");
					var playerdiv = document.createElement("div");
					
					maindiv.appendChild(gameresults);
					maindiv.appendChild(playerdiv);
					maindiv.appendChild(finaloptions);
					
					gameresults.setAttribute("id", "gameresults");
					gameresults.setAttribute("name", "gameresults");
					gameresults.setAttribute("class", "gameresults");
						for(var i = 1; i < players.length; i++) {
							var ghostid = "ghost" + i
							var ghostname = players[i].ghostname;
							var ghostdiv = document.createElement("div");
							var ghostlbl = document.createElement("label");
							
							ghostlbl.setAttribute("id", ghostname + "lbl");
							ghostlbl.setAttribute("name", ghostname + "lbl");
							ghostlbl.setAttribute("class", "ghostlabel")
							ghostlbl.innerHTML = ghostname;
							ghostdiv.setAttribute("id", ghostname + "score");
							ghostdiv.setAttribute("name", ghostname + "score");
							ghostdiv.setAttribute("class", "ghostscore");
							if(i == 1) {
								ghostdiv.innerHTML = gameres.blinkyScore;
							} else if (i == 2) {
								ghostdiv.innerHTML = gameres.pinkyScore;
							} else if (i == 3) {
								ghostdiv.innerHTML = gameres.inkyScore;
							} else  {
								ghostdiv.innerHTML = gameres.clydeScore
							}
							
							gameresults.appendChild(ghostlbl);
							ghostlbl.appendChild(ghostdiv);
						}
					var playername = player.nickname;
					playerdiv.setAttribute("id", "playerdiv");
					playerdiv.setAttribute("name", "playerdiv");
					playerdiv.setAttribute("class", "playerdiv");
						var playerlbl = document.createElement("label");
						playerlbl.setAttribute("id", "playerlbl");
						playerlbl.setAttribute("name", "playerlbl");
						playerlbl.setAttribute("class", "playerlbl");
						playerlbl.innerHTML = playername;
						var playerscore = document.createElement("div");
						playerscore.setAttribute("id", "playerscore");
						playerscore.setAttribute("name", "playerscore");
						playerscore.setAttribute("class", "playerscore");
						playerscore.innerHTML = gameres.localPlayer1Score;
						var playerrecord = document.createElement("div");
						playerrecord.setAttribute("id", "playerrecord");
						playerrecord.setAttribute("name", "playerrecord");
						playerrecord.setAttribute("class", "playerrecord");
							var record = document.createElement("link");
							record.setAttribute("id", "record");
//							record.setAtrtibute("name", "record");
							record.setAttribute("class", "record");
							record.setAttribute("rel", "import");
							record.setAttribute("href", "playerprofile.jsp");
						
							playerdiv.appendChild(playerlbl);
							playerdiv.appendChild(playerscore);
							playerdiv.appendChild(playerrecord);
								playerrecord.appendChild(record);
					
					finaloptions.setAttribute("id", "finaloptions");
					finaloptions.setAttribute("name", "finaloptions");
					finaloptions.setAttribute("class", "finaloptions");
					
						var finaloptionsform = document.createElement("form");
						finaloptionsform.setAttribute("id", "finaloptionsform");
						finaloptionsform.setAttribute("name", "finaloptionsform");
						finaloptionsform.setAttribute("class", "finaloptionsform");
						finaloptionsform.setAttribute("method", "POST");
						finaloptionsform.setAttribute("action", "EndGame");
						finaloptions.appendChild(finaloptionsform);
						
						var playagainbtn = document.createElement("div");
						playagainbtn.setAttribute("id", "playagainbtn");
						playagainbtn.setAttribute("name", "playagainbtn");
						playagainbtn.setAttribute("class", "labelbtn");
						playagainbtn.innerHTML = "Play Again!";
						
						finaloptionsform.appendChild(playagainbtn);
						
						var logoutquitbtn = document.createElement("div");
						logoutquitbtn.setAttribute("id", "logoutquitbtn");
						logoutquitbtn.setAttribute("name", "logoutquitbtn");
						logoutquitbtn.setAttribute("class", "labelbtn");
						logoutquitbtn.innerHTML = "Log Out and Quit";
						
						finaloptionsform.appendChild(logoutquitbtn);
						

					

				}), // end of success
				error: function(xmlhttp, status) {
					console.error("DEBUG... endgame.jsp/showScores().ajax.failure" + status);
				}				
			}) // end of ajax
			
			
		}
		
			
			
		</script>		
		
		
	</head>

	<body>
		<div id="endofgamediv" name="endofgamediv">
		</div>
	</body>
</html>