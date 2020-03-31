package projectModels;

import models.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UserDAOJdbcTemplImpl implements UserCRUD {

    private static JdbcTemplate jdbcTemplate;
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM fix_user";
    //language=SQL
    private final String SQL_SELECT_BY_FIRST_NAME = "SELECT  * FROM fix_user WHERE name = ?";
    //language=SQL
    private final String SQL_SELECT_USERS_WITH_CARS = "SELECT * FROM fix_user LEFT JOIN fix_car ON fix_user.id = fix_car.owner_id WHERE fix_user.id = ?";
    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO fix_user (name, lastname, email, password) VALUES (?, ?, ?, ?)";

    static {
        Properties properties = new Properties();
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        try {

            properties.load(new FileInputStream("C:\\Users\\PCUser\\Desktop\\WebServlet_v1\\target\\WebServlet_v1\\WEB-INF\\classes\\db.properties"));
            String dbUrl = properties.getProperty("db.host");
            String dbUsername = properties.getProperty("db.login");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.DriverClassName");


            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public UserDAOJdbcTemplImpl() {
    }

    public UserDAOJdbcTemplImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<Member> findAllByFirstName(String firstName) {
        return jdbcTemplate.query(SQL_SELECT_BY_FIRST_NAME, userRowMapper, firstName);
    }

    @Override
    public boolean isExist(String email, String password) {
        return false;
    }

    @Override
    public boolean checkPassword(String passwordHash, String userInput) {
        return false;
    }

    @Override
    public Optional<Member> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Member model) {
        String name = model.getName();
        String lastname = model.getLastName();
        String email = model.getEmail();
        String password = model.getPassword();

        jdbcTemplate.update(SQL_INSERT_USER, name, lastname, email, password);

        System.out.println("User is saved!");

    }

    @Override
    public void update(Member model) {

    }

    @Override
    public void delete(int id) {

    }

    private RowMapper<Member> userRowMapper = (resultSet, i) -> {
        return new Member(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("lastname"),
                resultSet.getString("email"),
                resultSet.getString("password")
        );
    };

    public List<Member> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }
}
