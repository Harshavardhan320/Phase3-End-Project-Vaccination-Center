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
	<table border=1>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th><a href="add-new-center">Add New Center</a></th>
		</tr>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>City</th>
			<th>Action</th>
		</tr>
		<c:forEach var="data" items="${Data}">
			<tr>
				<td>${data.id}</td>
				<td>${data.name}</td>
				<td>${data.city}</td>
				<td>
					<a href="view-vaccination-center?id=${data.id}">View</a>&nbsp;&nbsp;
					<a href="edit-vaccination-center?id=${data.id}&name=${data.name}">Edit</a>&nbsp;&nbsp;
					<a href="delete-vaccination-center?id=${data.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>