package game.strategies.GamePhaseStrategies;

import game.Game;
import game.model.Country;
import game.model.GameState;
import game.model.Player;

import java.io.Serializable;

import static game.utils.MapFunctionsUtil.resetToAndFrom;
import static game.utils.MapFunctionsUtil.unHighlightCountries;
import static game.utils.MapFunctionsUtil.unSelectCountries;

/**
 * Base phase strategy class. Required to prepare game state for base phase.
 *
 * @author Dmitry Kryukov, Ksenia Popova
 * @see IGamePhaseStrategy
 */
public class BasePhaseStrategy implements IGamePhaseStrategy, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Check if game was won by player
     * Set the flag lost to opponent
     *
     * @param player
     * @return boolean
     */
    public static boolean isGameWonBy(GameState gameState, Player player) {
        for (Country country : gameState.getCountries()) {
            if (country.getPlayer() != player) {
                return false;
            }
        }
        for (Player playerToSetLost : gameState.getPlayers()) {
            if (playerToSetLost != player) {
                playerToSetLost.setLost(true);
            }
        }
        return true;
    }

    /**
     * Debug messages.
     *
     * @param gameState
     */
    static void debugMessage(GameState gameState) {
        System.out.println("-----");
        System.out.println("Current phase " + gameState.getCurrentGamePhase().toString());
        System.out.println("Current player " + gameState.getCurrentPlayer().getName());
        System.out.println("-----");
        Game.getInstance().getNotification().setNotification("\n------------------------------------------");
        Game.getInstance().getNotification().setNotification("Current phase " + gameState.getCurrentGamePhase().toString());
        Game.getInstance().getNotification().setNotification("Current player " + gameState.getCurrentPlayer().getName());
    }

    /**
     * Initialization of base phase strategy.
     *
     * @param gameState
     */
    @Override
    public void init(GameState gameState) {
        resetToAndFrom(gameState);
        unSelectCountries(gameState);
        unHighlightCountries(gameState);
        if (gameState.getCurrentPlayer() != null && gameState.getCurrentPlayer().isComputerPlayer()) {
            gameState.setNextTurnButton(false);
        } else {
            gameState.setNextTurnButton(true);
        }
    }

    /**
     * Map click for base strategy
     * Method is not required here. Stub
     *
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
     * Method is not required here. Stub
     *
     * @param gameState
     */
    @Override
    public void nextTurnButton(GameState gameState) {
        System.out.println("The nextTurnButton method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * Exchange behavior
     * Method is not required here. Stub
     *
     * @param gameState
     */
    @Override
    public void exchangeButton(GameState gameState) {
        System.out.println("The exchangeButton method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * Attack behavior
     * Method is not required here. Stub
     *
     * @param gameState
     */
    @Override
    public void attackButton(GameState gameState) {
        System.out.println("The attackButton method is not implemented in " + this.getClass().getName() + " strategy.");
    }

    /**
     * Cleanup behavior
     * Method is not required here. Stub
     *
     * @param gameState
     */
    @Override
    public void cleanup(GameState gameState) {
        System.out.println("The cleanup method is not implemented in " + this.getClass().getName() + " strategy.");
    }
}
