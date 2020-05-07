<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="abc" method="get">
		<fieldset>
			<legend>Registration</legend>
			<input type="hidden" name="command" value="registration" />
			
			Login:<br/>
			<input type="text" name="login" value="" /><br/>
			
			Password:<br/>
			<input type="password" name="password" value="" /><br/>
			
			Name:<br/>
			<input type="text" name="name" value="" /><br/>
			
			Surname:<br/>
			<input type="text" name="surname" value="" /><br/>
			
			<input type="submit" value="Enter"/>
		</fieldset>
	</form>
</body>
</html>