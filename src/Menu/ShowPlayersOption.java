package Menu;

import GameEngine.Partita;
import OggettiGioco.Giocatore;

public class ShowPlayersOption extends Option {

    public ShowPlayersOption(Partita partita) {
        super(partita);
    }

    @Override
    public void execute(int choice) {
        for(Giocatore g : partita.getGameBoard().getLogicaDiGioco().getGiocatori()){
            System.out.println(g);
        }
    }

    @Override
    public String toString() {
        return "Show players";
    }
    
}
