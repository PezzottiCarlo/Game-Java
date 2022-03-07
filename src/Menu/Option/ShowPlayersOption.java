package Menu.Option;

import GameEngine.GameLogic;
import GameObjects.*;

public class ShowPlayersOption extends Option {

    public ShowPlayersOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice){
        for (GameObject gameObject : logic.getGameObjects()) {
            if (gameObject instanceof Player) {
                System.out.println(gameObject.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Show players";
    }
    
}
