
function displayInitial() {
	$("#loginformdiv").fadeOut("slow");
	$("#loginerrormsg").fadeOut("slow");
	$("#newplayerformdiv").fadeOut("slow");
	$("#newpalyererrormsg").fadeOut("slow");
	$("#loggedindiv").fadeOut("slow");
	
/* 			menudiv.removeChild(document.getElementById("loginformdiv"));
			menudiv.removeChild(document.getElementById("loginerrormsg"));
			menudiv.removeChild(document.getElementById("newplayerformdiv"));
			menudiv.removeChild(document.getElementById("newplayererrormsg"));
			menudiv.removeChild(document.getElementById("loggedindiv"));			 */
	if($("#DAHLogo").length == 0) {
		var DAHlogodiv = document.createElement("div");
		var sublogodiv = document.createElement("div");
		var hr = document.createElement("hr");
		
		DAHlogodiv.setAttribute(	"id", 		"DAHLogo");
		DAHlogodiv.setAttribute(	"name", 	"DAHLogo");
		DAHlogodiv.setAttribute(	"class", 	"DAHLogo");
		DAHlogodiv.innerHTML = 		"Developers Against Humanity (DAH)!";
		
		sublogodiv.setAttribute(	"id", 		"subLogo");
		sublogodiv.setAttribute(	"name", 	"subLogo");
		sublogodiv.setAttribute(	"class", 	"subLogo");
		sublogodiv.innerHTML = 		"Making a smarter ghost...";
		
		hr.setAttribute(			"id", 		"seperator");
		hr.setAttribute(			"name", 	"seperator");
		hr.setAttribute(			"class", 	"seperator");
		
		menudiv.appendChild(DAHlogodiv);
		menudiv.appendChild(sublogodiv);
		menudiv.appendChild(hr);
	}
	var signindiv = document.createElement("div");
	var signupdiv = document.createElement("div");
	
	menudiv.appendChild(signindiv);
	menudiv.appendChild(signupdiv);
	
	
	signindiv.setAttribute(		"id", 		"signinlabel");
	signindiv.setAttribute(		"name", 	"signinlabel");
	signindiv.setAttribute(		"class", 	"labelbtn");
	signindiv.innerHTML = 		"Sign In";
	
	signupdiv.setAttribute(		"id", 		"signuplabel");
	signupdiv.setAttribute(		"name", 	"signuplabel");
	signupdiv.setAttribute(		"class", 	"labelbtn");
	signupdiv.innerHTML = 		"Sign Up";
	
	
	$("#newplaysubmit").prop("disabled", true);					//	start with newplaysubmit button disabled
	
	$("#signinlabel").click(function() {						//	start with Sign In button available
console.log("#signinlabel.click activated.")
		displayLogin();
	});

	$("#signuplabel").click(function() {						//	if Sign Up button is clicked, hide buttons and show Sign Up form
console.log("#signuplabel.click activated.")
		$("#signinlabel").slideUp();
		$("#signuplabel").slideUp();
		displayNewPlayer();
	});

	$("#subLogo").click(function() {							//	the "Making a Smarter Ghost" text is a hidden switch to show the story
console.log("#sublogodiv.click activated.")
		if($("#story").is(":hidden")) {
			$("#story").show("slow");
		} else {
			$("#story").slideUp();
		}
	});
}

