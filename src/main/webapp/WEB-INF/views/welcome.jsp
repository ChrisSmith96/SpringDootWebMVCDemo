<%@page import="java.time.LocalDateTime"%>
<%@page import="com.mthree.models.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Student s = (Student) request.getAttribute("student");
//adding a comment
LocalDateTime today = (LocalDateTime) request.getAttribute("today");
%>

Student details are : <%= s  %>
<%= today %>
</body>
</html>