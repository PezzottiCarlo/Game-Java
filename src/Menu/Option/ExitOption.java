package Menu.Option;
import GameEngine.GameBoard;

public class ExitOption extends Option {
    private final GameBoard board;


    public ExitOption(GameBoard board){
        this.board = board;
    }
    @Override
    public void execute(int choice){
        board.getGameLogic().gameOver();
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
