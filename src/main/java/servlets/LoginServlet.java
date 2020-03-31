package servlets;

import models.Member;
import projectModels.CRUD;
import projectModels.HibernateDAO;
import repositories.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


        CRUD crud = new HibernateDAO();
        List<Member> list = crud.findAll();


        if (crud.isExist(email, password)) {
            System.out.println("YOU ARE LOGGED");
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/");
            dispatcher.forward(req, resp);
        } else {
            System.out.println("LOGGIN IS UNSUCCESSFUL");

//            resp.sendRedirect("/login");

            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/loginForm.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
