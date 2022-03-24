<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stt.css">
<script src="https://kit.fontawesome.com/b0a4ac4a58.js" crossorigin="anonymous"></script>
<style type="text/css">

</style>
<%
Customer c= (Customer)session.getAttribute("customer");
%>
</head>
<body>
<%@include file="header.jsp" %>
<hr>

<h1>Welcome back <%=c.getFullName() %></h1>

<hr>
<%@include file="index.html" %>
</body>
</html>