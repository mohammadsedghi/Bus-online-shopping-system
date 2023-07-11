package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name = "BackServlet", value = "/back")
public class BackServlet extends HttpServlet {
    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//          resp.sendRedirect("index.jsp");
        System.out.println("ahhciushdcs");
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
        resp.setHeader("Location",req.getContextPath() + "/index.jsp");

    }

    public void destroy() {
    }

}
