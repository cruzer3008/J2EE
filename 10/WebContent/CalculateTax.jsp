<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		PrintWriter pout = response.getWriter();
		int income = Integer.parseInt(request.getParameter("income"));
		double tax = 0;
		if(income <= 100000){
		}
		if(income>100000 && income<500000){
			tax = (income-100000)*0.15;
		}
		if(income > 500000){
			tax = (income-500000)*0.20 + 400000*0.15;
		}
		pout.print(tax);
	%>
</body>
</html>