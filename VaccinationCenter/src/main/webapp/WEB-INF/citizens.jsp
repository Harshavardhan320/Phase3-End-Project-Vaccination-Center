<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Citizens</title>
</head>
<body>
	<%@ include file="header.jsp" %><br>
	<table border=1 style="text-align:center">
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th><a href="Add-citizens">Add Citizens</a></th>
		</tr>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CITY</th>
			<th>NO.OF.DOSES</th>
			<th>VACCINATION STATUS</th>
			<th>VACCINATION CENTER</th>
			<th>ACTION</th>
		</tr>
		<c:forEach var="data" items="${Data}">
			<tr>
				<td>${data.id}</td>
				<td>${data.name}</td>
				<td>${data.city}</td>
				<td>${data.doses}</td>
				<c:choose>
					<c:when test="${data.doses==2}">
						<td>Fully Vaccinated</td>
					</c:when>
					<c:otherwise>
						<td>Not Vaccinated</td>
					</c:otherwise>
				</c:choose>
				<td>${data.getVaccinationCenter_Id().getName()}</td>
				<th>
					<a href="citizen-view?id=${data.id}&name=${data.name}&city=${data.city}&doses=${data.doses}">View</a>&nbsp;&nbsp;
					<a href="citizen-Edit?id=${data.id}&name=${data.name}&city=${data.city}&doses=${data.doses}">Edit</a>&nbsp;&nbsp;
					<a href="citizen-delete?id=${data.id}">Delete</a>
				</th>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>