<%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 7/19/2023
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--<link href="/cssFile/bootstrap.min.css" type="text/css" rel="stylesheet">-->
   <%--  <link rel="stylesheet"  href="../css/home.css">--%>
  <link rel="stylesheet"  href="<%=request.getContextPath()+"/designPage/css/home.css"%>">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<%--  <link href="<%=request.getContextPath()+"/designPage/css/cssFile/bootstrap.min.css" %>" type="text/css" rel="stylesheet">--%>
  <style>
    body{
      background-image: url('<%=request.getContextPath()+"/designPage/images/home.jpg"%>');
      background-size: cover;
      background-repeat: no-repeat;
    }
  </style>
    <title>لغو بلیط</title>
</head>
<body>
<div>
  <nav class="navbar navbar-expand-lg nav-c ">
    <div class="container-fluid">
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active text-dark fw-bold" aria-current="page" href="<%=request.getContextPath()+"/designPage/html/index.jsp"%>">صفحه اصلی</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active text-dark fw-bold" aria-current="page" href="<%=request.getContextPath()+"/designPage/html/signup.htm"%>l">ثبت نام</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark fw-bold" href="<%=request.getContextPath()+"/designPage/html/searchTrip.html"%>">خرید بلیط</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark fw-bold" href="<%=request.getContextPath()+"/designPage/html/ShowBoughtTicket.jsp"%>">(لیست بلیط های خریداری شده) </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle text-dark fw-bold" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="true">
              تماس با ما
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><a class="dropdown-item" href="#">بیمه مسافرتی</a></li>
              <li><hr class="dropdown-divider">پشتیبانی سایت</li>
              <li><a class="dropdown-item" href="#">ثبت نظرات ، انتقادات  </a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="search" type="submit">جست و جو</button>
        </form>
      </div>
    </div>
  </nav>
  <div>
    <div class="alert alert-danger t alert-position" style="text-align: right" role="alert">
      بلیط شما با موفقیت لغو گردید
    </div>
  </div>
</div>

</body>
</html>
