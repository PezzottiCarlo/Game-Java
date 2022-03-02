package Menu;

import GameEngine.Partita;

public class Option implements OptionInterface {

    Partita partita;

    public Option(Partita partita) {
        this.partita = partita;
    }   
    public Option() {}

    @Override
    public void execute(int choice) {}
}
