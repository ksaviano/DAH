<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Display the Winner!</title>
	</head>

	<body>
		<h1>ROUND <c:out value="${endOfRound}" /></h1>
		
		<h2>The winner of the round has been selected!</h2>
		
		BLACK CARD: <c:out value="${blackcard.toString()}" /> <br>
		WINNING CARD: <c:out value="${winningCard.toString()}" />
		
		
		<form action="NextRound.html" method="POST" >
		
		<table border="1" class="left">
			 <tr><td> <input type="submit" value="PLAY NEXT ROUND!" /> </td> </tr>
		</table>
		
		</form>
	</body>
</html>