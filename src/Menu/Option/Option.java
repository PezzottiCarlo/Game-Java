package Menu.Option;

import GameEngine.GameBoard;

/**
 * This class represents an option in the menu.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Option implements IOption {

    //==================== Attributes ===================

    /**
     * Game board.
     */
    GameBoard board;

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param board Game board.
     */
    public Option(GameBoard board) {
        this.board = board;
    }

    /**
     * Constructor.
     */
    public Option() {}

    //==================== public methods ====================

    /**
     * Execute option.
     */
    @Override
    public void execute(int choice) {}
}
