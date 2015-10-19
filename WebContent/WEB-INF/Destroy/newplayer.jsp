<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create New Player Account</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
			function checkUsername() {									//	on keypress show if username already exists in DB
				var username = document.getElementById("username");
				var i = username.length;
				
				if(i < 3) {
					break;												//	username must be at least 3 characters in length
				}
				
				//	check if username is already in DB
			}
			
			function verifyPassword() {
				var origpassword = document.getElementById("origpassword");
				var veripassword = document.getElementById("veripassword");
				var i = veripassword.length;
				
				if(origpassword.length == 0) {
					break;												//	when orig password is blank, don't verify
				}
				if(veripassword.substr(veripassword, 0, i) == origpassword.substr(origpassword, 0, i)) {
					veripassword.backgroundcolor = green;				//	when all keystrokes entered so far match, keep green but continue
				} else {
					document.getElementById("pwderror").display = block;
					veripassword.backgroundcolor = red;					//	when any keystroke entered so far is mismatch, turn red and force changes
					break;
				}
				
				if(i == origpassword.length) {
					document.getElementById("pwdgood").display = block;	//	when both passwords are equal (and same length) make good message appear
					document.getElementById("Create").activate = true;	//	submit button is turned off until passwords match
				}
				
			}
		
		</script>
	</head>

	<body>
		<h1>New Player Account</h1>
		<form action="NewPlayer.html" method="POST" >
		<div id="errmsg">${error}</div>
		<p>
		<div id="usrname">
			<p>Username:</p>
			<div class="input">
				<input type="text"		name="username" id="username" onlostfocus="checkUsername()">
			</div>
		</div>
		<div id="passwrd">
			<p>Password:</p>
			<div class="input">
				<input type="password"	name="password" id="origpassword">
			</div>
		</div>
		<div id="passwrd">
			<p>Confirm Password:</p>
			<div class="input">
				<input type="password"	name="confirmPwd" id="veripassword" onkeypress="verifyPassword()">
			</div>
		</div>
		
		<div id="optional">
			<p>Optional:</p>
		</div>
		
		<div id="nickname">
		<p>Nickname:</p>
			<div class="input">
				<input type="text"		name="nickname">
			</div>
		</div>
		
		<div id="avatar">
		<p>Avatar (upload .jpg or (better!) .png file of your avatar (leave blank for default)):</p>
			<div class="input">
				<input type="file"		name="avatar">
			</div>
		</div>
		
		<div id="submit">
			<div class="button">
				<input type="submit"	name="Create" >
			</div>
		</div>
		
		</form>
	</body>
</html>