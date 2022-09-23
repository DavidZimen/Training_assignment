package sk.sb.training_assignment.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "TA_USER")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "personal_number", insertable = false, updatable = false, columnDefinition = "serial")
    private Long personalNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Version
    private int version;

// CONSTRUCTORS
    public User() {

    }

    /**
     * Basic constructor to create an object with required attributes.
     * @param pName - name of the user
     * @param pSurname - surname of the user
     * @param pBirthDate - birthdate of the user
     * @param address - address id of given user
     */
    public User(String pName, String pSurname, Date pBirthDate, Address address) {
        this.name = pName;
        this.surname = pSurname;
        this.birthDate = pBirthDate;
        this.address = address;
    }

//GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Date parseDate(String date) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return (Date) DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}