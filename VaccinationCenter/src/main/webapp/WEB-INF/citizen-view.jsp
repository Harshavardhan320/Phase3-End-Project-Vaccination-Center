<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Citizens</title>
</head>
<body>
	<%@include file="header.jsp" %><br>
		<div style="border:2px solid black;width:60vh;padding: 30px; margin:20px">
			<%
				String Username = request.getParameter("name");
				String City = request.getParameter("city");
				int id = Integer.parseInt(request.getParameter("id"));
				int doses = Integer.parseInt(request.getParameter("doses"));
				
			%>
			<h1>
				<%out.print(Username);%>
			</h1><hr><br>
			<p><b>ID: </b><%out.print(id); %></p>
			<p><b>City: </b><%out.print(City); %></p>
			<p><b>Number Of Doses: </b><%out.print(doses); %></p>
			<p><b>Vaccination Status: </b><% if(doses==2){
				     out.print("Fully Vaccinated");
				}else{
					out.print("Not Vaccinated");
				}%></p>
		</div>

</body>
</html>