package projectModels;

import models.Member;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryDAO implements UserCRUD {
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM fix_user";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM fix_user WHERE id = ?";
    private Connection connection;

    public UserRepositoryDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Member> findAllByFirstName(String firstName) {
        return null;
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
        Optional<Member> member = Optional.empty();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Integer id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String last = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                member = Optional.of(new Member(id1, name, last, email, password));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return member;
    }

    @Override
    public void save(Member model) {

    }

    @Override
    public void update(Member model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Member> findAll() {
        List<Member> members = null;
        try {
            members = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String last = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Member member = new Member(id, name, last, email, password);
                members.add(member);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return members;
    }
}
