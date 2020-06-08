<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "com.example.business.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%
	
	
		User userProfile;
		userProfile = (User)request.getSession().getAttribute("users");
		
		String id = Integer.toString(userProfile.getId());
		String firstName = userProfile.getFirstName();
		String lastName = userProfile.getLastName();
		
		String username = userProfile.getUsername();
		String password = userProfile.getPassword();
		
		%>
		
		<b> View Profile for <%= username %> </b>
		
				<li>ID         : <%= id %><li>
				<li>First Name : <%= firstName %><li>
				<li>Last Name  : <%= lastName %><li>
				<li>Password   : <%= password %><li>
	
	


		
</body>

</html>