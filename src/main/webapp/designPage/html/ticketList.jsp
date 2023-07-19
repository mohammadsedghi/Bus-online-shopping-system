<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %>
<%@ page import="java.util.*" %>
<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.util.VerifyTicket" %>
<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 7/12/2023
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=request.getContextPath()+"/designPage/css/searchTrip.css"%>">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%--<link rel="stylesheet" href="../css/searchTrip.css">--%>
<head>
  <style>
   body,html{
      /*direction: rtl;*/
    }
  </style>
    <title>نتایج جست و جو</title>
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
    <form method="post" action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/buy">
      <table class="table table-bordered border-primary border-2">
        <thead class="table-primary text-dark fw-bold">
        <tr>
          <th scope="col">ردیف</th>
          <th scope="col">مسیر</th>
          <th scope="col">تاریخ حرکت</th>
          <th scope="col">ساعت حرکت</th>ِِ
          <th scope="col">شناسه سفر</th>ِِ
          <th scope="col">انتخاب</th>
        </tr>
        </thead>

        <%
          int counter=1;
          List<Ticket> tickets = new ArrayList<>((ArrayList) request.getAttribute("ticketList"));
          for (Ticket ticket : tickets) {
        %>
        <tr>
          <th scope="row"><%= counter%></th>
          <td><%= ticket.getBeginning()+"-"+ ticket.getDestination() %></td>
          <td ><%= ticket.getDepartureDate() %></td>
          <td><%= ticket.getDepartureTime() %></td>
          <td><%= ticket.getTravelId() %></td>
          <td><button class="btn btn-info text-white fw-bold" type="submit" value="<%= counter%>" name="se">خرید</button></td>
        </tr>
        <%
            counter++;
          }
        %>
      </table>
    </form>
  </div>
</div>

</body>
</html>
