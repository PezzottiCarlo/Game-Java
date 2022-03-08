package Menu.Option;

import GameEngine.GameBoard;

/**
 * This class represents the option to show the grid.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class ShowGridOption extends Option{

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param board the board to show.
     */
    public ShowGridOption(GameBoard board) {
        super(board);
    }
    //==================== public methods ====================

    /**
     * Show the grid.
     *
     * @param choice the choice of the user.
     */
    @Override
    public void execute(int choice){
        board.show();
    }

    /**
     * Return the description of the option.
     *
     * @return the description of the option.
     */
    @Override
    public String toString() {
        return "Show grid";
    }
}