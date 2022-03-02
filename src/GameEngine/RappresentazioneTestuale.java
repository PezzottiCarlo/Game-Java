package GameEngine;
import Menu.*;

public class RappresentazioneTestuale {

    Menu menu;

    public RappresentazioneTestuale(Partita p) {
        menu = new Menu();
        menu.addMenu(new ShowGridOption(p));
        menu.addMenu(new MovePlayersOption(p));
        menu.addMenu(new ExitOption());
        menu.addMenu(new ShowPlayersOption(p));
    }

    public void ask(){
        menu.ask();
    }
}
