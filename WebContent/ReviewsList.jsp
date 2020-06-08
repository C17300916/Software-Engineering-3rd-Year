<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "com.example.business.Reviews" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<style>
li {
    display:block;
    float:center;
}
</style>
	<%
	
	
		List<Reviews> reviews;
		reviews = (List)(request.getSession().getAttribute("reviews"));
		
		String name = "";
		float rating;
		String content = "";
		
		%>
		
		<b> <h1>Reviews</h1> </b>
		<hr>
		<br>
		
		<%		
		if (reviews != null) {
			
			for ( Reviews review : reviews){
				
				%>
				
				<li><h3><b><%= name.concat(review.getMovieName())%></b></h3><li>
				<li><%= content.concat(review.getReviewContent())%><li>
				<li><b>Rating: </b><%= rating = review.getRating()  %><li>
				<hr>
				<% 
			}
		}
	
	%>


		
</body>

</html>