<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>login</title>
		<script type="text/javascript">
function validate()
{
	var unsername=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	
	if(username == "")
	{
		alert("username is empty");
		return false;
	}
	if(usename.length < 3)
	{
		alert("username is too small");
		return false;
	}
	if(password == "")
	{
		alert("password is empty");
		return false;
	}
	return true;
}


</script>
	</head>
	<body>
		<h2>login page</h2>
		 
		
		 <form:form action="signIn.html" method="GET" modelAttribute="userBean" >
	   		<table>
			   
			    <tr>
			        <td><form:label path="username">username</form:label></td>
			         <td><form:input  path="username" value=""/></td>
			    </tr>
			    <tr>
			        <td><form:label path="password">password</form:label></td>
			        <td><form:input path="password" value=""/></td>
			    </tr>
			   
			    <tr>
			      <td ><input type="submit" value="signIn"/></td>
			      <td><a href="registerationform.html">RegisterNow</a></td>
		      </tr>
			</table> 
		</form:form>	  
	</body>
</html>