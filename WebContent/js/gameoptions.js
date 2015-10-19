
function displayGameOptions() {
	
	function outputUpdate(vol) {
		document.querySelector('#roundselect').value = vol;
		console.log("vol: " + vol + "#roundselect: " + document.querySelector('#roundselect').value);
		$("#roundsel").value = vol;
	}
	
	var decks = [ ["Original Cards Against Humanity deck", "original"], 
	              ["Cards Against Humanity expansion decks", "expansion"],
	              ["Uncalled Four: unofficial Colorado deck", "colorado"],
	              ["Dungeons & Dragons: unofficial deck", "dnd"],
	              ["Cards Against Humanity: Science expansion deck", "science"],
	              ["House Cards! Unofficial and Unregulated Player Addition cards", "house"] ];
	
	var censors = [ ["PG-13 Cards included", "pg13"],
	                ["XXX cards included", "xxx"],
	                ["Gross cards included", "gross"],
	                ["Inappropriate cards included", "inapprop"],
	                ["Cards not everyone gets the reference to included", "dunno"] ];

	var maindiv = document.getElementById("gameopt");
	var gameoptframe = document.createElement("div");
	var roundselect = document.createElement("div");
	var deckselect = document.createElement("div");
	var censorselect = document.createElement("div");
	var playgamebtn = document.createElement("div");
	
	gameoptframe.setAttribute("id", "gameoptframe");
	gameoptframe.setAttribute("name", "gameoptframe");
	gameoptframe.setAttribute("class", "gameoptframe");
	maindiv.appendChild(gameoptframe);
	
	gameoptframe.appendChild(roundselect);
	roundselect.setAttribute("id", "roundselect");
	roundselect.setAttribute("name", "roundselect");
	roundselect.setAttribute("class", "roundselect");		
		var roundselectlbl = document.createElement("label");
		roundselectlbl.setAttribute("id", "roundselectlbl");
		roundselectlbl.setAttribute("name", "roundselectlbl");
		roundselectlbl.setAttribute("class", "label");
		roundselectlbl.innerHTML = "Select the number of rounds for your game:";
		roundselect.appendChild(roundselectlbl);
		
		var roundselectfrm = document.createElement("form");
		roundselectfrm.setAttribute("id", "roundselectfrm");
		roundselectfrm.setAttribute("name", "roundselectfrm");
		roundselectfrm.setAttribute("class", "inputform");
		roundselectfrm.setAttribute("action", "StartGame");
		roundselectfrm.setAttribute("method", "POST");
		roundselect.appendChild(roundselectfrm);
		
		var roundbox = document.createElement("input");
		roundbox.setAttribute("id", "roundsel");
		roundbox.setAttribute("name", "roundsel");
		roundbox.setAttribute("class", "input");
		roundbox.setAttribute("type", "range");
		roundbox.setAttribute("min", "3");
		roundbox.setAttribute("max", "10");
		roundbox.setAttribute("value", "5");
		roundbox.setAttribute("step", "1");
		roundbox.setAttribute("oninput", "outputUpdate(value)");
		roundselectfrm.appendChild(roundbox);
		
		var roundoutput = document.createElement("output");
		roundoutput.setAttribute("for", "roundsel");
		roundoutput.setAttribute("id", "roundoutput");
		roundoutput.setAttribute("name", "roundoutput");
		roundoutput.setAttribute("class", "roundoutput");
		roundoutput.innerHTML = 5;
		roundselectfrm.appendChild(roundoutput);		
	
	gameoptframe.appendChild(deckselect);
	deckselect.setAttribute("id", "deckselect");
	deckselect.setAttribute("name", "deckselect");
	deckselect.setAttribute("class", "deckselect");
		var deckselectlbl = document.createElement("label");
		deckselectlbl.setAttribute("id", "deckselectlbl");
		deckselectlbl.setAttribute("name", "deckselectlbl");
		deckselectlbl.setAttribute("class", "label");
		deckselectlbl.innerHTML = "Deck Selector";
		deckselect.appendChild(deckselectlbl);
		
		var deck_everythinglbl = document.createElement("label");
		deck_everythinglbl.setAttribute("id", "deck_everythinglbl");
		deck_everythinglbl.setAttribute("name", "deck_everythinglbl");
		deck_everythinglbl.setAttribute("class", "decklabel");
		deck_everythinglbl.innerHTML = "Gimme everything you got!";
		var deck_everything = document.createElement("input");
		deck_everything.setAttribute("id", "deck_everything");
		deck_everything.setAttribute("name", "deck_everything");
		deck_everything.setAttribute("class", "checkbox");
		deck_everything.setAttribute("type", "checkbox");
		deck_everything.checked;
		deckselect.appendChild(deck_everythinglbl);
		deckselect.appendChild(deck_everything);
		
		for(var i = 0; i < decks.length; i++) {
			var lblname = "deck_" + decks[i][1] + "lbl";
			var templabel = document.createElement("label");
			templabel.setAttribute("id", lblname);
			templabel.setAttribute("name", lblname);
			templabel.setAttribute("class", "decklabel");
			templabel.innerHTML = decks[i][0];
			var deckname = "deck_" + decks[i][1];		
			var tempname = document.createElement("checkbox")
			tempname.setAttribute("id", tempname);
			tempname.setAttribute("name", tempname);
			tempname.setAttribute("class", "checkbox");
			tempname.setAttribute("type", "checkbox");
			tempname.checked;
			deckselect.appendChild(templabel);
			deckselect.appendChild(tempname);
		}

	gameoptframe.appendChild(censorselect);
	censorselect.setAttribute("id", "censorselect");
	censorselect.setAttribute("name", "censorselect");
	censorselect.setAttribute("class", "censorselect");
		var censorselectlbl = document.createElement("label");
		censorselectlbl.setAttribute("id", "censorselectlbl");
		censorselectlbl.setAttribute("name", "censorselectlbl");
		censorselectlbl.setAttribute("class", "label");
		censorselectlbl.innerHTML = "Censorship Selector";
		censorselect.appendChild(censorselectlbl);
		
		var censor_everything = document.createElement("input");
		censor_everything.setAttribute("id", "censor_everything");
		censor_everything.setAttribute("name", "censor_everything");
		censor_everything.setAttribute("class", "checkbox");
		censor_everything.setAttribute("type", "checkbox");
		censor_everything.checked;
		var censor_everythinglbl = document.createElement("label");
		censor_everythinglbl.setAttribute("id", "censor_everythinglbl");
		censor_everythinglbl.setAttribute("name", "censor_everythinglbl");
		censor_everythinglbl.setAttribute("class", "censorlabel");
		censor_everythinglbl.innerHTML = "Gimme everything you got!";
		censorselect.appendChild(censor_everythinglbl);
		censorselect.appendChild(censor_everything);
		
		for(var i = 0; i < censors.length; i++) {
			var censorname = "censor_" + censors[i][1];		
			var tempname = document.createElement("checkbox")
			tempname.setAttribute("id", censorname);
			tempname.setAttribute("name", censorname);
			tempname.setAttribute("class", "checkbox");
			tempname.setAttribute("type", "checkbox");
			tempname.checked;
			var lblname = "censor_" + censors[i][1] + "lbl";
			var templabel = document.createElement("label");
			templabel.setAttribute("id", lblname);
			templabel.setAttribute("name", lblname);
			templabel.setAttribute("class", "censorlabel");
			templabel.innerHTML = censors[i][0];
			censorselect.appendChild(templabel);
			censorselect.appendChild(tempname);
		}
	
	
	gameoptframe.appendChild(playgamebtn);
	playgamebtn.setAttribute("id", "playgamebtn");
	playgamebtn.setAttribute("name", "playgamebtn");
	playgamebtn.setAttribute("class", "labelbtn");
	playgamebtn.innerHTML = "Play Game!";
	
	$("#playgamebtn").click(function(evt) {
		console.log("clicking on playgame button --- so exciting!  " + "roundsel=" + document.querySelector('#roundselect').value);
		document.getElementById("roundsel").innerHTML = document.querySelector('#roundselect').value;
		document.getElementById("roundselectfrm").submit();
	});


}