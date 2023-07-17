package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.VerifyTicket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Trip;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TripRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TripServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class ShowDetailBoughtTicket extends HttpServlet {
    TripRepository tripRepository;
    TripServiceImpl tripService;
    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int counter = Integer.parseInt(req.getParameter("show"));
        Trip trip = VerifyTicket.boughtTrip.get(counter - 1);
        System.out.println("ttttttt " + trip);
        req.setAttribute("ticket", trip);
        HttpSession session = req.getSession();
        session.setAttribute("ticket", trip);
        resp.sendRedirect("designPage/html/buyTicket.html");
    }
}
