package projectServlets;

import models.Car;
import models.Member;
import projectModels.CRUD;
import projectModels.HibernateDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.List;

@WebServlet("/showMemberCars")
public class ShowMemberCarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/memberCars.jsp");
//        dispatcher.forward(req, resp);
//        String id = req.getParameter("id");

        CRUD crud = new HibernateDAO();
        Optional<Member> memberOptional = crud.find(Integer.parseInt(6 + ""));
        Member member = memberOptional.get();

        req.setAttribute("cars", member.getCars());

        req.setAttribute("member", member);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/memberCars.jsp");
        dispatcher.forward(req, resp);
    }

}
