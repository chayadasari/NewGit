<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>user info</h2>
		<form:form method="POST" action="/RegistrationApp/CreateAccount.html">
	   		<table>
	   		
	   		<tr>
			        <td><form:label path="firstName">firstName</form:label></td>
			         <td><form:input path="firstName" value=""/></td>
			     
			    </tr>
			    
			    <tr>
			        <td><form:label path="lastName">lastName</form:label></td>
			        <td><form:input path="lastName" value=""/></td>
			     
			       
			    </tr>
			    <tr>
			        <td><form:label path="email_id">email_id</form:label></td>
			       <td><form:input path="email_id" value=""/></td>
			     
			    </tr>
			    <tr>
			        <td><form:label path="mobile_no">mobile_no</form:label></td>
			       <td><form:input path="mobile_no" value=""/></td>
			     
			    </tr>
			   
			    <tr>
			        <td><form:label path="username">username</form:label></td>
			        <td><form:input path="username" value=""/></td>
			     
			    </tr>
			    <tr>
			        <td><form:label path="password">password</form:label></td>
			        <td><form:input path="password" value=""/></td>
			     
			    </tr>
			   
			    <tr>
			      <td colspan="2"><input type="submit" value="CreateAccount"/></td>
			      
		      </tr>
			</table> 
		</form:form>	
	</body>
</html>