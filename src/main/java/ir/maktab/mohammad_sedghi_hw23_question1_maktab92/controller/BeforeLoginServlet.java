package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller.hibernateUtil.HibernateUtil;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.MemberRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.MemberRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.MemberServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Arrays;

public class BeforeLoginServlet extends HttpServlet {
    MemberRepository memberRepository;
    MemberServiceImpl memberService;
    private SessionFactory sessionFactory;
    @Override
    public void init() throws ServletException {
        sessionFactory= HibernateUtil.getSessionFactory();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = sessionFactory.openSession();
        memberRepository = new MemberRepositoryImpl(session);
        memberService = new MemberServiceImpl(memberRepository);
        FilterCheck.member=null;
        Cookie[] cookies = req.getCookies();
        System.out.println("cccc"+ Arrays.toString(cookies));
        boolean f = false;
        String name = "";
        if (cookies == null) {
           resp.sendRedirect("designPage/html/logIn.html");
            return;
        }
        else {
            for (Cookie c : cookies) {
                String tname = c.getName();
                if (tname.equals("user_name")) {
                    name = c.getValue();
                   memberService.findByUsername(name);
                   if (FilterCheck.member!=null){
                       f = true;
                   }
                }
            }
        }
        if (f&&FilterCheck.member!=null) {
            RequestDispatcher rd = req.getRequestDispatcher("/afterFilter");
           rd.forward(req, resp);
           // resp.sendRedirect("http://localhost:8080/mohammad_sedghi_hw23_question1_maktab92_war_exploded/afterFilter");

        }
        else {
            resp.sendRedirect("designPage/html/logIn.html");
        }
    }


}
