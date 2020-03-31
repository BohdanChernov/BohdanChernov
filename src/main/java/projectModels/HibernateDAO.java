package projectModels;

import at.favre.lib.crypto.bcrypt.BCrypt;
import models.Car;
import models.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class HibernateDAO implements UserCRUD {
    private static Session session;

    static {
        Properties properties = new Properties();
        try {
//            properties.load(new FileReader(getServletContext().getRealPath("WEB-INF/classes/db.properties")));
            properties.load(new FileReader("C:\\Users\\PCUser\\Desktop\\WebServlet_v1\\src\\main\\resources\\db.properties"));
            String url = properties.getProperty("db.host");
            String name = properties.getProperty("db.login");
            String password = properties.getProperty("db.password");
            String className = properties.getProperty("db.DriverClassName");

            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.url", url);
            configuration.setProperty("hibernate.connection.username", name);
            configuration.setProperty("hibernate.connection.password", password);
            configuration.setProperty("hibernate.connection.driver_class", className);
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
            configuration.addAnnotatedClass(Member.class);
            configuration.addAnnotatedClass(Car.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();

            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HibernateDAO() {
    }


    @Override
    public List<Member> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<Member> find(Integer id) {
        Member user = session.createQuery("from Member user where user.id = " + id, Member.class).getSingleResult();

        Optional<Member> mem = Optional.of(user);

        return mem;
    }

    @Override
    public void save(Member model) {
        session.beginTransaction();
        session.save("member", model);
        session.getTransaction().commit();
    }

    @Override
    public void update(Member model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Member> findAll() {
        List<Member> list = session.createQuery("from Member mem", Member.class).getResultList();
        return list;
    }

    public boolean isExist(String email, String password) {
        System.out.println();
        System.out.println("Email to check: " + email);
        System.out.println("Password to check: " + password);
        System.out.println();
        List<Member> members = findAll();
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

    public boolean checkPassword(String passwordHash, String userInput) {
        if (passwordHash == null || passwordHash.isEmpty()) {
            return false;
        }
        return BCrypt.verifyer().verify(userInput.toCharArray(), passwordHash).verified;
    }

    public List<Car> getMemberCars(Member member) {
//        List<Member> list = session.createQuery("from Member mem", Member.class).getResultList();
        int id = member.getId();

        List<Car> cars = session.createQuery("from Car car where car.owner =" + id, Car.class).getResultList();
        return cars;
    }

}
