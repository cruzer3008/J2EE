<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ViewDisplay.jsp">
		Name: <input type="text" name="name">
		Number: <input type="number" name="number">
		Flight No: <input type="number" name="fno">
		Date: <input type="text" name="date">
		<input type="submit" value="BOOK">
	</form> 
	
	<form action="ShowFlights.jsp" >
		Day:<input type="number" name="day">
		<input type="submit">
	</form>
</body>
</html>