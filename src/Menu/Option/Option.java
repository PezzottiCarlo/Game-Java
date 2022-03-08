package Menu.Option;

import GameEngine.GameBoard;

public class Option implements IOption {

    GameBoard board;

    public Option(GameBoard board) {
        this.board = board;
    }   
    public Option() {}

    @Override
    public void execute(int choice) {}
}
