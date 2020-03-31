package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fix_user")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "lastname")
    private String lastName;

    @JoinColumn(name = "email")
    private String email;

    @JoinColumn(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "owner_id")
    private List<Car> cars = new ArrayList<>();

    public Member() {
    }

    public Member(int id, String name, String lastName, String email, String password, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cars = cars;
    }

    public Member(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Member(String name, String lastName, String email, String password, List<Car> cars) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cars = cars;
    }

    public Member(int id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
