package yamenko.rims.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import yamenko.rims.business.GameEJB;
import yamenko.rims.persistence.Game;

/**
 * Game managed bean
 */
@ManagedBean
@ViewScoped
public class GameController {
    /*
    * Attributes
    * */

    @EJB
    private GameEJB gameEJB;
    private Game game = new Game();
    private List<Game> gameList;

    /*
    * Public methods
    * */

    public void doFindGames() {
        setGameList(gameEJB.findGames());
    }

    public void doCreateGame() {
        gameEJB.createGame(getGame());
        setGame(new Game()); // reset game field
    }

    public void doDeleteGame(Game game) {
        gameEJB.deleteGame(game);
    }

    /*
    * Getters & Setters
    * */

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
