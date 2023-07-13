<%@ page import="ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket" %>
<%@ page import="java.util.*" %><%--
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
      <td><%= ticket.getDepartureDate() %></td>
      <td><%= ticket.getDepartureTime() %></td>
      <td><%= ticket.getTravelId() %></td>
      <td><form  action = "http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/designPage/html/buyTicket.jsp">
           <input type="submit" value="خرید">
          </form>
      </td>
    </tr>
      <%
      counter++;
  }
%>

</table>
<%--<table >--%>

<%--  <c:forEach items="${ticketList}" var="t">--%>
<%--    <tr>--%>
<%--      <td><c:out value="${t.beginning}" /></td>--%>
<%--&lt;%&ndash;      <td>${t.getBeginning}</td>&ndash;%&gt;--%>
<%--    </tr>--%>
<%--  </c:forEach>--%>
<%--</table>--%>
<%--<table class="table">--%>
<%--  <thead>--%>
<%--  <tr>--%>
<%--    <th scope="col">ردیف</th>--%>
<%--    <th scope="col">مسیر</th>--%>
<%--    <th scope="col">Last</th>--%>
<%--    <th scope="col">تاریخ حرکت</th>--%>
<%--  </tr>--%>
<%--  </thead>--%>
<%--  <tbody>--%>
<%--  <table>--%>
<%--&lt;%&ndash;  &lt;%&ndash;%>--%>
<%--&lt;%&ndash;    for (Ticket t:(List<Ticket>)request.getAttribute("ticketList")&ndash;%&gt;--%>
<%--&lt;%&ndash;    ) {&ndash;%&gt;--%>
<%--&lt;%&ndash;      if (t.getBeginning().equals(request.getAttribute("beginning"))&&t.getDestination().equals(request.getAttribute("destination"))){&ndash;%&gt;--%>
<%--&lt;%&ndash;        System.out.println("true");&ndash;%&gt;--%>

<%--&lt;%&ndash;      }&ndash;%&gt;--%>
<%--&lt;%&ndash;  } %>&ndash;%&gt;--%>
<%--  <tr>--%>
<%--    <th scope="row">1</th>--%>
<%--    <td>aaa</td>--%>
<%--    <td>aaa</td>--%>
<%--    <td>@mdo</td>--%>
<%--  </tr>--%>
<%--  <tr>--%>
<%--    <th scope="row">2</th>--%>
<%--    <td>Jacob</td>--%>
<%--    <td>Thornton</td>--%>
<%--    <td>@fat</td>--%>
<%--  </tr>--%>
<%--  <tr>--%>
<%--    <th scope="row">3</th>--%>
<%--    <td colspan="2">Larry the Bird</td>--%>
<%--    <td>@twitter</td>--%>
<%--  </tr>--%>
<%--  </tbody>--%>
<%--</table>--%>
</body>
</html>
