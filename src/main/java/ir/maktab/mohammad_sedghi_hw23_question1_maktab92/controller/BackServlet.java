package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;




import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.hibernateUtil.HibernateUtil;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.util.VerifyTicket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.TicketRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TicketServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Setter
@Getter
//@WebServlet(name = "BackServlet", value = "/back")
public class BackServlet extends HttpServlet {
    TicketRepository ticketRepository;
    TicketServiceImpl ticketService;
    private SessionFactory sessionFactory;
    String beginning;
    String destination;
    LocalDate departureDate;
    public void init() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  resp.sendRedirect( "designPage/html/userNotFound.html");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = sessionFactory.openSession();
        ticketRepository = new TicketRepositoryImpl(session);
        ticketService = new TicketServiceImpl(ticketRepository);
  //  Ticket ticket =new Ticket("tehran","esfahan", LocalDate.now(), LocalTime.of(13,50),"793");
     //  ticketService.save(ticket);
         beginning=req.getParameter("begin");
       destination=req.getParameter("destination");
       String date=req.getParameter("departureDate");
        System.out.println(beginning);
        System.out.println(destination);
       departureDate=LocalDate.parse(date);
        System.out.println(departureDate.toString());
        List<Ticket> ticketList =new ArrayList<>(ticketService.findPath(beginning,destination,departureDate));
        VerifyTicket.ticket = ticketList;
        System.out.println(ticketList);
       req.setAttribute("ticketList", ticketList);
//       req.setAttribute("beginning",beginning);
//       req.setAttribute("destination",destination);
        RequestDispatcher rd = req.getRequestDispatcher("designPage/html/ticketList.jsp");
        rd.forward(req, resp);
    }


    public void destroy() {
    }

}
