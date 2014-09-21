package yamenko.rims.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import yamenko.rims.business.MovieEJB;
import yamenko.rims.persistence.Movie;

/**
 * Movie managed bean
 */
@ManagedBean
@ViewScoped
public class MovieController {
    /*
    * Attributes
    * */

    @EJB
    private MovieEJB movieEJB;
    private Movie movie = new Movie();
    private List<Movie> movieList;

    /*
    * Public methods
    * */

    public void doFindMovies() {
        setMovieList(movieEJB.findMovies());
    }

    public void doCreateMovie() {
        movieEJB.createMovie(getMovie());
        setMovie(new Movie()); // reset movie field
    }

    public void doDeleteMovie(Movie movie) {
        movieEJB.deleteMovie(movie);
    }

    /*
    * Getters & Setters
    * */

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
