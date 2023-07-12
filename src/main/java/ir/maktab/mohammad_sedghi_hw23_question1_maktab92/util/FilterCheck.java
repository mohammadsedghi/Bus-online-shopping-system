package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.PassengerRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.PassengerRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.PassengerServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.io.PrintWriter;

public class FilterCheck extends HttpFilter {
    PassengerRepository passengerRepository;
    PassengerServiceImpl passengerService;
    private SessionFactory sessionFactory;
    public static Passenger member;
    public void init(FilterConfig arg0) throws ServletException {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        Session session = sessionFactory.openSession();
        passengerRepository = new PassengerRepositoryImpl(session);
        passengerService = new PassengerServiceImpl(passengerRepository);
        String username = req.getParameter("fname");
        String password = req.getParameter("lname");
        passengerService.findByUsernameAndPassword(username, password);
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        if (member == null) {
            RequestDispatcher rd = req.getRequestDispatcher("/back");
            rd.forward(req, resp);
        } else {
            chain.doFilter(req, resp);
            httpResponse.sendRedirect("designPage/html/searchTrip.html");
        }
    }
}
