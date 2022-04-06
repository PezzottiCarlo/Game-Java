package menu.option;

import gameEngine.GameBoard;

/**
 * This class represents an option in the menu.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public abstract class Option implements ExecuteOption {

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

    /**
     * Get key of the option. Default is '0'.
     */
    @Override
    public char getKeyOption() {
        return 0;
    }
}
