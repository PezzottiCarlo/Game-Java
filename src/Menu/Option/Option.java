package Menu.Option;

import GameEngine.GameBoard;

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

    @Override
    public char getKeyOption() {
        return 0;
    }
}
