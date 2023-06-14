<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Tai Khoan</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,600;1,200;1,400;1,500&display=swap');
*{
    padding:0;
    margin:0;
    box-sizing: border-box;
    font-family:'Poppins', sans-serif;
    cursor: pointer;
}

#wrapper {
    /* Kích thước màn hình là 1280 x 720 */
    width: 100%;
    height: 100vh;
}
#header {
    width: 100%;
    padding:0px 30px;
    margin-top:33px;
    display: flex;
    justify-content: space-between;
    align-items: center;    
}

#menu {
    list-style:none;
    display: flex;
}

#menu .item {
    margin:0px 25px;
}

#menu .item a {
    color:#626A67;
    text-decoration: none;
}


#actions {
    display: flex;
}

#actions .item {
    margin-left:22px;
}





#banner {
    width: 100%;
    background-image :url("/assets/banerr.png");
    height: 463px;
    margin-top:40px;
    display: flex;
    padding:0px 133px;
    position:relative;
}

#banner .box-left ,#banner .box-right {
    width: 50%;
}

#banner  .box-left h2 {
    font-size:48px;
    margin-top:75px;
    color:#fff;
}

#banner .box-left p {
    color:#D0D0D0;
}

#banner .box-left button {
    width: 191px;
    height: 40px;
    margin-top:41px;
    background:#1d1a1a;
    border:none;
    outline:none;
    color:#fff;
    font-weight: bold;
    border-radius: 20px;
    transition:0.4s;
}

#banner .box-left button:hover {
    background:orange;
}

#banner .box-right {
    padding-left:200px;
    display: flex;
    justify-content: center;
    align-items: center;
}

#banner .box-right img {
    margin:0px 10px;
    animation :animation 3s infinite linear; 
}


#banner .box-right img:nth-child(1)
{
    animation-delay: 0.5s;
}
#banner .box-right img:nth-child(2)
{
    
    animation-delay: 1s;
}

@keyframes animation {
    0%{
        transform:translateY(0px);
    }
    50%{
        transform: translateY(-10px);
    }
    100%{
        transform: translateY(0px);
    }
    
}

.to-bottom {
    position:absolute;
    bottom:-40px;
    left:50%;
    transform:translateX(-50%);
}



#wp-products {
    padding-top:116px;
    padding-bottom: 78px;
    padding-left:134px;
    padding-right:134px;
}

#wp-products h2 {
    text-align: center;
    margin-bottom: 76px;
    font-size:32px;
    color:#626a67;
}


#list-products {
    display: flex;
    list-style: none;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
}

#list-products .item {
    width: 290px;
    height: 374px;
    background:#362f2f;
    border-radius: 10px;
    margin-bottom: 50px;
}

#list-products .item img {
    display: block;
    margin:0px auto;
    margin-top:17px;
}

#list-products .item .stars {

    display: flex;
    margin:0px auto;
    width: 50%;
}

#list-products .item .name {
    text-align: center;
    color:#fff;
    font-weight: bold;
    margin-top:21px;
}

#list-products .item .desc {
    text-align: center;
    color:#626a67;
}

#list-products .item .price {
    text-align: center;
    color:#f42424;
    font-weight: bold;
    margin-top:20px;
}


.list-page {
    width: 50%;
    margin:0px auto;
}

.list-page {
    display: flex;
    list-style: none;
    justify-content: center;
    align-items: center;
}

.list-page .item {
    margin:0px 15px;
    width: 37px;
    height: 37px;
    background:#362f2f;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
}
.list-page .item a {
    color:#fff;
    text-decoration: none;
}


#saleoff {
    width: 100%;
    display: flex;
    height: 322px;
}
#saleoff .box-left ,#saleoff .box-right {
    width: 50%;
}
#saleoff .box-left {
    background:#3e413e;
    text-align: center;
    min-height: 322px;
}

#saleoff .box-left h1 {
    padding-top:38px;
}
#saleoff .box-left span:nth-child(1)
{
    color:#fff;
    font-size:50px;
}

#saleoff .box-left span:nth-child(2)
{
    color:orange;
    font-size:128px;
}

#saleoff .box-right {
    background-image:url("/assets/off.png");
}


#comment {
    width: 1012px;
    height: 478px;
    margin:0px auto;
    margin-top:184px;
    margin-bottom: 50px;
}

#comment h2 {
    text-align: center;
    margin-bottom: 50px;
    font-size:32px;
    color:#626a67;
}


#comment-body{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 1000px;
    height: 400px;
    list-style: none;
    overflow: hidden;
}

#list-comment {
    width: 100%;
    height: 100%;
    list-style: none;
    transition:0.5s;
}

#list-comment .item {
    width: 100%;
    height: 100%;
    background:#362f2f;
    border-radius: 20px;
    padding-top:50px;
}

