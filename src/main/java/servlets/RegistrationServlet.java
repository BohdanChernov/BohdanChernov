package servlets;

import at.favre.lib.crypto.bcrypt.BCrypt;
import models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import projectModels.CRUD;
import projectModels.HibernateDAO;
import projectModels.UserDAOJdbcTemplImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Autowired
    CRUD crud;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println("Contex is succesfully deployed!");
        crud = context.getBean(UserDAOJdbcTemplImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/registrationForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String hashPass = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray());

        int i = 0;

//        CRUD crud = new HibernateDAO();
        crud.save(new Member(name, lastName, email, hashPass));

        System.out.println("Сервлет дупост из RegistrationServlet выполнен!");

        resp.sendRedirect("/login");
    }
}
