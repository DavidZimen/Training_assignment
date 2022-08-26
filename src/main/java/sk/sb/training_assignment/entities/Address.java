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

    @Column(name = "psc")
    private String psc;

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
}
