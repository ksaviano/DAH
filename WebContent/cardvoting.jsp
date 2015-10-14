<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Card Descriptions</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<style>
			
		</style>
		
		<script>
			function submitvotes() {
				
			}
		</script>
	</head>

	<body>
		<h2 class="instructions">Please share your thoughts about this particular white card.</h2>
		
		<div id="card0">${card0.toString()}</div>
		
		<form action="CastVotes.html" id="voteform" method="POST" onsubmit="submitvotes()">
		
		<div id="pg13"><input type="checkbox" name="votes" value="pg13">pg13</div>
		<div id="xxx"><input type="checkbox" name="votes" value="xxx">xxx</div>
		<div id="dunno"><input type="checkbox" name="votes" value="dunno">dunno</div>
		<div id="gross"><input type="checkbox" name="votes" value="gross">gross</div>
		<div id="inapprop"><input type="checkbox" name="votes" value="inapprop">inapprop</div>
		<div id="submitbtn"><input type="submit" name="submit"></div>
		
	</body>
</html>