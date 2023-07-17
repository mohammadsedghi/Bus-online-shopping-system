package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AfterFilter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   resp.sendRedirect("designPage/html/searchTrip.html");
    }

    @Override
    public void init() throws ServletException {

    }
}
