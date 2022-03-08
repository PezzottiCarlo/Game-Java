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

    /**
     * Menu contenente le scelte che può fare l'utente.
     */
    private final Menu menu;

    /**
     * Metodo costruttore.
     *
     * @param board la tavola da gioco.
     */
    public TextualRappresentation(GameBoard board) {
        menu = new Menu(false);

        //Aggiunta dei menu
        menu.addMenu(new ShowGridOption(board));
        menu.addMenu(new MovePlayersOption(board));
        menu.addMenu(new ExitOption(board));
        menu.addMenu(new ShowPlayersOption(board));
    }

    /**
     * Richiesta all'utente della prossima scelta che vuole fare.
     */
    public void ask(){
        menu.ask();
    }
}
