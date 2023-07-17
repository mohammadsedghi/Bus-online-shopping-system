package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.VerifyTicket;
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
import java.util.ArrayList;
import java.util.List;

public class ShowBoughtTicket extends HttpServlet {
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
        String nationalId = FilterCheck.member.getNationalId();
        List<Trip> boughtTripList =new ArrayList<>(tripService.findBoughtTicket(nationalId));
        VerifyTicket.boughtTrip = boughtTripList;
        HttpSession session=req.getSession();
        session.setAttribute("boughtTicketList", boughtTripList);
        resp.sendRedirect("designPage/html/ShowBoughtTicket.jsp");


    }
}
