<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Index</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<h2>Welcome Admin: <%
	
		out.print(session.getAttribute("username"));
	%></h2>
	
</body>
</html>