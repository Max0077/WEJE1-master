<%@page import="com.jspiders.springmvc.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp"></jsp:include>
<%
StudentDTO student = (StudentDTO) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%
	if (student != null) {
	%>
	<h3>
		Welcome
		<%=student.getName()%></h3>
	<%
	}
	%>

</body>
</html>