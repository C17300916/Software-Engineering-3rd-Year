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

		<form action="FrontController" method="post">
                <table>
                    <tr>
                        <td> Movie Name  : </td><td> <input name="moviename" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Movie Rating  : </td><td> <input name="rating" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Review Content  : </td><td> <input name="content" size=100 type="text" /> </td> 
                    </tr>
                </table>
                <input type="hidden" name="action" value="AddReview" />
                <input type="submit" value="Add Review" />
            </form>

</body>

</html>