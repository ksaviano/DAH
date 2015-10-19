<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>PlayerProfileDiv</title>
		
		<script>
			$.ajax({
				url: "REST/getPlayerRecord",
				data: "",
				type: "GET",
				dataType: "json",
				success: (function(returnedData, status) {
					var playerprofilediv = document.getElementByid("playerprofilediv");
					var gamesdiv = document.createElement("div");
					var handsdiv = document.createElement("div");
					var hpdiv = document.createElement("div");
					
					gamesdiv.setAttributes("id", "gamesdiv");
					gamesdiv.setAttributes("name", "gamesdiv");
					gamesdiv.setAttributes("class", "gamesdiv");
						var gameslbl = document.createElement("label");
						gameslbl.setAttributes("id", "gameslbl");
						gameslbl.setAttributes("name", "gameslbl");
						gameslbl.setAttributes("class", "gameslbl");
						gameslbl.innerHTML = "Games Played:"
						var gamesamt = document.createElement("span");
						gamesamt.setAttributes("id", "gamesamt");
						gamesamt.setAttributes("name", "gamesamt");
						gamesamt.setAttributes("class", "gamesamt");
						gamesamt.innerHTML = returnedData.gamesPlayed;
					handsdiv.setAttributes("id", "handsdiv");
					handsdiv.setAttributes("name", "handsdiv");
					handsdiv.setAttributes("class", "handsdiv");
						var handslbl = document.createElement("label");
						handslbl.setAttributes("id", "handslbl");
						handslbl.setAttributes("name", "handslbl");
						handslbl.setAttributes("class", "handslbl");
						handslbl.innerHTML = "Hands Won:";
						var handsamt = document.createElement("span");
						handsamt.setAttributes("id", "handsamt");
						handsamt.setAttributes("name", "handsamt");
						handsamt.setAttributes("class", "handsamt");
						handsamt.innerHTML = returnedData.handsWon;
					hpdiv.setAttributes("id", "hpdiv");
					hpdiv.setAttributes("name", "hpdiv");
					hpdiv.setAttributes("class", "hpdiv");
						var hplbl = document.createElement("label");
						hplbl.setAttributes("id", "hplbl");
						hplbl.setAttributes("name", "hplbl");
						hplbl.setAttributes("class", "hplbl");
						hplbl.innerHTML = "Horrible Points:";
						var hpamt = document.createElement("span");
						hpamt.setAttributes("id", "hpamt");
						hpamt.setAttributes("name", "hpamt");
						hpamt.setAttributes("class", "hpamt");
						hpamt.innerHTML = returnedData.horriblePoints;
						
						
					document.appendChild(playerprofilediv);	
					playerprofilediv.appendChild(gamesdiv);
						gamesdiv.appendChild(gameslbl);
						gamesdiv.appendChild(gamesamt);
					playerprofilediv.appendChild(handsdiv);
						handsdiv.appendChild(handslbl);
						handsdiv.appendChild(handsamt);
					playerprofilediv.appendChild(hpdiv);
						hpdiv.appendChild(hplbl);
						hpdiv.appendChild(hpamt);			
				})
			})
		
		
		</script>
		
		
	</head>

	<body>
		<div id="playerprofilediv" name="playerprofilediv" class="playerprofilediv">PLAYER PROFILE HERE</div>
	</body>
</html>

