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
     * @param gameLogic Logica del gioco che si vuole giocare.
     */
    public TextualRappresentation(GameLogic gameLogic) {
        menu = new Menu(false);

        //Aggiunta dei menu
        menu.addMenu(new ShowGridOption(gameLogic));
        menu.addMenu(new MovePlayersOption(gameLogic));
        menu.addMenu(new ExitOption(gameLogic));
        menu.addMenu(new ShowPlayersOption(gameLogic));
    }

    /**
     * Richiesta all'utente della prossima scelta che vuole fare.
     */
    public void ask(){
        menu.ask();
    }
}
