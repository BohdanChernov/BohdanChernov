package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/firstPage")
public class FirstPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie[] = req.getCookies();

        Cookie cookieNew = null;

        for (Cookie cookieOne : cookie) {
            if (cookieOne.getName().equals("colorOfPage")) {
                cookieNew = cookieOne;
                break;
            }
        }

        try {
            req.setAttribute("colorOfPage", cookieNew.getValue());
        } catch (Exception e) {
        }


        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/firstPage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("colorOfPage");
        System.out.println(str);

        Cookie cookie = new Cookie("colorOfPage", str);
        resp.addCookie(cookie);

        req.setAttribute("colorOfPage", str);

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/firstPage.jsp");
        dispatcher.forward(req, resp);
    }
}
