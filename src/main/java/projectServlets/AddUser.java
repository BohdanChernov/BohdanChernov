package projectServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader(getServletContext().getRealPath("WEB-INF/classes/db.properties")));
            System.out.println(properties.getProperty("db.host"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addUser.jsp").forward(req, resp);
    }
}
