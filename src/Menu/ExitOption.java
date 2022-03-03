package Menu;
import GameEngine.Partita;

public class ExitOption extends Option {
    private Partita p;

    public ExitOption(Partita p){
        this.p = p;
    }
    @Override
    public void execute(int choice) {
        System.out.println("Thanks for playing!");
        p.gameOver();
    }
    @Override
    public String toString() {
        return "Exit";
    }
}
