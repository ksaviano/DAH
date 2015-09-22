<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>profile</title>
	</head>

	<body>
		<h1>Profile.jsp</h1>
		
		Welcome ${localPlayer.username}
		
		<form action="StartGame.html" method="POST" >
		<table border="1" class="left">
			<tr><td>Your record:</td></tr>
			<tr><td><td>Games played:	</td><td><c:out value="${localPlayer.getGamesPlayed()}" />    </td></tr>
			<tr><td><td>Hands won:		</td><td><c:out value="${localPlayer.getHandsWon()}" /> </td></tr>
			<tr><td><td>Horrible Points:</td><td><c:out value="${localPlayer.getHorriblePoints()}" /></td></tr>
		</table>
			
			<input type="submit" value="PLAY!" />
		</form>
	</body>
</html>