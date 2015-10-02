<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset=UTF-8">
		<title>Display the Winner!</title>
		<link rel="stylesheet" type="text/css" href="CSS/dahstyle.css">
		
		<script>
		
		</script>
		
		<style>
		
		</style>
	</head>

	<body>
		<h1 class="roundlabel">ROUND</h1>
		<div id="roundnum"><c:out value="${endOfRound}" /></div>
		<h2 class="instructions">The winner of the round has been selected!</h2>
		
		<form action="NextRound.html" method="POST" >
		<div id="blackcardstock">
			<div class="bc">
				<c:out value="${blackcard.toString()}" />
			</div>
		</div>
		
		<div class="cardstock" id="winningcard">
			<div class="wc" id="wc0">
				<c:out value="${winningCard.toString()}" />
			</div>
		</div>

		<input type="submit" value="PLAY NEXT ROUND!" /> 

		
		</form>
	</body>
</html>