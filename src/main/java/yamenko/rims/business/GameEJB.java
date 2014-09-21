package yamenko.rims.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import yamenko.rims.persistence.Game;

/**
 * Game EJB
 */
@Stateless
public class GameEJB {
    /*
    * Attributes
    * */

    @PersistenceContext(unitName = "RIMSPU")
    private EntityManager em;

    /*
    * Public methods
    * */

    public Game createGame(Game game) {
        em.persist(game);

        return game;
    }

    public List<Game> findGames() {
        TypedQuery<Game> query = em.createNamedQuery("findAllGames", Game.class);

        return query.getResultList();
    }

    public void deleteGame(Game game) {
        em.remove(em.merge(game));
    }
}
