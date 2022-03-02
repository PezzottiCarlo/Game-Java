package Menu;

import GameEngine.Partita;

public class ShowGridOption extends Option{

    public ShowGridOption(Partita partita) {
        super(partita);
    }

    @Override
    public void execute(int choice) {
        partita.getGameBoard().displayGrid();
    }

    @Override
    public String toString() {
        return "Show grid";
    }
}