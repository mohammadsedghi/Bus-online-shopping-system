package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;

import java.io.*;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.hibernateUtil.HibernateUtil;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.MemberRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.MemberRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet(name = "helloServlet", value = "/first")
public class HelloServlet extends HttpServlet {
    MemberRepository memberRepository;
    MemberServiceImpl memberService;
    private SessionFactory sessionFactory;
    public void init() {
        sessionFactory= HibernateUtil.getSessionFactory();
//        passengerRepository = new PassengerRepositoryImpl(session);
//        passengerService = new PassengerServiceImpl(passengerRepository);
//        Session session = sessionFactory.openSession();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Session session = sessionFactory.openSession();
//         passengerRepository = new PassengerRepositoryImpl(session);
//        passengerService = new PassengerServiceImpl(passengerRepository);
//        String username = request.getParameter("fname");
//        String password = request.getParameter("lname");
//        passengerService.findByUsernameAndPassword(username, password);
//        if (member == null) {
//            response.sendRedirect("login.html");
//        } else {
//            response.sendRedirect("designPage/html/searchTrip.html");
//
//        }
//        response.setContentType("text/html");
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = sessionFactory.openSession();
        memberRepository = new MemberRepositoryImpl(session);
        memberService = new MemberServiceImpl(memberRepository);
       String firstName=req.getParameter("fname");
       String lastName=req.getParameter("lname");
        String username = req.getParameter("uname");
        String password = req.getParameter("pass");
        String nationalCode=req.getParameter("national");
        String gender=req.getParameter("gender");
        Member member =new Member(firstName,lastName,nationalCode,gender,username,password);
        memberService.save(member);
         resp.sendRedirect("designPage/html/logIn.html");
    }



    public void destroy() {
    }
}