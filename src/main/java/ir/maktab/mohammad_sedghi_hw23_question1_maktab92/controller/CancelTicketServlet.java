package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;


import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.hibernateUtil.HibernateUtil;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.TicketRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TicketServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class CancelTicketServlet extends HttpServlet {
    TicketRepository ticketRepository;
    TicketServiceImpl ticketService;
    private SessionFactory sessionFactory;
    @Override
    public void init() throws ServletException {
        sessionFactory= HibernateUtil.getSessionFactory();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session sessionDb = sessionFactory.openSession();
        ticketRepository = new TicketRepositoryImpl(sessionDb);
        ticketService = new TicketServiceImpl(ticketRepository);
        String ticketStrId=req.getParameter("cancel");
       Ticket ticket=new Ticket();
       ticket.setId(Long.parseLong(ticketStrId));
         ticketService.remove(ticket);
       // RequestDispatcher rd=req.getRequestDispatcher("designPage/html/endPage.html");
        RequestDispatcher rd=req.getRequestDispatcher("designPage/html/ee.jsp");
        rd.forward(req,resp);

    }
}