function displayLogin() {
	$("#signinlabel").fadeOut("slow");
	$("#signuplabel").fadeOut("slow");
	menudiv.removeChild(document.getElementById("signinlabel"));
	menudiv.removeChild(document.getElementById("signuplabel"));
	
	var loginformdiv = document.createElement("div");
	var loginerrormsg = document.createElement("div");
	
	menudiv.appendChild(loginformdiv);
	menudiv.appendChild(loginerrormsg);
	
	loginformdiv.setAttribute(		"id", 		"loginformdiv");
	loginformdiv.setAttribute(		"name", 	"loginformdiv");
	loginformdiv.setAttribute(		"class", 	"loginformdiv");
	var loginform = document.createElement("form");
		loginform.setAttribute(		"id", 		"loginform");
		loginform.setAttribute(		"name", 	"loginform");
		loginform.setAttribute(		"class", 	"inputform");
		loginform.setAttribute(		"action", 	"Login");
		loginform.setAttribute(		"method", 	"POST");
		var loginUNdiv = document.createElement("div");
		loginUNdiv.setAttribute(	"id", 		"loginUNdiv");
		loginUNdiv.setAttribute(	"name", 	"loginUNdiv");
		loginUNdiv.setAttribute(	"class", 	"UNdiv");
			var loginUNlbl = document.createElement("label");
			loginUNlbl.setAttribute("id", 		"usernamelbl");
			loginUNlbl.setAttribute("name", 	"usernamelbl");
			loginUNlbl.setAttribute("class", 	"label");
			loginUNlbl.innerHTML = "Username:"
			var loginUNbox = document.createElement("input");
			loginUNbox.setAttribute("id", 		"username");
			loginUNbox.setAttribute("name", 	"username");
			loginUNbox.setAttribute("class", 	"inputbox");
			loginUNbox.setAttribute("type",		"text");
		loginUNdiv.appendChild(loginUNlbl);
		loginUNdiv.appendChild(loginUNbox);
		var loginPWdiv = document.createElement("div");
		loginPWdiv.setAttribute(	"id", 		"loginPWdiv");
		loginPWdiv.setAttribute(	"name", 	"loginPWdiv");
		loginPWdiv.setAttribute(	"class", 	"loginPWdiv");
			var loginPWlbl = document.createElement("label");
			loginPWlbl.setAttribute("id", 		"passwordlbl");
			loginPWlbl.setAttribute("name", 	"passwordlbl");
			loginPWlbl.setAttribute("class", 	"label");
			loginPWlbl.innerHTML = "Password:"
			var loginPWbox = document.createElement("input");
			loginPWbox.setAttribute("id", 		"password");
			loginPWbox.setAttribute("name", 	"password");
			loginPWbox.setAttribute("class", 	"inputbox");
			loginPWbox.setAttribute("type",		"password");
		loginPWdiv.appendChild(loginPWlbl);
		loginPWdiv.appendChild(loginPWbox);
		var loginsubmitbtn = document.createElement("div");
		loginsubmitbtn.setAttribute("id",		"loginsubmitbtn");
		loginsubmitbtn.setAttribute("name",		"loginsubmitbtn");
		loginsubmitbtn.setAttribute("class", 	"labelbtn");
		loginsubmitbtn.innerHTML = "Login";
		var loginGuestbtn = document.createElement("div");
		loginGuestbtn.setAttribute("id",		"loginGuestbtn");
		loginGuestbtn.setAttribute("name",		"loginGuestbtn");
		loginGuestbtn.setAttribute("class", 	"labelbtn");
		loginGuestbtn.innerHTML = "Play as Guest";
		var loginBack = document.createElement("div");
		loginBack.setAttribute(		"id",		"loginBack");
		loginBack.setAttribute(		"name",		"loginBack");
		loginBack.setAttribute(		"class",	"labelbtn");
		loginBack.innerHTML = "Back";
		
		loginformdiv.appendChild(loginform);
		loginform.appendChild(loginUNdiv);	
		loginform.appendChild(loginPWdiv);
		loginformdiv.appendChild(loginsubmitbtn);	
		loginformdiv.appendChild(loginGuestbtn);	
		loginformdiv.appendChild(loginBack);

		$("#loginsubmitbtn").click(function() {
console.log("#loginsubmitbtn.click activated.")
console.log($("#loginform").serialize());
				$.ajax({											//	process login 
					url: "REST/login",								//	CONTROLLER: LoginController.java/on Submit(String u, String p, session)
					method: "POST",									//	return: LocalPlayer (from findPlayer(u, p) in LoginController)
					dataType: "json",
					data: $("#loginform").serialize(),
					success: (function(returnedData, status) {	
console.log("Back from LoginController" + returnedData);
						menudiv.removeChild(loginformdiv);
						menudiv.removeChild(loginerrormsg);
						displayLoggedIn(returnedData);
console.log("Still in loginsubmitbtn ajax success - after displayLoggedIn()")
						
						$("#loginformdiv").slideUp();				//	hide loginformdiv
						$("#loggedindiv").slideDown();				//	show loggedindiv
						$("#playrecordframe").slideDown();			//	show playrecordframe
						$("#gameoptionsframe").slideDown();			//	show gameoptionsframe
					}),
					error: function(xmlhttp, status) {
						console.error("DEBUG... index.jsp/login().ajax.failure: " + status);
					}
				})
			})
			
		$("#loginGuestbtn").click(function(evt) {
console.log("$loginGuestbtn.click activated");
			document.getElementById("username").value = "guest";
			document.getElementById("password").value= "pass";
			$("#loginsubmitbtn").click();
		})
		
		$("#loginBack").click(function() {
console.log("$loginBack.click activated")
		menudiv.removeChild(loginformdiv);
		menudiv.removeChild(loginerrormsg);
			displayInitial();
		});

}

