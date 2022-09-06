package sk.sb.training_assignment.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TA_ADDRESS")
public class Address implements Serializable {

//ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;

//CONSTRUCTORS
    public Address() {
    }

//GETTERS and SETTERS
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
