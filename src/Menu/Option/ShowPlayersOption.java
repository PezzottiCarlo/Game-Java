package Menu.Option;

import GameEngine.GameBoard;
import GameObjects.*;

public class ShowPlayersOption extends Option {

    public ShowPlayersOption(GameBoard board) {
        super(board);
    }

    @Override
    public void execute(int choice){
        for (GameObject gameObject : board.getGameLogic().getGameObjects()) {
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
