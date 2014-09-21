package yamenko.rims.persistence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import yamenko.rims.Rating;

/**
 * Game entity
 */
@Entity
@NamedQuery(name = "findAllGames", query = "SELECT g FROM Game g")
public class Game extends Product {
    /*
    * Attributes
    * */

    private String studioName;
    private String platform;

    /*
    * Constructors
    * */

    public Game() {
    }

    public Game(String title, String description, Rating rating, Date releaseDate, String studioName, String platform) {
        super(title, description, rating, releaseDate);
        this.studioName = studioName;
        this.platform = platform;
    }

    /*
    * Getters & Setters
    * */

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
