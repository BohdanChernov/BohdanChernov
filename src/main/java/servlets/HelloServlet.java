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
import java.util.List;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String last = req.getParameter("lastName");
        req.setAttribute("userName", name);
        req.setAttribute("lastName", last);


        Member member = new Member(name, last);


        MyRepo myRepo = MyRepo.getInstance();
        myRepo.putMember(member);

        List listOfNames = myRepo.getData();


        req.setAttribute("listOfNames", listOfNames);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/getForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String last = req.getParameter("lastName");
        req.setAttribute("userName", name);
        req.setAttribute("lastName", last);


//        Member member = new Member(name, last);


//        MyRepo myRepo = MyRepo.getInstance();
//        myRepo.putMember(member);

//        List listOfNames = myRepo.getData();
//        req.setAttribute("listOfNames", listOfNames);


//        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/showForm.jsp");
//        dispatcher.forward(req, resp);
        doGet(req, resp);
    }
}
