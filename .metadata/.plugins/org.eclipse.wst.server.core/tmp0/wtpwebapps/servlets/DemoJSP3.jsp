<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="DemoJSP1.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP 3</title>
</head>
<body>
	<h1>This is JSP 3</h1>

	<%!ArrayList<Integer> arr = new ArrayList<Integer>();%>
	<%
	arr.add(10);
	arr.add(20);
	arr.add(30);
	%>
	<%=arr%>

</body>
</html>