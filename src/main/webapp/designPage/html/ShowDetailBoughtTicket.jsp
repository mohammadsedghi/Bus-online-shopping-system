<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %>
<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.util.VerifyTicket" %><%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 7/17/2023
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="stylesheet" href="../css/confirm.css">--%>
    <link rel="stylesheet" href="<%=request.getContextPath()+"/designPage/css/confirm.css"%>">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

    <title>نمایش جزئیات بلیط</title>
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
        <form method="post"  action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/cancel">
            <table class="table table-bordered border-primary border-3">
                <thead class="table-primary text-dark fw-bold">
                <tr>
                    <th scope="col">عنوان</th>
                    <th scope="col">توضیحات</th>

                </tr>
                </thead>

                <%
                    Ticket ticket =  (Ticket) request.getAttribute("ticket");
                    if (ticket==null){ %>
                <div class="alert alert-success t alert-position" role="alert">
                    بلیط مورد نظر یافت نشد و یا قبلا حذف شده است
                </div>
                <% }else {
                %>
                <tr>
                    <th scope="row">شناسه بلیط</th>
                    <td><%= ticket.getId() %></td>
                </tr>
                <th scope="row">نام و نام خانوادگی</th>
                <td ><%= ticket.getNameAndFamily() %></td>
                </tr>
                <th scope="row">جنسیت </th>
                <td><%= ticket.getGender() %></td>
                </tr>
                <th scope="row">مبدا</th>
                <td><%= ticket.getBeginning() %></td>
                </tr>
                <th scope="row">مقصد</th>
                <td><%= ticket.getDestination() %></td>
                </tr>
                <th scope="row">تاریخ حرکت</th>
                <td><%= ticket.getDepartureDate() %></td>
                </tr>
                <th scope="row">ساعت حرکت</th>
                <td><%= ticket.getDepartureTime() %></td>
                </tr>
                <th scope="row">شناسه سفر </th>
                <td><%= ticket.getTravelId() %></td>
                </tr>
                <td><button class="btn btn-info text-white fw-bold" type="submit" value="<%= ticket.getId()%>" name="cancel">لغو</button></td>
                <%--       <td><input type="submit" value="<%= ticket.getId()%> لغو " name="cancel"  onclick="submitToServlet()"></td>--%>
                <%--        <td><input  type="button"  value="مشاهده بلیط" onclick="goToAnotherPage()"></td>--%>
                </tr>
                <% } %>
            </table>
        </form>
        <%--<script>--%>
        <%--    function submitToServlet() {--%>
        <%--        document.getElementById("endForm").action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/cancel";--%>
        <%--        document.getElementById("endForm").submit();--%>
        <%--    }--%>
        <%--    function goToAnotherPage() {--%>
        <%--        window.location.href = "designPage/html/ShowBoughtTicket.jsp";--%>
        <%--    }--%>
        <%--</script>--%>
    </div>
</div>

</body>
</html>
