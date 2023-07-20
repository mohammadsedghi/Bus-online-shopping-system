<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %>
<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.util.VerifyTicket" %><%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 7/17/2023
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="<%=request.getContextPath()+"/designPage/css/confirm.css"%>">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>نمایش بلیط </title>
</head>
<body>
<div>
  <nav class="navbar navbar-expand-lg nav-c ">
    <div class="container-fluid">
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active text-dark fw-bold" aria-current="page" href="index.jsp">صفحه اصلی</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark fw-bold" href="searchTrip.html">خرید بلیط</a>
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
</div>

<form method="post" action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/ShowDetailBoughtTicket">
  <table class="table table-bordered border-primary border-2 table-striped">
    <thead class="table-primary text-dark fw-bold">
    <tr>
      <th scope="col">ردیف</th>
      <th scope="col">تاریخ</th>
      <th scope="col">شناسه سفر </th>
      <th scope="col">انتخاب</th>
    </tr>
    </thead>

    <%
      int counter=1;
       VerifyTicket verifyTicket=new VerifyTicket();
      List<Ticket> tickets =verifyTicket.initializerBoughtTicket();
      if (tickets.size()==0){ %>
    <div class="alert alert-danger t alert-position" style="text-align: right" role="alert">
      بلیط مورد نظر یافت نشد و یا قبلا حذف شده است
    </div>
    <% }
      System.out.println("sssss"+tickets);
      for (Ticket ticket : tickets) {

    %>
    <tr>
      <th scope="row"><%= counter%></th>
      <td><%= ticket.getDepartureDate() %></td>
      <td><%= ticket.getTravelId() %></td>
      <td><button class="btn btn-info text-white fw-bold" type="submit" value="<%= ticket.getId()%>" name="show">مشاهده بلیط</button></td>
    </tr>
    <%
        counter++;
      }
    %>
  </table>
</form>

</body>
</html>
