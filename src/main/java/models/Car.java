package models;


import javax.persistence.*;

@Entity
@Table(name = "fix_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "model")
    private String model;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Member owner;

    public Car() {
    }

    public Car(int id, String model, Member owner) {
        this.id = id;
        this.model = model;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }
}
