<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Choose Your Card</title>
	</head>

	<body>
		<h1>ROUND <c:out value="${deck.getRoundnum()}" /></h1>
		
		<h2>Select a card from your hand to play this round.</h2>
		
		BLACK CARD: <c:out value="${blackcard.toString()}" /><br/>
		
		<form action="SelectWinner.html" method="POST" >
		
		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />
		<table border="1" class="left">
			<tr> <td> <input type="radio" name="playerchoice" value="card0"> <c:out value="${card0.toString()}" /> </td>
				 <td> <input type="radio" name="playerchoice" value="card1"> <c:out value="${card1.toString()}"/> </td> </tr>
			<tr> <td> <input type="radio" name="playerchoice" value="card2"> <c:out value="${card2.toString()}" /> </td>	
				 <td> <input type="radio" name="playerchoice" value="card3"> <c:out value="${card3.toString()}" /> </td> </tr>
			<tr> <td> <input type="radio" name="playerchoice" value="card4"> <c:out value="${card4.toString()}" /> </td>	
				 <td> <input type="radio" name="playerchoice" value="card5"> <c:out value="${card5.toString()}" /> </td> </tr>
			<tr> <td> <input type="radio" name="playerchoice" value="card6"> <c:out value="${card6.toString()}" /> </td>	
				 <td> <input type="submit" value="Submit" /> </td> </tr>
		</table>
		
		</form>
	</body>
</html>