//	Display Cards AJAX Calls (for use in choosecard.jsp and selectwinner.jsp and showwinner.jsp)

function getRoundNum() {
	$.ajax({											//	get roundnum
		url: "/DAH/REST/getRoundNum",					//	CONTROLLER: REST_AJAXController.java/getRoundNumJSON(session)
		data: "",										//	return: int (deck.getRoundnum())
		type: "GET",
		dataType: "text",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getRoundNum  Datacheck: " + returnedData);
			$("#roundnum").html(returnedData);
		}),
		error: function(xmlhttp, status) {
			console.error("DEBUG... code.js/getRoundNum().ajax.failure: " + status);
		}
	})
}

function getRoundBlackCard() {
	console.log("DEBUG... code.js/getBlackCard()");
	$.ajax({
		url: "/DAH/REST/dispBlackCard",					//	gets CURRENT black card (does not draw new card)
		data: "",										//	CONTROLLER: REST_AJAXController.java/dispBlackCardJSON(session)
		type: "GET",									//	return: BlackCard (deck.dispCurrentBC())
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getBlackCard  Datacheck: " + returnedData);
			var bc = document.getElementById("blackcard");
			bc.setAttribute("class", "blackcard");
			bc.innerHTML = returnedData.questionText;
		}),
		error: function(xmlhttp, status) {
			console.error("DEBUG... code.js/getBlackCard().ajax.failure: " + status);
		}
	})
}

function getPlayerHand() {
	$.ajax({
		url: "/DAH/REST/getPlayerHand",					//	get playerHand
		data: "",										//	CONTROLLER: REST_AJAXController.java/getPlayerHandJSON(session)
		type: "GET",									//	return: WhiteCard[] (players.getLocalPlayer().getHand())
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getPlayerHand  Datacheck: " + returnedData + " " + returnedData.length);
			for(var x = 0; x < returnedData.length; x++) {
				showWC(returnedData[x].cardText, x);
			}
		}),
		error: function(xmlhttp, status) {
			console.error("DEBUG... code.js/getPlayerHand().ajax.failure: " + status);
		}
	})
}

function getRoundPlays() {
	$.ajax({
		url: "DAH/REST/getRoundPlays",					//	get player's choice and ghost decisions
		data: "",										//	CONTROLLER: REST_AJAXController.java/getRoundPlaysJSON(session) 
		type: "GET",									//	return: WhiteCard[] (players.getPlayers(0-5).getRoundPick();
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getRoundPlays  Datacheck: " + returnedData);
			for(var x = 0; x < returnedData.length; x++) {
				showWC(returnedData[x].cardText, x);
				x++;
			}
		}),
		error: function(xmlhttp, status) {
			console.error("DEBUG... code.js/getRoundPlays().ajax.failure: " + status);
		}
	})
}

function getRoundWinner() {
	$.ajax({
		url: "DAH/REST/getRoundWinner",					//	get winning white card for round
		data: "",										//	CONTROLLER: REST_AJAXController.java/getRoundWinnerJSON(session)
		type: "GET",									//	return: WhiteCard (deck.getRoundWinner())
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getRoundWinner Datacheck: " + returnedData);
			showWC(returnedData[0].cardText, 0);
		}),
		error: function(xmlhttp, status) {
			console.error("DEBUG... code.js/getRoundWinner().ajax.failure: " + status);
		}
	})	
}




