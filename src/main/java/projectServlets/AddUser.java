package projectServlets;

import repositories.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader(getServletContext().getRealPath("WEB-INF/classes/db.properties")));
            String dbHost = properties.getProperty("db.host");
            String dbLogin = properties.getProperty("db.login");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.DriverClassName");

            Class.forName(dbDriverClassName);
            connection = DriverManager.getConnection(dbHost, dbLogin, dbPassword);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        DAO DAO = new DAO();

        String passCrypt = DAO.getCrypt(password);

//        DAO.addMember(name, lastName, email, passCrypt);


        try {
            String sqlInsert = "INSERT INTO fix_user (name, lastname, email, password) \nVALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, passCrypt);

            preparedStatement.execute();

            System.out.println("Сервлет дупост из AddUser выполнен!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        resp.sendRedirect("/login");

    }
}
