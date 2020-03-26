package servlets;

import models.Member;
import repositories.MyRepo;
import repositories.Repository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String last = req.getParameter("lastName");



        ArrayList<Member> listOfNames;

        try {
            listOfNames = (ArrayList<Member>) req.getAttribute("listOfNames");
            listOfNames.toString();
        } catch (Exception e) {
            listOfNames = new ArrayList<>();
        }


        req.setAttribute("listOfNames", listOfNames);
        req.setAttribute("userName", name);
        req.setAttribute("lastName", last);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/getForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String last = req.getParameter("lastName");

        MyRepo myRepo = MyRepo.getInstance();
        myRepo.putMember(new Member(name, last));
        ArrayList<Member> listOfNames = myRepo.getData();

        req.setAttribute("userName", name);
        req.setAttribute("lastName", last);
        req.setAttribute("listOfNames", listOfNames);

        doGet(req, resp);
    }
}
