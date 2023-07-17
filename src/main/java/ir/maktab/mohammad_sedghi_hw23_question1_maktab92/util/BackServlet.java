package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;




import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.VerifyTicket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Trip;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.TripRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TripRepository;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TripServiceImpl;
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
    TripRepository tripRepository;
    TripServiceImpl ticketService;
    private SessionFactory sessionFactory;
    String beginning;
    String destination;
    LocalDate departureDate;
    public void init() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect( "designPage/html/userNotFound.html");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = sessionFactory.openSession();
        tripRepository = new TripRepositoryImpl(session);
        ticketService = new TripServiceImpl(tripRepository);
     // Ticket ticket=new Ticket("tehran","esfahan", LocalDate.now(), LocalTime.of(13,40),"792");
      // ticketService.save(ticket);
         beginning=req.getParameter("begin");
       destination=req.getParameter("destination");
       String date=req.getParameter("departureDate");
       departureDate=LocalDate.parse(date);
        List<Trip> tripList =new ArrayList<>(ticketService.findPath(beginning,destination,departureDate));
        VerifyTicket.trip = tripList;
       req.setAttribute("tripList", tripList);
       req.setAttribute("beginning",beginning);
       req.setAttribute("destination",destination);
        RequestDispatcher rd = req.getRequestDispatcher("designPage/html/ticketList.jsp");
        rd.forward(req, resp);
    }


    public void destroy() {
    }

}
