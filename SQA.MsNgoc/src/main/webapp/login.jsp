<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/SQA.MsNgoc/CheckLogin" method="post">
		<div>Username <input type="text" placeholder="Tên đăng nhập" name="username"></div>
		<div>Password <input type="password" placeholder="Mật khẩu" name="password"></div>
		<input type="submit" value="Login">
	</form>
	<% if(session.getAttribute("error login")!=null) {%>
		<div><p><%=session.getAttribute("error login") %></p></div>
	<%} %>
</body>
</html>