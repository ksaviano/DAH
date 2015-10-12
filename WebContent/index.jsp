<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Developers Against Humanity</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<style>
		
			body {
				height: 700px;
				background-image: url("images/rainbowbck.jpg");
				background-size: cover;
				background-repeat: no-repeat;
				background-position: center;
				
				font-family: Helvetica;
			} 
			
			#usrname {
				float: left;
				font-size: 1.5em;
				margin-right: 20px;
				
			}
			
			#username div {
				float: clear;
				fontsize: 1.5em;
				background: transparent;
			}
			
			#passwrd {
				margin-left: 20px;
				float: left;
				font-size: 1.5em;
			}
			
			#submit {
				float: clear;
			}
			
			.storyon {
				display: block;
			}
			

			
		</style>
		
		<script>
			function showstory() {
				document.getElementById("story").setAttribute("class", ".storyon");
			}
		</script>
		
		
	</head>

	<body>
	
		<h1>Welcome to DAH! Please login below:</h1>
		
		<div class="story" id="story">
			<p>Once upon a time...</p>
			<p>Well, actually it was around 1980. After years spent in development, Pac-Man was finally read for release!</p>
			<p>Unfortunately, one of the principal players, or rather non-players, was causing quite a few problems. You may have noticed the naming convention of the ghosts in Pac-Man:</p>
			<p>Blinky, Pinky, Inky, ...</p>
			<p>and Clyde.</p> 
			<p>What doesn't fit here? Well, the truth of the story is that Clyde was a last minute replacement for our problem non-player, the 4th alliterative ghost:</p>
			<p>Kinky.</p>
			<p>Kinky was (and still is) a <i>complicated</i> personality. His sense of humor is a little dark. A lot dark. And a lot dirty.</p> 
			<p>After an undocumented incident involving Ms. Pac-Man and a quite unfortunate further indiscretion involving poor little Pac-Man Jr., the developers had no choice but to remove Kinky from the game just before release.</p>
			<p>(please do not ask Pac-Man Jr. for details about the incident with Kinky -- his psychiatrist has recommended that Jr. never revisit those memories again)</p>
			<p>Kinky has had many occupations in the intervening years, but an overwhelming hatred has burned long and deep within him. Now, he has decided on his method for revenge and that is where you come in.</p>
			<p>Determined to win the annual Developers Against Humanity Tournament, Kinky has ensnared his former colleagues and YOU into making him the smartest ghost player of all time. If you've played some knock off version of DAH before, you may have instituted the "ghost card" rule in your household. Basically, for any given round, the "ghost card" is drawn from the top of the pile and mixed in with the other answers. For a completely random pick with no context, it is surprising and amusing how often the "ghost card" pick winds up winning for perfect synchronicity with the black card for that round.</p>
			<p>While enamored with all things chaotic, Kinky no longer wants the ghost card to be a purely random chance event. He knows that if he carefully watches game after game of DAH, he could become the most intelligent ghost ever, winning round after round of DAH hands and finally achieving the noteriety (and associated rewards of fame and fortune) that was stolen from him so long ago.</p>
			<p>As you play DAH, Kinky is always watching. He carefully scrutinizes your picks from your hand, and influences the other ghosts to pick the best card based on these previous games. He demands that when you are shown all 5 cards, that you pick the card that is truly the best answer rather than bolstering your own pathetic ego by picking your own.</p>
			<p>When he has all the information he needs, Kinky will dominate the DAH Tournament and will richly reward those who helped him (as evidenced by Horrible Points!) in his quest to be the smartest ghost!</p>
		</div>
		
		<form action="login.html" method="POST">
		
		<div class="error">${error}</div>
		<p></p>
		<div id="usrname">
			<p>Username:</p>
			<div class="input">
				<input type="text" 		name="username">
			</div>
		</div>
		<div id="passwrd">
			<p>Password:</p>
			<div class="input">
				<input type="password" 	name="password" >
			</div>
		</div>
		<div id="submit">
			<p><input type="submit" 	value="Login"></p>
		</div>
		</form>
		
		<button type="button" name="story" onclick="showstory()" >What's the story, MorningGlory?</button>
		
		<form action="NewPlayer" method="POST" >
			Click <a href="newplayer.jsp">here</a> to create new player account.
		</form>
	</body>
</html>