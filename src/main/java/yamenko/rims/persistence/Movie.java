package yamenko.rims.persistence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import yamenko.rims.Rating;

/**
 * Movie entity
 */
@Entity
@NamedQuery(name = "findAllMovies", query = "SELECT m FROM Movie m")
public class Movie extends Product {
    /*
    * Attributes
    * */

    private String directorName;
    private Integer length;
    private String language;

    /*
    * Constructors
    * */

    public Movie() {
    }

    public Movie(String title, String description, Rating rating, Date releaseDate, String directorName, Integer length, String language) {
        super(title, description, rating, releaseDate);
        this.directorName = directorName;
        this.length = length;
        this.language = language;
    }

    /*
    * Getters & Setters
    * */

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
