<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<style>
	a{
		color:blue;
	}
</style>
<%
if(session.getAttribute("username")==null ){
	response.sendRedirect("index");
}
%>
<a href="adminindex">Home</a>&nbsp;&nbsp;&nbsp;
<a href="citizens">Citizens</a>&nbsp;&nbsp;&nbsp;
<a href="vaccinationCenter">Vaccination Center</a>&nbsp;&nbsp;&nbsp;
<a href="logout">Logout</a>&nbsp;&nbsp;&nbsp;
<a>Welcome,admin <% out.println(session.getAttribute("username")); %></a><br><br>