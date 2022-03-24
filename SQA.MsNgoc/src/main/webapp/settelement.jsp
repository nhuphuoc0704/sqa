<%@page import="model.BankAccount"%>
<%@page import="model.Customer"%>
<%@page import="dao.BankPassbookDAO"%>
<%@page import="model.BankPassbook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.content{
  
    top:0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
    height:500px;
    width:70%;
    min-height: 400pxpx;
    min-width: 400px;
    background-color: #ccc;
    border: solid 2px;
    padding: 20px;
}
</style>
<%
	Customer c= (Customer)session.getAttribute("customer");
	ArrayList<BankPassbook> listpassbook=(new BankPassbookDAO()).getListBankPassbook(c);
	BankAccount b= new BankPassbookDAO().getBankAccount(c);
	session.setAttribute("bankaccount", b);
	session.setAttribute("listpassbook", listpassbook);
%>
</head>
<body>
	<%@include file="header.jsp" %>
	<form action="detail.jsp" method="get">
	<div class="content">
		<h2>Settlement</h2>
		<table>
			<tr>
			<td>Chọn sổ tiết kiệm</td>
			<td><select name="passbook" size="1">
				<option value="-1" selected>>----Chọn sổ tất toán----< </option>
				<% for(int i=0;i<listpassbook.size();i++){ %>
					<option value="<%=i%>"><%=listpassbook.get(i).getAccountno() %></option>
				<%} %>
			</select ></td>
			</tr>
			<tr>
			<td></td>
			<td></td>
			</tr>
			<tr>
			<td>Chọn tài khoản nhận</td>
			<td>
				<select name="destination" size="1">
				<option value="-1" selected>>----Chọn tài khoản đích----<</option>
				<option value="1"><%=b.getAccountno() %></option>
			
				</select>
			</td>
			</tr>
			<tr>
			<td><input type=submit value="Next"></td>
			</tr>
		
		</table>
	</div>
	</form>
	<%@include file="index.html" %>
</body>
</html>