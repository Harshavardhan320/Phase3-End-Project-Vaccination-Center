<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%><br>
	<h1>Center Information</h1>
	<div style="border:2px solid black;width:60vh;padding: 10px;text-aalign:center; margin:40px">
		<c:forEach var="data1" items="${data}" begin="0" end="0">
			<div>
				<h2>${data1.getVaccinationCenter_Id().getName()}</h2>
			</div><hr>
			<div>
				<h3><b>ID :  |</b>${data1.getVaccinationCenter_Id().getId()}</h3>
				<h3><b>City: |</b>${data1.getVaccinationCenter_Id().getCity()}</h3>
			</div>
		</c:forEach>
	</div>
	<hr><br>
	<h2>All Citizens Of The Center</h2>
	<table border=1 style="text-align:center; margin:40px">
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>ACTION</td>
		</tr>
		<c:forEach var="data" items="${data}">
			<tr>
				<td>${data.id}</td>	
				<td>${data.name}</td>
				<td><a href="citizen-view?id=${data.id}&name=${data.name}&city=${data.city}&doses=${data.doses}">View</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>