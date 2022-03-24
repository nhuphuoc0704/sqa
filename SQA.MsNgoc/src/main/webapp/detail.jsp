<%@page import="dao.BankPassbookDAO"%>
<%@page import="model.TransactionHistory"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Customer"%>
<%@page import="model.BankPassbook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BankAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
int index= Integer.parseInt(request.getParameter("passbook"));
BankAccount b= (BankAccount) session.getAttribute("bankaccount");
ArrayList<BankPassbook> list=(ArrayList<BankPassbook>) session.getAttribute("listpassbook");
Customer c= (Customer) session.getAttribute("customer");
BankPassbook passbook= list.get(index);

SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
Calendar calendar= Calendar.getInstance();
Date now= calendar.getTime();

//Tính lãi suất
int rate=(new BankPassbookDAO()).getRatePassbook(passbook);

 TransactionHistory trans= new TransactionHistory(sdf.format(now),"Tat toan so tiet kiem "+passbook.getAccountno(),passbook.getDeposits()+rate,b,passbook);
session.setAttribute("trans", trans);
%>
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
</head>
<body>
<%@include file="header.jsp" %>
<form action="/SQA.MsNgoc/CheckSettlement" method="post">
<div class="content">
	<h1>Thông tin chi tiết</h1>
	<table>
		<tr>
			<td>Sổ tiết kiệm</td>
			<td><%=passbook.getAccountno() %></td>
		</tr>
		<tr>
			<td>Chủ tài khoản</td>
			<td><%=c.getFullName() %></td>
		</tr>
		<tr>
			<td>Ngày gửi</td>
			<td><%=passbook.getStartdate() %></td>
		</tr>
		<tr>
			<td>Kì hạn</td>
			<td><%=passbook.getTenor().getValue() %></td>
		</tr>
		<tr>
			<td>Lãi suất</td>
			<td><%=passbook.getTenor().getInterestRate()%></td>
		</tr>
		<tr>
			<td>Số tiền gửi</td>
			<td><%=passbook.getDeposits()%></td>
		</tr>
		<tr>
			<td>Loại tiền gửi</td>
			<td><%=passbook.getCurrency()%></td>
		</tr>
		<tr>
			<td>Số tiền lãi</td>
			<td><%=rate %></td>
		</tr>
		<tr>
			<td>Tổng tất toán</td>
			<td><%=passbook.getDeposits()+rate %></td>
		</tr>
		<tr>
			<td>Tài khoản nhận</td>
			<td><%=b.getAccountno() %></td>
		</tr>
		<tr>
			<td>Xác nhận CCCD</td>
			<td><input type="text" name="cccd" placeholder="Xác nhận CCCD của bạn để xác thực"></td>
		</tr>
		<tr>
			<td>Xác nhận mật khẩu</td>
			<td><input type="password" name="confirmpassword" placeholder="Nhập mật khẩu để đồng ý"></td>
		</tr>
		<tr>
			<td><input type="button" value="Quay lại" onclick="history.back()"></td>
			<!-- <td><button name="back"  onclick="history.back()">Quay lại</button></td> -->
			<td><input type="submit" value="Xác nhận"></td>
		</tr>
	</table>
</div>
</form>
<%@include file="index.html" %>
</body>
</html>