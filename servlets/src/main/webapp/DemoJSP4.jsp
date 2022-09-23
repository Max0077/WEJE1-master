<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP 4</title>
</head>
<body>

	<form method="post" action="DemoJSP1.jsp">
		<label>Username</label> <input type="text" name="username"> <br>
		<input type="submit" value="Go to JSP 1">
	</form>
	<br>
	<form action="DemoJSP2.jsp">
		<input type="submit" value="Go to JSP 2">
	</form>
	<br>
	<form action="DemoJSP3.jsp">
		<input type="submit" value="Go to JSP 3">
	</form>

</body>
</html>