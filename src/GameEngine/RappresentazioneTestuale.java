package GameEngine;
import Menu.*;

public class RappresentazioneTestuale {

    Menu menu;

    public RappresentazioneTestuale() {
        menu = new Menu();
        menu.addMenu(new ShowGridMenu());
        menu.addMenu(new ShowPlayersMenu());
        menu.addMenu(new ExitMenu());
    }

    public void ask(){
        menu.ask();
    }
}
