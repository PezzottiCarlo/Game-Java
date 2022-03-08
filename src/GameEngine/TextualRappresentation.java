package GameEngine;
import Menu.*;
import Menu.Option.MovePlayersOption;
import Menu.Option.ShowGridOption;
import Menu.Option.ShowPlayersOption;
import Menu.Option.ExitOption;

/**
 * Rappresentazione testuale del menu di scelta del gioco.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class TextualRappresentation {

    //==================== Attributes ===================

    /**
     * Menu containing the options.
     */
    private final Menu menu;

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param board Game board.
     */
    public TextualRappresentation(GameBoard board) {
        menu = new Menu(false);

        //Add options
        menu.addMenu(new ShowGridOption(board));
        menu.addMenu(new MovePlayersOption(board));
        menu.addMenu(new ExitOption(board));
        menu.addMenu(new ShowPlayersOption(board));
    }

    //==================== public methods ====================

    /**
     * Prints the menu.
     */
    public void ask(){
        menu.ask();
    }
}
