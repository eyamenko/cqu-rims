package yamenko.rims.persistence;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rent entity
 */
@Entity
public class Rent {
    /*
    * Attributes
    * */

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_fk")
    private Product product;
    @Temporal(TemporalType.DATE)
    private Date rentDate;
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    /*
    * Constructors
    * */

    public Rent() {
    }

    public Rent(Product product, Date rentDate, Date dueDate) {
        this.product = product;
        this.rentDate = rentDate;
        this.dueDate = dueDate;
    }

    /*
    * Pre persist methods
    * */

    /**
     * Assigns today's date as a rent date.
     */
    @PrePersist
    public void createdAt() {
        setRentDate(new Date());
    }

    /*
    * Public methods
    * */

    /**
     * Calculate number of days between rent date and due date.
     *
     * @return number of days
     */
    public int getNumberOfDaysHired() {
        return Days.daysBetween(new DateTime(getRentDate()), new DateTime(getDueDate())).getDays();
    }

    /*
    * Getters & Setters
    * */

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }
}
