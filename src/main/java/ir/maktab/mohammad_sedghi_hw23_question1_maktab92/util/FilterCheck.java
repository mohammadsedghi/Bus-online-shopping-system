package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.PassengerRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.PassengerRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.PassengerServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
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
        if (member == null) {
//            resp.sendRedirect("login.html");
            RequestDispatcher rd = req.getRequestDispatcher("designPage/html/index.jsp");
            
            rd.forward(req, resp);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) resp;

            chain.doFilter(req, resp);
            httpResponse.sendRedirect("designPage/html/searchTrip.html");

        }
//        PrintWriter out = resp.getWriter();
//
//        String password = req.getParameter("password");
//        System.out.println(password);
//        if (password.equals("admin")) {
//            chain.doFilter(req, resp);//sends request to next resource
//        } else {
//            RequestDispatcher rd = req.getRequestDispatcher("aaa.html");
//            rd.forward(req, resp);
//
//        }
    }
}