function displayNewPlayer() {
	$("#signindiv").fadeOut("slow");
	$("#signupdiv").fadeOut("slow");
	menudiv.removeChild(document.getElementById("signinlabel"));
	menudiv.removeChild(document.getElementById("signuplabel"));
	
	var newplformdiv = document.createElement("div");
	var newplerrormsg = document.createElement("div");
	
	menudiv.appendChild(newplformdiv);
	menudiv.appendChild(newplerrormsg);
	
	newplformdiv.setAttribute(		"id", 		"newplformdiv");
	newplformdiv.setAttribute(		"name", 	"newplformdiv");
	newplformdiv.setAttribute(		"class", 	"newplformdiv");
	newplerrormsg.setAttribute(		"id",		"newplerrormsg");
	newplerrormsg.setAttribute(		"name",		"newplerrormsg");
	newplerrormsg.setAttribute(		"class",	"error");
	
	var newplform = document.createElement("form");
		newplform.setAttribute(		"id", 		"newplform");
		newplform.setAttribute(		"name", 	"newplform");
		newplform.setAttribute(		"class", 	"newplform");
		newplform.setAttribute(		"action", 	"NewPlayer");
		newplform.setAttribute(		"method", 	"POST");
		
		var newplUNdiv = document.createElement("div");
		newplUNdiv.setAttribute(	"id", 		"newplUNdiv");
		newplUNdiv.setAttribute(	"name", 	"newplUNdiv");
		newplUNdiv.setAttribute(	"class", 	"newplUNdiv");
			var newplUNlbl = document.createElement("label");
			newplUNlbl.setAttribute("id", 		"usernamelbl");
			newplUNlbl.setAttribute("name", 	"usernamelbl");
			newplUNlbl.setAttribute("class", 	"label");
			newplUNlbl.innerHTML = "Username:"
			var newplUNbox = document.createElement("input");
			newplUNbox.setAttribute("id", 		"username");
			newplUNbox.setAttribute("name", 	"username");
			newplUNbox.setAttribute("class", 	"inputbox");
			newplUNbox.setAttribute("type",		"text");
		newplUNdiv.appendChild(newplUNlbl);
		newplUNdiv.appendChild(newplUNbox);
		
		var newplPWdiv = document.createElement("div");
		newplPWdiv.setAttribute(	"id", 		"newplPWdiv");
		newplPWdiv.setAttribute(	"name", 	"newplPWdiv");
		newplPWdiv.setAttribute(	"class", 	"newplPWdiv");
			var newplPWlbl = document.createElement("label");
			newplPWlbl.setAttribute("id", 		"passwordlbl");
			newplPWlbl.setAttribute("name", 	"passwordlbl");
			newplPWlbl.setAttribute("class", 	"label");
			newplPWlbl.innerHTML = "Password:"
			var newplPWbox = document.createElement("input");
			newplPWbox.setAttribute("id", 		"password");
			newplPWbox.setAttribute("name", 	"password");
			newplPWbox.setAttribute("class", 	"inputbox");
			newplPWbox.setAttribute("type",		"password");
		newplPWdiv.appendChild(newplPWlbl);
		newplPWdiv.appendChild(newplPWbox);
		
		var newplPWconfdiv = document.createElement("div");
		newplPWconfdiv.setAttribute(	"id", 		"newplPWconfdiv");
		newplPWconfdiv.setAttribute(	"name", 	"newplPWconfdiv");
		newplPWconfdiv.setAttribute(	"class", 	"newplPWconfdiv");
			var newplPWconflbl = document.createElement("label");
			newplPWconflbl.setAttribute("id", 		"newplPWconflbl");
			newplPWconflbl.setAttribute("name", 	"newplPWconflbl");
			newplPWconflbl.setAttribute("class", 	"label");
			newplPWconflbl.innerHTML = "Confirm Password:"
			var newplPWconfbox = document.createElement("input");
			newplPWconfbox.setAttribute("id", 		"passwordconf");
			newplPWconfbox.setAttribute("name", 	"passwordconf");
			newplPWconfbox.setAttribute("class", 	"inputbox");
			newplPWconfbox.setAttribute("type",		"password");
		newplPWconfdiv.appendChild(newplPWconflbl);
		newplPWconfdiv.appendChild(newplPWconfbox);
		
		var newplnicknamediv = document.createElement("div");
		newplnicknamediv.setAttribute("id",		"newplnicknamediv");
		newplnicknamediv.setAttribute("name",	"newplnicknamediv");
		newplnicknamediv.setAttribute("class",	"newplnicknamediv");
			var newplnicknamelbl = document.createElement("label");
			newplnicknamelbl.setAttribute("id",		"newplnicknamelbl");
			newplnicknamelbl.setAttribute("name",	"newplnicknamelbl");
			newplnicknamelbl.setAttribute("class",	"label");
			newplnicknamelbl.innerHTML = "Nickname:"
			var newplnicknamebox = document.createElement("input");
			newplnicknamebox.setAttribute("id",		"nickname");
			newplnicknamebox.setAttribute("name",	"nickname");
			newplnicknamebox.setAttribute("class",	"inputbox");
			newplnicknamebox.setAttribute("type",	"text");
		newplnicknamediv.appendChild(newplnicknamelbl);
		newplnicknamediv.appendChild(newplnicknamebox);
		
		var statUNdiv = document.createElement("div");
		statUNdiv.setAttribute("id", "statUNdiv");
		statUNdiv.setAttribute("name", "statUNdiv");
			var statUN = document.createElement("img");
			statUN.setAttribute("id", "statUN");
			statUN.setAttribute("name", "statUN");
			statUN.setAttribute("class", "statusicon");
			statUN.setAttribute("alt", "UNstatus");
			statUN.setAttribute("src", "/DAH/images/status/ellipse.png");
			statUNdiv.appendChild(statUN);
			
		var statPWdiv = document.createElement("div");
		statPWdiv.setAttribute("id", "statPWdiv");
		statPWdiv.setAttribute("name", "statPWdiv");
			var statPW = document.createElement("img");
			statPW.setAttribute("id", "statPW");
			statPW.setAttribute("name", "statPW");
			statPW.setAttribute("class", "statusicon");
			statPW.setAttribute("alt", "PWstatus");
			statPW.setAttribute("src", "/DAH/images/status/ellipse.png");
			statPWdiv.appendChild(statPW);
			
		var newplsubmitbtn = document.createElement("div");
		newplsubmitbtn.setAttribute("id",		"newplsubmitbtn");
		newplsubmitbtn.setAttribute("name",		"newplsubmitbtn");
		newplsubmitbtn.setAttribute("class", 	"labelbtn");
		newplsubmitbtn.innerHTML = "Create Account";
		
		var newplBack = document.createElement("div");
		newplBack.setAttribute(		"id",		"newplBack");
		newplBack.setAttribute(		"name",		"newplBack");
		newplBack.setAttribute(		"class",	"labelbtn");
		newplBack.innerHTML = "Back";
		
	newplformdiv.appendChild(newplform);
	newplform.appendChild(newplUNdiv);	
	newplform.appendChild(newplPWdiv);
	newplform.appendChild(newplPWconfdiv);
	newplform.appendChild(newplnicknamediv);
	newplformdiv.appendChild(newplsubmitbtn);	
	newplformdiv.appendChild(newplBack);
	newplformdiv.appendChild(statUNdiv);
	newplformdiv.appendChild(statPWdiv);
	
	$("#newplformdiv").change(function() {						//	when anything changes in Sign Up form, re-verify 
		
	});
	
	$("#newplUNdiv").focusout(function() {					//	when the user tabs out of the username box, check if username is available
		console.log(document.getElementById("username").value);
		if(document.getElementById("username").value.length > 3) {
			checkUsername(document.getElementById("username").value);
			
		}
	});
	
	$("#newplsubmitbtn").click(function() {
		console.log(verifyproceed());
	if(verifyproceed()){
		$.ajax({
			url: "REST/NewPlayer",
			method: "POST",
			dataType: "json",
			data: $("#newplform").serialize(),
			success: (function(returnedData, status) {
				console.log("Back from NewPlayerController" + returnedData);
				menudiv.removeChild(newplformdiv);
				menudiv.removeChild(newplerrormsg);

				displayLoggedIn(returnedData);			
			}),
			error: function(xmlhttp, status) {
				console.error("DEBUG... index.jsp.newplaysubmit().ajax.failure: " + status);
			}
		})
	}
	})
	
	$("#passwordconf").keyup(function(evt) {
		var c = evt.target.value;
		var conf = document.getElementById("passwordconf");
		var orig = document.getElementById("password").value;
		var stat = document.getElementById("statPW");
	
		console.log("in #confirmPassbox.keypress. " + c.length + " " + orig.length);
			stat.setAttribute("src", "/DAH/images/status/nope.png");
			stat.setAttribute("class", "staticon");
			stat.setAttribute("alt", "staticon");
		if(c.length > 3 && c.length <= orig.length) {
			if(c == orig.substr(0, c.length)) {
				stat.setAttribute("src", "/DAH/images/status/ellipse.png");
				if(c == orig.substr(conf.length)) {
					stat.setAttribute("src", "/DAH/images/status/check.png")
					conf.setAttribute("check", "yes");
				}
			}
			else { 
				stat.setAttribute("src", "/DAH/images/status/nope.png"); 
				conf.setAttribute("check", "no");
			}
		}
	});
	
	$("#newplBack").click(function() {
		menudiv.removeChild(newplformdiv);
		menudiv.removeChild(newplerrormsg);
		displayInitial();
	});
	
	function verifyproceed() {
		var goodusername = document.getElementById("username").getAttribute("check");
		var goodpassword = document.getElementById("passwordconf").getAttribute("check");
		console.log("to activate button username and password must be checked: " + goodusername + " " + goodpassword);
		if(goodusername == "yes" && goodpassword == "yes") {
			return true;
		} else {
			return false;
		}
		console.log("in verifyproceed(). status of submit button: " + $("#newplsubmitbtn").prop("disabled"));
	}

	function checkUsername(username) {							//	send username to REST_AJAX Controller checkusername
		console.log("in code.js checkUsername() function.")		//	returns true if the username is already in database (prevents use of button until fixed)
		var myurl = "REST/checkUsername?username=" + username;
		$.ajax({								
			url: myurl,											//	CONTROLLER: REST_AJAXController.java/checkUsernameJSON(String u)
			data: "",											//	return: boolean (if ElementList.isEmpty())
			type: "GET",
			dataType: "json",
			success: (function(returnedData, status) {
				var mydiv = document.getElementById("username");
				var msg = document.getElementById("newplerrormsg");
				var stat = document.getElementById("statUN");
//				console.log("DEBUG... /DAH/REST/checkUsername Datacheck: " + msg);
					stat.setAttribute("class", "staticon");
					stat.setAttribute("alt", "staticon");
					stat.setAttribute("src", "/DAH/images/status/ellipse.png")
					msg.innerHTML = "";
					msg.setAttribute("class", "error");
				if(returnedData == false) {
					stat.setAttribute("src", "/DAH/images/status/check.png");
					msg.innerHTML = "Username is available.";
					msg.style.color = "green";
					mydiv.setAttribute("check", "yes");
					verifyproceed();
					console.log("in code.js checkUsername() function - returnedData is false : " + stat);
				} else {
					stat.setAttribute("src", "/DAH/images/status/nope.png");
					msg.innerHTML = "Username is already taken. Please enter new username.";
					msg.style.color = "red";
					mydiv.setAttribute("check", "no");
					verifyproceed();
					console.log("in code.js checkUsername() function - returnedData is true : " + stat);
				}
			}),
			error: function(xmlhttp, status) {
				console.error("DEBUG... index.jsp/checkUsername().ajax.failure: " + status);
			}
		})
	}
}

