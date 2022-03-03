package GameEngine;
import Menu.*;

public class TextualRappresentation {

    Menu menu;
    private boolean gameIsOver = false;

    public TextualRappresentation(GameLogic gameLogic) {
        menu = new Menu();
        menu.addMenu(new ShowGridOption(gameLogic));
        menu.addMenu(new MovePlayersOption(gameLogic));
        menu.addMenu(new ExitOption(gameLogic));
        menu.addMenu(new ShowPlayersOption(gameLogic));
    }

    public void ask(){
        menu.ask();
    }
}
