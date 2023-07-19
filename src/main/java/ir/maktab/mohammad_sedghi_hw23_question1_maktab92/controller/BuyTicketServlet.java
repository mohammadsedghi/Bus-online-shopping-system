package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;


import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.util.VerifyTicket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
public class BuyTicketServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int counter=Integer.parseInt(req.getParameter("se"));
        Ticket ticket =VerifyTicket.ticket.get(counter-1);
        req.setAttribute("ticket", ticket);
        HttpSession session=req.getSession();
        session.setAttribute("ticket", ticket);
        resp.sendRedirect("designPage/html/buyTicket.html");
//        RequestDispatcher rd = req.getRequestDispatcher("designPage/html/buyTicket.html");
//        rd.forward(req, resp);

    }
}
