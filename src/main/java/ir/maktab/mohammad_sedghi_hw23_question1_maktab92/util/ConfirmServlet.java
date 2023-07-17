package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;


import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Trip;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.TripRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TripRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TripServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.IOException;


public class ConfirmServlet extends HttpServlet {
   TripRepository tripRepository;
   TripServiceImpl tripService;
    private SessionFactory sessionFactory;
    @Override
    public void init() throws ServletException {
        sessionFactory= HibernateUtil.getSessionFactory();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session sessionDb = sessionFactory.openSession();
        tripRepository = new TripRepositoryImpl(sessionDb);
        tripService = new TripServiceImpl(tripRepository);
        String nameLastname=req.getParameter("nameLastname");
        String gender=req.getParameter("inlineRadioOptions");
        String nationalId=req.getParameter(("nationalId"));
        HttpSession session=req.getSession();
        Trip trip = (Trip) session.getAttribute("trip");
        System.out.println("confirm      "+ trip);
        session.setAttribute("travelId", trip.getTravelId());
        session.setAttribute("nameLastname",nameLastname);
        session.setAttribute("gender",gender);
        session.setAttribute("nationalId",nationalId);
        trip.setNameAndFamily(nameLastname);
        trip.setGender(gender);
        trip.setNationalId(nationalId);
         tripService.update(trip);//*******************************update
        Member member =new Member();
        member.setLastName(nameLastname);
        member.setGender(gender);
        resp.sendRedirect("designPage/html/confirmTicket.jsp");
;
    }


}
