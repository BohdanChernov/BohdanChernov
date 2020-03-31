package servlets;

import models.Member;
import projectModels.CRUD;
import projectModels.HibernateDAO;
import repositories.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listOfMem")
public class ListOfMembersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CRUD crud = new HibernateDAO();
        List<Member> list = crud.findAll();

        req.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/listOfMem.jsp");
        dispatcher.forward(req, resp);
    }
}
