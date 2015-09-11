<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Choose Your Card</title>
	</head>

	<body>
		<h1>ROUND <c:out value="${round}" /></h1>
		
		BLACK CARD: <c:out value="${blackcard}" />
		
		<form action="SelectWinner" method="POST" >
		
		<input type="hidden" value="${players}" />
		<input type="hidden" value="${deck}" />
		<input type="hidden" value="${junkpile}" />
		
		<table border="1" class="left">
			<tr> <td> <input type="radio" value="${card[0]}"> <c:out value="${card[0]}" /> </td>
				 <td> <input type="radio" value="${card[1]}"> <c:out value="${card[1]}" /> </td> </tr>
			<tr> <td> <input type="radio" value="${card[2]}"> <c:out value="${card[2]}" /> </td>	
				 <td> <input type="radio" value="${card[3]}"> <c:out value="${card[3]}" /> </td> </tr>
			<tr> <td> <input type="radio" value="${card[4]}"> <c:out value="${card[4]}" /> </td>	
				 <td> <input type="radio" value="${card[5]}"> <c:out value="${card[5]}" /> </td> </tr>
			<tr> <td> <input type="radio" value="${card[6]}"> <c:out value="${card[6]}" /> </td>	
				 <td> <input type="submit" value="Submit" /> </td> </tr>
		</table>
		
		</form>
	</body>
</html>