package Menu;

import GameEngine.Partita;
import GameObjects.Player;

public class ShowPlayersOption extends Option {

    public ShowPlayersOption(Partita partita) {
        super(partita);
    }

    @Override
    public void execute(int choice) {
        for(Player g : partita.getGameBoard().getLogicaDiGioco().getGiocatori()){
            System.out.println(g);
        }
    }

    @Override
    public String toString() {
        return "Show players";
    }
    
}
