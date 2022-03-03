package Menu;

import GameEngine.GameLogic;

public class ShowGridOption extends Option{

    public ShowGridOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice) {
        logic.getGameBoard().show();
    }

    @Override
    public String toString() {
        return "Show grid";
    }
}