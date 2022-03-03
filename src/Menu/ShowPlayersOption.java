package Menu;

import GameEngine.GameLogic;
import GameObjects.Player;

public class ShowPlayersOption extends Option {

    public ShowPlayersOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice) {
        Player[] players = logic.getPlayers();
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i]);
        }
    }

    @Override
    public String toString() {
        return "Show players";
    }
    
}
