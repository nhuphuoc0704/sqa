<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   
  <style type="text/css">
  #main{
    padding-bottom: 50px;
}

#header{
    position: fixed;
    width: 100%;
    left: 0;
    right: 0;
    top: 0;
    background-color:#000044;
    height: 46px;
    text-align: center;
   
}
.nav, #subnav{
    
    list-style-type: none;
    display: inline-block;
}
.nav > li{
    display: inline-block;
}
.nav li{
    position: relative;
}

.nav > li > a{
    color: #fff;
    text-transform: uppercase;
}
.nav li a{
    text-decoration: none;
    line-height: 46px;
    padding: 0 24px;
    display: block;
    
}
.nav-arrow-down{
    font-size: 14px;
}
.nav >li:hover >a,.nav #subnav li:hover a
{
    background-color: #ccc;
    color: #000;
    
}
.nav li:hover #subnav{
    display:block;
}
.nav #subnav {
    top:100%;
    left: 0;
    min-width: 160px;
    display: none;
    position: absolute;
    background-color: #fff;
    color: #000;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.35);
}
.nav #subnav a{
    color: #000;
    padding: 0 12px;
    margin-left: -40px;
    
    
}

  </style>
   
</head>
<body>
    <div id="main">
        <div id="header">
            <ul class="nav">
                <li><a href="home.jsp">Trang chủ</a></li>
                <li><a href="">Ưu đãi</a></li>
                <li><a href="">Tin tức</a></li>
                <li><a href="">Lịch sử giao dịch</a></li>
                <li><a href="">Tài khoản tiết kiệm 
                    <i class="nav-arrow-down ti-angle-down"></i>
                </a>
                <ul id="subnav">
                	<li><a href="">Thông tin</a></li>
                    <li><a href="settelement.jsp">Tất toán</a></li>
                </ul>
                </li>
                <li><a href="">Account</a></li>
               

            </ul>
           	
          	

        </div>
        </div>
    </body>
    </html>
