<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Developers Against Humanity</title>
		<link rel="stylesheet" type="text/css" href="/DAH/CSS/dahstyle.css">
		<link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
		
		<style>
					
		</style>
		
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
		<script src="/DAH/js/code.js"></script>
		<script>
		$(document).ready(function() {
			$("#header").load("LoginMenu.jsp");
		})
		</script>
		
		
	</head>

	<body>
		<div id="header" name="header"></div>
		<div id="gameoptions" name="gameoptions"></div>
		<div id="playerrecord" name="playerrecord"></div>
		<div id="combodisplay" name="combodisplay"></div>
<!-- 	<div id="menudiv" name="menudiv" class="menudiv"></div> -->

		


		
<!-- 		<div id="gameoptionsframe">
			
			<div class="roundselector"><label for="roundsel">Select the numbers of rounds for your game:</label>
			<form id="readytoplayform" action="StartGame" method="POST">
				<input type="range" min="3" max="10" value="5" id="roundsel" name="roundsel" step="1" oninput="outputUpdate(value)">
				<output for="roundsel" id="roundselect">5</output>
			</form>
			</div>
		
			<div id="deckselectorlbl">Deck Selector
				<div id="Deverythinglbl">Gimme Everything you got!</div>						<div id="Deverythingbox"></div>
			<div id="Doriginallbl">Original Cards Against Humanity deck</div>				<div id="Doriginalbox"></div>
				<div id="Dexpansionslbl">Cards Against Humanity expansion decks</div>			<div id="Dexpansionsbox"></div>
				<div id="Ddenverlbl">Uncalled Four: unofficial Colorado deck</div>				<div id="Ddenverbox"></div>
				<div id="Ddndlbl">Dungeons & Dragons: unofficial expansion deck</div>			<div id="Ddndbox"></div>
				<div id="Dsciencelbl">CAH Science expansion deck</div>							<div id="Dsciencebox"></div>
				<div id="Dhouselbl">House Cards! Unofficial and Unregulated Player cards</div>	<div id="Dplayerbox"></div>			
			</div>
			<div id="censorshiplbl">Censorship Selector
	 			<div id="Ceverythinglbl">Gimme Everythign you got!</div>						<div id="Ceverythingbox"></div>
			<div id="Cpg13lbl">PG-13 cards included</div>									<div id="Cpg13box"></div>
				<div id="Cxxxlbl">XXX cards included</div>										<div id="Cxxxbox"></div>
				<div id="Cgrosslbl">Gross cards included</div>									<div id="Cgrossbox"></div>
				<div id="Cinapproplbl">Inappropriate cards included</div>						<div id="Cinappropbox"></div>
				<div id="Cdunnolbl">Cards some players didn't understand the reference</div>	<div id="Cdunnobox"></div>			
			</div>
			
			<div id="playgamebtn" class="labelbtn">Play Game!</div>
		</div> -->

		
		<div id="story" class="story" >
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
	</body>
</html>