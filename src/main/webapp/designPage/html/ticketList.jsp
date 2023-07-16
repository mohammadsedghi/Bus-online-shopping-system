<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %>
<%@ page import="java.util.*" %>
<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.VerifyTicket" %><%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 7/12/2023
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="../css/searchTrip.css">
<head>
  <style>
   body,html{
      /*direction: rtl;*/
    }
  </style>
    <title>نتایج جست و جو</title>
</head>
<body>
<form method="post" action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/buy">
<table class="table table-bordered border-primary">
  <thead>
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
      <td><%= ticket.getBeginning()+"-"+ticket.getDestination() %></td>
      <td ><%= ticket.getDepartureDate() %></td>
      <td><%= ticket.getDepartureTime() %></td>
      <td><%= ticket.getTravelId() %></td>
      <td><button type="submit" value="<%= counter%>" name="se">خرید</button></td>
    </tr>
      <%
      counter++;
  }
%>
</table>
</form>
</body>
</html>