function displayLoggedIn(returnedData) {
	var loggedindiv = document.createElement("div");
	
	menudiv.appendChild(loggedindiv);
	
	var welcomediv = document.createElement("div");
	var settingsdiv = document.createElement("div");
	var avatardiv = document.createElement("div");
	
	menudiv.appendChild(welcomediv);
	menudiv.appendChild(settingsdiv);
	menudiv.appendChild(avatardiv);
	
	welcomediv.setAttribute(		"id",		"welcomediv");
	welcomediv.setAttribute(		"name",		"welcomediv");
	welcomediv.setAttribute(		"class",	"welcomediv");
	welcomediv.innerHTML = "Welcome, ";
	var nicknamespan = document.createElement("span");
		nicknamespan.setAttribute(	"id",		"nick");
		nicknamespan.setAttribute(	"name",		"nick");
	welcomediv.appendChild(nicknamespan);
	
	settingsdiv.setAttribute(		"id",		"settingsdiv");
	settingsdiv.setAttribute(		"name",		"settingsdiv");
	settingsdiv.setAttribute(		"class",	"settingsdiv");
	var menusettings = document.createElement("img");
		menusettings.setAttribute(	"id",		"menusettings");
		menusettings.setAttribute(	"name",		"menusettings");
		menusettings.setAttribute(	"class",	"menusettings");
		menusettings.setAttribute(	"alt",		"menusettings");
		menusettings.setAttribute(	"src",		"/DAH/images/settings.png");
	settingsdiv.appendChild(menusettings);
	
	avatardiv.setAttribute(		"id",		"avatardiv");
	avatardiv.setAttribute(		"name",		"avatardiv");
	avatardiv.setAttribute(		"class",	"avatardiv");
	var playeravatar = document.createElement("img");
		playeravatar.setAttribute(	"id",		"playeravatar");
		playeravatar.setAttribute(	"name",		"playeravatar");
		playeravatar.setAttribute(	"class",	"playeravatar");
		playeravatar.setAttribute(	"alt",		"playeravatar");
	avatardiv.appendChild(playeravatar);

	localplayer = returnedData;
	document.getElementById("nick").innerHTML 			= returnedData.nickname;
	document.getElementById("playeravatar").setAttribute("src", returnedData.avatar);

	dispGO();
	
	$("#menusettings").click(function() {
		console.log("Settings not implemented at this time, but ready.")
	});
	
	function dispGO() {
		$("#gameoptions").load("GameOptions.jsp");
	}
}




