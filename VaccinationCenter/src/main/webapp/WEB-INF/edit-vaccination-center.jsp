<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Vaccination Center</title>
</head>
<body>
	<%@ include file="header.jsp" %><br>
	<div style="text-align:center;border:1px solid black">
		<center><h2>Login Page</h2></center>
		<form action="editnewcenter" method="post">
			<div id="lable">
				<label for="Center name">Center name :</label>
				<input type="text" name="name" placeholder="Center name" autofocus="autofocus" value="<%out.print(request.getParameter("name"));%>">
				<input type="hidden" name="id" value="<%out.print(request.getParameter("id"));%>">
			</div><br><br>
			<div id="lable">
				<label for="city">City :</label>
					<select name="city">
						<option value="null">None</option>
				    	<option value="Adilabad">Adilabad</option>
				    	<option value="Bhadradri Kothagudem">Bhadradri Kothagudem</option>
					    <option value="Hyderabad">Hyderabad</option>
					    <option value="Jagtial">Jagtial</option>
					    <option value="Jangaon">Jangaon</option>
					    <option value="Jayashankar Bhupalapally">Jayashankar Bhupalapally</option>
					    <option value="Jogulamba Gadwal">Jogulamba Gadwal</option>
					    <option value="Kamareddy">Kamareddy</option>
					    <option value="Karimnagar">Karimnagar</option>
					    <option value="Khammam">Khammam</option>
					    <option value="Komaram Bheem">Komaram Bheem</option>
					    <option value="Mahabubabad">Mahabubabad</option>
					    <option value="Mahbubnagar">Mahbubnagar</option>
					    <option value="Mahbubnagar">Mahbubnagar</option>
					    <option value="Mancherial">Mancherial</option>
					    <option value="Medak">Medak</option>
					    <option value="Medchal–Malkajgiri">Medchal–Malkajgiri</option>
					    <option value="Nagarkurnool">Nagarkurnool</option>
					    <option value="Nalgonda">Nalgonda</option>
					    <option value="Nirmal">Nirmal</option>
					    <option value="Nizamabad">Nizamabad</option>
					    <option value="Peddapalli">Peddapalli</option>
					    <option value="Rajanna Sircilla">Rajanna Sircilla</option>
					    <option value="Ranga Reddy">Ranga Reddy</option>
					    <option value="Sangareddy">Sangareddy</option>
					    <option value="Siddipet">Siddipet</option>
					    <option value="Suryapet">Suryapet</option>
					    <option value="Vikarabad">Vikarabad</option>
					    <option value="Wanaparthy">Wanaparthy</option>
					    <option value="Warangal Rural">Warangal Rural</option>
					    <option value="Warangal Urban">Warangal Urban</option>
					    <option value="Yadadri Bhuvanagiri">Yadadri Bhuvanagiri</option>
					</select>
			</div><br><br>
			<div id="lable">
				<button>Click To Change Center</button>
			</div><br>
		</form>
		<p style="color:green">${message}</p>
	</div>
</body>
</html>