package repositories;

import at.favre.lib.crypto.bcrypt.BCrypt;
import models.Member;

import java.sql.*;
import java.util.ArrayList;

public class DAO implements Repository {
    private static Statement statement;

    static {
        statement = connect();
    }

    @Override
    public ArrayList getData() {
        ArrayList<Member> members = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM fix_user");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String id = null;
            String name = null;
            String lastName = null;
            String email = null;
            String password = null;
            try {
                id = resultSet.getString("id");
                int idNew = Integer.parseInt(id);
                name = resultSet.getString("name");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                members.add(new Member(idNew, name, lastName, email, password));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return members;
    }

    @Override
    public void addMember(String name1, String last1, String email1, String pass1) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO fix_user (name, lastname, email, password) \nVALUES ");
        sb.append("(");
        sb.append("'" + name1 + "'" + ", ");
        sb.append("'" + last1 + "'" + ", ");
        sb.append("'" + email1 + "'" + ", ");
        sb.append("'" + pass1 + "'" + ");");

        System.out.println();
        System.out.println(sb);

        try {
            statement.executeUpdate(sb.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean isExist(String email, String password) {
        System.out.println();
        System.out.println("Email to check: " + email);
        System.out.println("Password to check: " + password);
        System.out.println();
        ArrayList<Member> members = getData();
        for (Member member : members) {
            System.out.println("E-mail: " + member.getEmail());
            System.out.println("Password: " + member.getPassword());
            if (member.getEmail().equals(email) && checkPassword(member.getPassword(), password)) {
                System.out.println("E-mail: " + member.getEmail());
                System.out.println("Password: " + member.getPassword());
                System.out.println("IS EXIST - TRUE");
                return true;
            }
        }

        System.out.println("IS EXIST - FALSE");
        return false;
    }

    public static String getCrypt(String password) {
        String hashPass = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, password.toCharArray());
        return hashPass;
    }

    public boolean checkPassword(String passwordHash, String userInput) {
        if (passwordHash == null || passwordHash.isEmpty()) {
            return false;
        }
        return BCrypt.verifyer().verify(userInput.toCharArray(), passwordHash).verified;
    }

    public static Statement connect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String dbUser = "postgres";
        String pass = "123";
        String url = "jdbc:postgresql://localhost:5432/users";
        Statement statementNew = null;
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, pass);
            statementNew = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return statementNew;
    }
}
