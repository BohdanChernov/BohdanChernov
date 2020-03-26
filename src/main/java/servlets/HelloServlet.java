package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showForm")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String last = req.getParameter("lastName");

        req.setAttribute("userName", name);
        req.setAttribute("lastName", last);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/showForm.jsp");
        dispatcher.forward(req, resp);
    }
}
