<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show FLights</title>
</head>
<body>
	<%
		int day = Integer.parseInt(request.getParameter("day"));
		PrintWriter pout = response.getWriter();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			if(conn!=null){
				Statement stmt = (Statement)conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Flight where Weekdays="+day+";");
				while(rs.next()){
					pout.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>