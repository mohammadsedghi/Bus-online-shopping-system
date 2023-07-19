package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.hibernateUtil.HibernateUtil;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.MemberRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.MemberRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.MemberServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class FilterCheck implements Filter {
    MemberRepository memberRepository;
    MemberServiceImpl memberService;
    private SessionFactory sessionFactory;
    public static Member member;
    public void init(FilterConfig arg0) throws ServletException {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        Session session = sessionFactory.openSession();
        memberRepository = new MemberRepositoryImpl(session);
        memberService = new MemberServiceImpl(memberRepository);
        String username = req.getParameter("fname");
        String password = req.getParameter("lname");
       if(member==null) {memberService.findByUsernameAndPassword(username, password);}
//        memberService.findByUsernameAndPassword(username, password);
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        //*****************************************************************cookie
        // Creating a cookie
        Cookie c = new Cookie("user_name", username);
        httpResponse.addCookie(c);
        //*****************************************************************cookie
        if (member == null) {
           // RequestDispatcher rd = req.getRequestDispatcher("/back");
            httpResponse.sendRedirect( "designPage/html/userNotFound.html");
          //  rd.forward(req, resp);
        } else {
            System.out.println(member);
            chain.doFilter(req, resp);

//            httpResponse.sendRedirect("designPage/html/searchTrip.html");
        }
    }
}
