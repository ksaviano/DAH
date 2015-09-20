<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Select the Winner!</title>
	</head>

	<body>
		<h1>ROUND <c:out value="${roundnum}" /></h1>
		
		BLACK CARD: <c:out value="${blackcard.toString()}" />
		
		<form action="EndOfRound.html" method="POST" >
		
		<input type="hidden" name="blackcardID" value="${blackcard.getCardID()}" />
		
		
		<table border="1" class="left">
			<tr> <td> <input type="radio" name="roundwinner" value="localPlayer">	Hi!<c:out value="${playersChoices[0].toString()}" /> </td>
				 <td> <input type="radio" name="roundwinner" value="Blinky"> 		<c:out value="${playersChoices[1].toString()}" /> </td> </tr>
			<tr> <td> <input type="radio" name="roundwinner" value="Pinky"> 		<c:out value="${playersChoices[2].toString()}" /> </td>	
				 <td> <input type="radio" name="roundwinner" value="Inky"> 			<c:out value="${playersChoices[3].toString()}" /> </td> </tr>
			<tr> <td> <input type="radio" name="roundwinner" value="Clyde"> 		<c:out value="${playersChoices[4].toString()}" /> </td>	
				 <td> <input type="submit" value="Submit" /> </td> </tr>
		</table>
		
		</form>
	</body>
</html>