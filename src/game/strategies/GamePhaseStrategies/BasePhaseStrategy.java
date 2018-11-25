package game.strategies.GamePhaseStrategies;

import game.model.Country;
import game.model.GameState;
import game.model.Player;

import java.util.List;

/**
 * Base phase strategy class. Required to prepare game state for base phase.
 *
 * @author Dmitry Kryukov, Ksenia Popova
 * @see IGamePhaseStrategy
 */
public class BasePhaseStrategy implements IGamePhaseStrategy {

    /**
     * Method to highlight the player countries
     */
    static void highlightPayerCountries(List<Country> countries, Player player) {
        for (Country c : countries) {
            if (c.getPlayer() == player) {
                c.setHighlighted(true);
            }
        }
    }

    /**
     * Method that unhighlight the players countries
     */
    static void unHighlightCountries(GameState gameState) {
        for (Country c : gameState.getCountries()) {
            c.setHighlighted(false);
        }
    }

    /**
     * Method that unhighlight the players countries
     */
    static void unSelectCountries(GameState gameState) {
        for (Country c : gameState.getCountries()) {
            c.setSelected(false);
        }
    }

    /**
     * Reset highlights
     */
    static void resetToAndFrom(GameState gameState) {
        unHighlightCountries(gameState);
        if (gameState.getCountryFrom() != null) {
            gameState.getCountryFrom().unSelect(false);
        }
        gameState.setCountryFrom(null);

        if (gameState.getCountryTo() != null) {
            gameState.getCountryTo().unSelect(false);
        }
        gameState.setCountryTo(null);
    }

    /**
     * Selection of country. Force required states.
     * @param gameState
     * @param x
     * @param y
     * @return boolean
     */
    boolean selectCountry(GameState gameState, int x, int y) {
        gameState.setCurrentCountry(null);

        for (Country country : gameState.getCountries()) {
            if (country.isInBorder(x, y)) {
                gameState.setCurrentCountry(country);
                System.out.println("Selected " + country.getName());
                return true;
            }
        }
        return false;
    }

    /**
     * Check if game was won by player
     *
     * @param player
     * @return boolean
     */
    static boolean isGameWonBy(GameState gameState, Player player) {
        for (Country country : gameState.getCountries()) {
            if (country.getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    /**
     * Debug messages.
     * @param gameState
     */
    static void debugMessage(GameState gameState) {
        System.out.println("-----");
        System.out.println("Current phase " + gameState.getCurrentGamePhase().toString());
        System.out.println("Current player " + gameState.getCurrentPlayer().getName());
        System.out.println("-----");
    }

    /**
     * Initialization of base phase strategy.
     * @param gameState
     */
    @Override
    public void init(GameState gameState) {
        System.out.println("The init method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * Map click for base strategy
     * @param gameState
     * @param x
     * @param y
     */
    @Override
    public void mapClick(GameState gameState, int x, int y) {
        System.out.println("The mapClick method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * Next turn button behavior
     * @param gameState
     */
    @Override
    public void nextTurnButton(GameState gameState) {
        System.out.println("The nextTurnButton method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * Exchange behavoir
     * @param gameState
     */
    @Override
    public void exchangeButton(GameState gameState) {
        System.out.println("The exchangeButton method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * Attack behavoir
     * @param gameState
     */
    @Override
    public void attackButton(GameState gameState) {
        System.out.println("The attackButton method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * cleaning
     * @param gameState
     */
    @Override
    public void cleanup(GameState gameState) {
        System.out.println("The cleanup method is not implemented in " + this.getClass().getName() + " strategy.");
    }
}
