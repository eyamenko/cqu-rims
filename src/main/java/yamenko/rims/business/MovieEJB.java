package yamenko.rims.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import yamenko.rims.persistence.Movie;

/**
 * Movie EJB
 */
@Stateless
public class MovieEJB {
    /*
    * Attributes
    * */

    @PersistenceContext(unitName = "RIMSPU")
    private EntityManager em;

    /*
    * Public methods
    * */

    public Movie createMovie(Movie movie) {
        em.persist(movie);

        return movie;
    }

    public List<Movie> findMovies() {
        TypedQuery<Movie> query = em.createNamedQuery("findAllMovies", Movie.class);

        return query.getResultList();
    }

    public void deleteMovie(Movie movie) {
        em.remove(em.merge(movie));
    }
}
