<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>Login Menu</title>
		<link rel="stylesheet" type="text/css" href="/DAH/CSS/dahstyle.css">
		<link rel="stylesheet" type="text/css" href="/DAH/CSS/LoginMenuCSS.css">
		<link href='https://fonts.googleapis.com/css?family=Permanent+Marker' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
		
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
		<script src="/DAH/js/code.js"></script>
		<script src="/DAH/js/loginmenu.js"></script>
		<script src="/DAH/js/gameoptions.js"></script>
		<script>
		var menudiv = document.getElementById("menudiv");

		$(document).ready(function() {			
			displayInitial();
		})			// end of document.ready
		</script>
		
	</head>
	
	

	<body>
		<div id="menudiv" name="menudiv" class="menudiv"></div>
	</body>
</html>