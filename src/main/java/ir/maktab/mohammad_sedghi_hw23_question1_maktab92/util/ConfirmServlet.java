package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfirmServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameLastname=req.getParameter("nameLastname");
        String gender=req.getParameter("inlineRadioOptions");
        HttpSession session=req.getSession();
        Ticket ticket= (Ticket) session.getAttribute("ticket");
        System.out.println("confirm      "+ticket);
     //   req.setAttribute("travelId",ticket.getTravelId());
        session.setAttribute("travelId",ticket.getTravelId());
        session.setAttribute("nameLastname",nameLastname);
        session.setAttribute("gender",gender);
       // req.setAttribute("nameLastname",nameLastname);
      //  req.setAttribute("gender",gender);
        Passenger passenger=new Passenger();
        passenger.setLastName(nameLastname);
        passenger.setGender(gender);
        resp.sendRedirect("designPage/html/confirmTicket.jsp");
    }


}
