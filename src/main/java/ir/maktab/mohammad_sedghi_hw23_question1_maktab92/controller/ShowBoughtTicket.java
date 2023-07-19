package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.hibernateUtil.HibernateUtil;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.util.VerifyTicket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.TicketRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TicketServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ShowBoughtTicket extends HttpServlet {
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
        Long id = FilterCheck.member.getId();
        List<Ticket> boughtTicketList =new ArrayList<>(ticketService.findTicketByMemberId(id));
        VerifyTicket.boughtTicket = boughtTicketList;
        HttpSession session=req.getSession();
        session.setAttribute("boughtTicketList", boughtTicketList);
        resp.sendRedirect("designPage/html/ShowBoughtTicket.jsp");
    }
}
