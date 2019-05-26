<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Display</title>
</head>
<body>
	<%
		PrintWriter pout = response.getWriter();
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		int fno = Integer.parseInt(request.getParameter("fno"));
		String date = request.getParameter("date");
		int sno = new Random().nextInt(500) + 1;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			if(conn!=null){
				Statement stmt = (Statement)conn.createStatement();
				stmt.executeUpdate("insert into SeatReservation values ("+fno+",'"+date+"',"+sno+",'"+name+"','"+number+"');");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
	%>
</body>
</html>