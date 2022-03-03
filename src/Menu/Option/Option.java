package Menu.Option;

import GameEngine.GameLogic;

public class Option implements IOption {

    GameLogic logic;

    public Option(GameLogic logic) {
        this.logic = logic;
    }   
    public Option() {}

    @Override
    public void execute(int choice) {}
}
