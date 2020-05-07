<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authorization</title>
</head>
<body>
	<form action="abc" method="get">
		<fieldset>
			<legend>Authorization</legend>
			<input type="hidden" name="command" value="authorization" />
			
			Login:<br/>
			<input type="text" name="login" value="" /><br/>
			
			Password:<br/>
			<input type="password" name="password" value="" /><br/>
			
			<input type="submit" value="Enter"/>
		</fieldset>
	</form>
</body>
</html>