#list-comment .item .avatar {
    text-align: center;
    margin-top:13px;
}

#list-comment .item .stars {
    display: flex;
    margin:0px auto;
    width: 50%;
    margin-top:32px;
    justify-content: center;
    align-items: center;
}

#list-comment .item .name {
    text-align: center;
    font-weight: bold;
    color:#fff;
}

#list-comment .item .text {
    padding:20px 50px;
    color:#fff;
   
}

#footer {
    width: 100%;
    background:rgb(0,0,0,0.79);
    height: 322px;
    margin-top:338px;
    padding:0px 63px;
    padding-top:57px;
    display: flex;
    justify-content: space-around;
}

#footer .box {
    width: 250px;
    color:#fff;
}

#footer .box .quick-menu {
    margin-top:40px;

}


#footer .box .quick-menu .item{
    margin-bottom:12px;

}
#footer .box .quick-menu ,.item a{
    color:#fff;
    text-decoration: none;
}



#footer .box form input {
    width: 294px;
    height: 42px;
    background:transparent;
    padding-left:20px;
    color:#fff;
    margin-top:30px;
}

#footer .box form button {
    background:#362f2f;
    box-shadow: 5px 5px 4px rgba(0,0,0.25);
    width: 163px;
    height: 38px;
    margin-top:29px;
    color:#fff;
}
 </style>
 <style>
	table{
	width: 100%;
	border-collapse: collapse;
	}
	th,td{
		border: 1px solid rgba(0,0,0,0,6);
		padding: 10px;
	}
	
</style>
</head>
<body>
<div id="wrapper">
        <div id="header">
            <a href="" class="logo">
                <img src="/assets/logo.png" alt="">
            </a>
            <div id="menu">
                <div class="item">
                    <a href="/product/home">Trang chủ</a>
                </div>
                <div class="item">
                    <a href="/product/home" > Sản phẩm</a>
                </div>
                <div class="item">
                    <a href="/home" >Admin</a>
                </div>
                <div class="item">
                    <a href="/login">Log out</a>
                </div>
            </div>
            
            <div id="actions">
                <div class="item">
                    <img src="/assets/user.png" alt="">
                </div>
                <div class="item">
                    <img src="/assets/cart.png" alt="">
                </div>
            </div>
        </div>
        
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 300px; margin: 0px">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="50"><use xlink:href="#bootstrap"></use></svg>
      
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="/home" class="nav-link active" aria-current="page">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
          Home
        </a>
      </li>
      <li>
        <a href="/product/list" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
          Sản Phẩm
        </a>
      </li>
      <li>
        <a href="/taikhoan" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg>
          Tài Khoản
        </a>
      </li>
      <li>
        <a href="#" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"></use></svg>
          Hóa Đơn
        </a>
      </li>
      <li>
        <a href="#" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
          Thoát
        </a>
      </li>
    </ul>
    <hr>
   
  </div>
  
  <div class="container" >
	<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Ảnh	</th>
        <th>Tên</th>
        <th>Tài khoản</th>
        <th>Email</th>
        <th>Admin</th>
        <th>ACT</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${lists}">
    <a href="">
        <tr>
            <td>${user.id}</td>
            <td class="img" > <img src="${user.photo}" width="200px"> </td>
            <td>${user.fullName}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.admin}</td>
            <td>
                <a href="deletee/${user.id}"><button>Delete</button></a>
                 <a href="/detailtk/${user.id}"><button>Detail</button></a>
            </td>
        </tr>
        </a>
    </c:forEach>
    </tbody>
</table>
<div>
			<ul class="pagination"> 	
				<c:forEach begin="1" end="${totalPage}" varStatus="status">
					<li class="page-item"><a
						href="${pageContext.request.contextPath}/product/taikhoan?PageNum=${status.index}"
						class="page-link">${status.index}</a></li>
				</c:forEach>
			</ul>
		</div>
		
	</div>
  
  
  
  <footer>
        <div id="footer">
            <div class="box">
                <div class="logo">
                    <img src="/assets/logo.png" alt="">
                </div>
                <p>Cung cấp sản phẩm với chất lượng an toàn cho quý khách</p>
            </div>
            <div class="box">
                <h3>NỘI DUNG</h3>
                <ul class="quick-menu">
                    <div class="item">
                        <a href="">Trang chủ</a>
                    </div>
                    <div class="item">
                        <a href="">Sản phẩm</a>
                    </div>
                    <div class="item">
                        <a href="">Blog</a>
                    </div>
                    <div class="item">
                        <a href="">Liên hệ</a>
                    </div>
                </ul>
            </div>
            <div class="box">
                <h3>LIÊN HỆ</h3>
                <form action="">
                    <input type="text" placeholder="Địa chỉ email">
                    <button>Nhận tin</button>
                </form>
            </div>
        </div>
    </div>
    </footer>
    

</body>
</html>