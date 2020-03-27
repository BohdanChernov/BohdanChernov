package servlets;

import models.Member;
import repositories.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/listOfMem")
public class ListOfMemServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO DAO = new DAO();
        ArrayList<Member> list = DAO.getData();

        req.setAttribute("list", list);


        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/listOfMem.jsp");
        dispatcher.forward(req, resp);
    }
}
