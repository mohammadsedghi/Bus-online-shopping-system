<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %>
<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.VerifyTicket" %><%--
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
    <link rel="stylesheet" href="../css/confirm.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

    <title>نمایش جزئیات بلیط</title>
</head>
<body>
<form method="post" id="endform">
    <table class="table table-bordered border-primary">
        <thead>
        <tr>
            <th scope="col">عنوان</th>
            <th scope="col">توضیحات</th>

        </tr>
        </thead>

        <%
            Ticket ticket =  (Ticket) request.getAttribute("ticket");

//            request.setAttribute("ticket",ticket);
//            RequestDispatcher rd =request.getRequestDispatcher("/cancel");
//            rd.forward(request,response);
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
<%--       <td><button type="submit" value="<%= ticket.getId()%>" name="cancel">لغو</button></td>--%>
       <td><button type="submit" value="<%= ticket.getId()%>" name="cancel"  onclick="submitToServlet()">لغو</button></td>
        <td><button  type="button"  onclick="goToAnotherPage()">مشاهده بلیط</button></td>
        </tr>
    </table>
</form>
<script>
    function submitToServlet() {
        document.getElementById("endForm").action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/cancel";
        document.getElementById("endForm").submit();
    }
    function goToAnotherPage() {
        window.location.href = "designPage/html/ShowBoughtTicket.jsp";
    }
</script>
</body>
</html>
