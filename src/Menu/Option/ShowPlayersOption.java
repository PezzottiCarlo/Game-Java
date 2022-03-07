package Menu.Option;

import GameEngine.GameLogic;
import GameObjects.Player;

public class ShowPlayersOption extends Option {

    public ShowPlayersOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice){
        Player[] players = logic.getPlayers();
        for (Player player : players) {
            System.out.println(player);
        }
    }

    @Override
    public String toString() {
        return "Show players";
    }
    
}
