<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <jsp:forward page="DemoJSP1.jsp"></jsp:forward> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP 2</title>
</head>
<body>
	<h1>This is JSP 2</h1>
	<%!int num1 = 10;%>
	<%!int num2 = 20;%>
	<%!int num3 = 0;%>
	<%!public void add() {
	num3 = num1 + num2;
}%>
	<%
	add();
	%>
	<%=num3%>
</body>
</html>