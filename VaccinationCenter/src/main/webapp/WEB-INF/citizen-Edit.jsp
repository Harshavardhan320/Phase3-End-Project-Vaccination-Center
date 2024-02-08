<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>citizen-Edit</title>
</head>
<body>
	<%@ include file="header.jsp" %><br>
	<%
		String Username = request.getParameter("name");
		String City = request.getParameter("city");
		int id = Integer.parseInt(request.getParameter("id"));
		int doses = Integer.parseInt(request.getParameter("doses"));
	%>
	<div style="border:1px solid black;text-align:center">
		<h2>Edit Citizen</h2>
		<form action="editcitizen" method="get">
			<input type="hidden" name="id" value="<%out.print(id);%>">
			<div>
				<label for="username">Username</label>
				<input type="text" name="name" placeholder="username" value="<%out.print(Username);%>">
			</div><br><br>
			<div>
				<label for="city">City :</label>
				<select name="city">
					<option value="<%out.print(City);%>"><%out.print(City);%></option>
					<option value="Andhra Pradesh">Amaravati</option>
			        <option value="Arunachal Pradesh">Itanagar</option>
			        <option value="Assam">Dispur</option>
			        <option value="Bihar">Patna</option>
			        <option value="Chhattisgarh">Raipur</option>
			        <option value="Goa">Panaji</option>
			        <option value="Gujarat">Gandhinagar</option>
			        <option value="Haryana">Chandigarh</option>
			        <option value="Himachal Pradesh">Shimla</option>
			        <option value="Jharkhand">Ranchi</option>
			        <option value="Karnataka">Bengaluru</option>
			        <option value="Kerala">Thiruvananthapuram</option>
			        <option value="Madhya Pradesh">Bhopal</option>
			        <option value="Maharashtra">Mumbai</option>
			        <option value="Manipur">Imphal</option>
			        <option value="Meghalaya">Shillong</option>
			        <option value="Mizoram">Aizawl</option>
			        <option value="Nagaland">Kohima</option>
			        <option value="Odisha">Bhubaneswar</option>
			        <option value="Punjab">Chandigarh</option>
			        <option value="Rajasthan">Jaipur</option>
			        <option value="Sikkim">Gangtok</option>
			        <option value="Tamil Nadu">Chennai</option>
			        <option value="Telangana">Hyderabad</option>
			        <option value="Tripura">Agartala</option>
			        <option value="Uttar Pradesh">Lucknow</option>
			        <option value="Uttarakhand">Dehradun</option>
			        <option value="West Bengal">Kolkata</option>
			        <option value="Jammu and Kashmir">Srinagar (summer), Jammu (winter)</option>
			        <option value="Ladakh">Leh</option>
				</select>
			</div><br><br>
			<div>
				<label for="doses">doses</label>
				<select name="doses">
					<option value="<%out.print(doses);%>"><%out.print(doses);%></option>
					<%
						if(doses ==0){
							%>
							<option value="1">1</option>
							<option value="2">2</option>
							<%
						}else if(doses ==1){
							%>
							<option value="0">0</option>
							<option value="2">2</option>
							<% 
						}else if(doses ==2){
							
							%>
							<option value="0">0</option>
							<option value="1">1</option>
							<%
						}
					%>
				</select>
			</div><br><br>
			<div>
				<label for=" vaccination_center_id">Vaccination center</label>
				<select name="vaccination_center_id">
					<option value="0">None</option>
					<c:forEach var="data" items="${vacceinationcenterdata}">
						<option value="${data.getId()}">${data.getName()}</option>
					</c:forEach>
				</select>
			</div><br><br>
			<button>Add Citizen</button><br><br>
		</form>
		${message}
	</div>
</body>
</html>