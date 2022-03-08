package Menu.Option;

import GameEngine.GameBoard;

public class ShowGridOption extends Option{

    public ShowGridOption(GameBoard board) {
        super(board);
    }

    @Override
    public void execute(int choice){
        board.show();
    }

    @Override
    public String toString() {
        return "Show grid";
    }
}