package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.MemberRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.MemberRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.MemberServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class FilterCheck extends HttpFilter {
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
        memberService.findByUsernameAndPassword(username, password);
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
