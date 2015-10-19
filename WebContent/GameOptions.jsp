<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>Game Options</title>
		<link rel="stylesheet" type="text/css" href="/DAH/CSS/dahstyle.css">
		<link rel="stylesheet" type="text/css" href="/DAH/CSS/GameOptionsCSS.css">
		<link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
		
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
		<script src="/DAH/js/code.js"></script>
		<script src="/DAH/js/gameoptions.js"></script>
		<script>
		var gameopt = document.getElementById("gameopt");

		$(document).ready(function() {	
			
			
			displayGameOptions();
		})			// end of document.ready
		</script>
		
	</head>
	
	

	<body>
		<div id="gameopt" name="gameopt" class="gameopt"></div>
	</body>
</html>