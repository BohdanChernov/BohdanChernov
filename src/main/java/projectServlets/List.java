package projectServlets;

import models.Member;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import projectModels.UserCRUD;
import projectModels.UserDAOJdbcTemplImpl;
import projectModels.UserRepositoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/list")
public class List extends HttpServlet {
    private UserCRUD userRepositoryDAO;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(getServletContext().getRealPath("WEB-INF/classes/db.properties")));
            String dbHost = properties.getProperty("db.host");
            String dbLogin = properties.getProperty("db.login");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.DriverClassName");

            driverManagerDataSource.setUsername(dbLogin);
            driverManagerDataSource.setPassword(dbPassword);
            driverManagerDataSource.setDriverClassName(dbDriverClassName);
            driverManagerDataSource.setUrl(dbHost);

            userRepositoryDAO = new UserDAOJdbcTemplImpl(driverManagerDataSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        java.util.List<Member> memberList = null;
        if (req.getParameter("name") != null) {
            String firstName = req.getParameter("name");
            memberList = userRepositoryDAO.findAllByFirstName(firstName);

        } else {
            memberList = userRepositoryDAO.findAll();
        }



        System.out.println(memberList);
        req.setAttribute(("list"), memberList);

        getServletContext().getRequestDispatcher("/members.jsp").forward(req, resp);

    }
}
