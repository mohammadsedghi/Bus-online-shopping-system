package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.VerifyTicket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TicketServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class ShowDetailBoughtTicket extends HttpServlet {
    TicketRepository ticketRepository;
    TicketServiceImpl tripService;
    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int counter = Integer.parseInt(req.getParameter("show"));
        Ticket ticket = VerifyTicket.boughtTicket.get(counter - 1);
        System.out.println("uuuuu " + ticket);
        req.setAttribute("ticket", ticket);
        HttpSession session = req.getSession();
        session.setAttribute("ticket", ticket);
        RequestDispatcher rd = req.getRequestDispatcher("designPage/html/ShowDetailBoughtTicket.jsp");
        rd.forward(req, resp);
      //  resp.sendRedirect("designPage/html/ShowDetailBoughtTicket.jsp");
    }
}
