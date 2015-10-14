//	Display Cards AJAX Calls (for use in choosecard.jsp and selectwinner.jsp and showwinner.jsp)

function getRoundNum() {
	$.ajax({											//	get roundnum
		url: "/DAH/REST/getRoundNum",
		data: "",
		type: "GET",
		dataType: "text",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getRoundNum  Datacheck: " + returnedData);
			$("#roundnum").html(returnedData);
		}),
		error: function(xmlhttp, status) {
			console.error("ROUNDNUM playerhand-ajax.html/document.ready.ajax.failure: " + status);
		}
	})
}

function getBlackCard() {
	$.ajax({
		url: "/DAH/REST/getBlackCard",					//	gets CURRENT black card (does not draw new card)
		data: "",
		type: "GET",
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getBlackCard  Datacheck: " + returnedData);
			var bc = document.getElementById("blackcard");
			bc.setAttribute("class", "blackcard");
			bc.innerHTML = returnedData.questionText;
		}),
		error: function(xmlhttp, status) {
			console.error("playerhand-ajax.html/document.ready.ajax.failure: " + status);
		}
	})
}

function getPlayerHand() {
	$.ajax({
		url: "/DAH/REST/getPlayerHand",					//	get playerHand
		data: "",
		type: "GET",
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getPlayerHand  Datacheck: " + returnedData);
			for(var x = 0; x < returnedData.length; x++) {
				showWC(returnedData[x].cardText, x);
				x++;
			}
		}),
		error: function(xmlhttp, status) {
			console.error("playerhand-ajax.html/document.ready.ajax.failure: " + status);
		}
	})
}

function getRoundPlays() {
	$.ajax({
		url: "DAH/REST/getRoundPlays",					//	get player's choice and ghost decisions
		data: "",
		type: "GET",
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getRoundPlays  Datacheck: " + returnedData);
			for(var x = 0; x < returnedData.length; x++) {
				showWC(returnedData[x].cardText, x);
				x++;
			}
		}),
	})
}

function getRoundWinner() {
	$.ajax({
		url: "DAH/REST/getRoundWinner",					//	get winning white card for round
		data: "",
		type: "GET",
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/getRoundWinner Datacheck: " + returnedData);
			showWC(returnedData[0].cardText, 0);
		})
	})
	
}

function checkUsername() {
	$.ajax({
		url: "DAH/REST/checkUsername",
		data: "",
		type: "GET",
		dataType: "json",
		success: (function(returnedData, status) {
			console.log("DEBUG... /DAH/REST/checkUsername Datacheck: " + returnedData);
			var msg = document.getElementById("#chkusername");
			var stat = document.createElement("img");
				stat.setAttribute("height", "15px");
				stat.setAttribute("width", "15px");
				stat.setAttribute("class", "staticon");
				stat.setAttribute("alt", "staticon");
				stat.setAttribute("display", "block");
				msg.setAttribute("display", "block");
			if(returnedData == "false") {
				stat.setAttribute("src", "/images/status/check.png");
				msg.innerHTML = "Username is available.";
				msg.setAttribute("check", "yes");
			} else {
				stat.setAttribute("src", "/images/status/nope.png");
				msg.innerHTML = "Username is already taken. Please enter new username.";
				msg.setAttribute("check", "no");
			}
		})
	})
}

function checkPassword() {
	
}

