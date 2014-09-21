package yamenko.rims.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Customer entity
 */
@Entity
@NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c")
public class Customer {
    /*
    * Attributes
    * */

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    @OneToMany(cascade = CascadeType.REMOVE) // one-to-many unidirectional
    @JoinColumn(name = "customer_fk")
    private List<Rent> rents;

    /*
    * Constructors
    * */

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String address, List<Rent> rents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.rents = rents;
    }

    /*
    * Getters & Setters
    * */

    public List<Rent> getRents() {
        return rents;
    }

    public void addRent(Rent rent) {
        getRents().add(rent);
    }

    public boolean removeRent(Rent rent) {
        return getRents().remove(rent);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
