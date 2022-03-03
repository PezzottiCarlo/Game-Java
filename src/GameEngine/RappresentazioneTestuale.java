package GameEngine;
import Menu.*;

public class RappresentazioneTestuale {

    Menu menu;
    private boolean gameIsOver = false;

    public RappresentazioneTestuale(Partita p) {
        menu = new Menu();
        menu.addMenu(new ShowGridOption(p));
        menu.addMenu(new MovePlayersOption(p));
        menu.addMenu(new ExitOption(p));
        menu.addMenu(new ShowPlayersOption(p));
    }

    public void ask(){
        menu.ask();
    }
}
