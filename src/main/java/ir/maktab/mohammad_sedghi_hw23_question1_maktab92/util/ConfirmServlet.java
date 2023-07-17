package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;


import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.VerifyTicket;
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


public class ConfirmServlet extends HttpServlet {
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
        ticketRepository =new TicketRepositoryImpl(sessionDb);
        ticketService =new TicketServiceImpl(ticketRepository);
        String nameLastname=req.getParameter("nameLastname");
        String gender=req.getParameter("inlineRadioOptions");
        String nationalId=req.getParameter(("nationalId"));
        HttpSession session=req.getSession();
        Ticket ticket=(Ticket) session.getAttribute("ticket");
        System.out.println("ticket confirm      "+ ticket);
        session.setAttribute("travelId", ticket.getTravelId());
        session.setAttribute("nameLastname",nameLastname);
        session.setAttribute("gender",gender);
        session.setAttribute("nationalId",nationalId);
        ticket.setGender(gender);
        ticket.setNameAndFamily(nameLastname);
        ticket.setNationalId(nationalId);
        ticket.setMember(FilterCheck.member);
       Ticket ticket1=new Ticket(ticket.getBeginning(),ticket.getDestination(),ticket.getDepartureDate(),ticket.getDepartureTime(),ticket.getTravelId());
        ticket1.setMember(FilterCheck.member);
        ticket1.setGender(gender);
        ticket1.setNameAndFamily(nameLastname);
        ticket1.setNationalId(nationalId);

//         ticket1=ticket;
         ticketService.save(ticket1);//*******************************save
        resp.sendRedirect("designPage/html/confirmTicket.jsp");
;
    }


}
