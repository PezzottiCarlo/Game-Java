package Menu;

import GameEngine.GameLogic;
import GameEngine.Partita;
import GameObjects.Player;

public class ShowPlayersOption extends Option {

    public ShowPlayersOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice) {
        for(Player g : logic.getGameBoard().getLogicaDiGioco().getGiocatori()){
            System.out.println(g);
        }
    }

    @Override
    public String toString() {
        return "Show players";
    }
    
}
