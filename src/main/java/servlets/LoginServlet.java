package servlets;

import models.Member;
import repositories.MyRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/loginForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        MyRepository myRepository = new MyRepository();
        ArrayList<Member> list = myRepository.getData();

        if (myRepository.isExist(email, password)) {
            System.out.println("USER EXISTS");
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/firstPage");
            dispatcher.forward(req, resp);
        }

        resp.sendRedirect("/");
    }
}
