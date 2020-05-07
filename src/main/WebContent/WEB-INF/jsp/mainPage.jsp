<%@ page language="java" import="by.htp.ishop.bean.RegisteredUser" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
<%
	String result = (String)request.getAttribute("message");
	out.write("Welcome, " + result + " !!!");
	
	//RegisteredUser regUser = (RegisteredUser)request.getAttribute("myuser");
	//out.write(", " + regUser.getName() + " !!!");
%>
</body>
</html>