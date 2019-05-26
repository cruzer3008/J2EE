<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Capture</title>
</head>
<body>
	<%
		HashMap<String, String> hm = new HashMap<String, String>();		
		hm.put("A","A");
		hm.put("B","B");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter pout = response.getWriter();
		if(hm.containsKey(name)&&password.equals(hm.get(name)))
		{
			pout.println("Welcome "+ name);
			pout.println(new Date());
	%>
	
	<form method="get" action="CalculateTax.jsp">
		Name = <input type="text" name="name">
		Profession = 
		<select name="prof">
			<option>Engineer</option>
			<option>Doctor</option>
		</select>
		<select name="gender">
			<option>Male</option>
			<option>Female</option>
		</select>
		Income: <input type="number" name="income">
		<input type="submit" value="SUBMIT">
	</form>
	
	<%
		}else{
	%>
	<jsp:forward page="Login.html"></jsp:forward>
	<%
		}
	%>
	
</body>
</html>