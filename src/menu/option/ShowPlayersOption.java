package menu.option;

import gameEngine.GameBoard;
import gameObjects.*;

/**
 * This class represents the option to show the players on the game board.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class ShowPlayersOption extends Option {

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param board the game board.
     */
    public ShowPlayersOption(GameBoard board) {
        super(board);
    }

    //==================== public methods ====================

    /**
     * Show the players on the game board.
     *
     * @param choice the choice of the player.
     */
    @Override
    public void execute(int choice){
        for (GameObject gameObject : board.getGameLogic().getGameObjects()) {
            if (gameObject instanceof Player) {
                System.out.println(gameObject.toString());
            }
        }
    }

    /**
     * Return the description of the option.
     *
     * @return the description of the option.
     */
    @Override
    public String toString() {
        return "Show players";
    }
    
}
