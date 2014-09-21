package yamenko.rims.persistence;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import yamenko.rims.Rating;

/**
 * Product entity
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Joined-Subclass Strategy
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public abstract class Product {
    /*
    * Attributes
    * */

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Rating rating;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    /*
    * Constructors
    * */

    protected Product() {
    }

    protected Product(String title, String description, Rating rating, Date releaseDate) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    /*
    * Getters & Setters
    * */

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public java.util.Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /*
    * Public methods
    * */

    @Override
    public String toString() {
        return getId() + ": " + getTitle();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof Product) {
            Product other = (Product) obj;

            return Objects.equals(id, other.id);
        }

        return false;
    }
}
