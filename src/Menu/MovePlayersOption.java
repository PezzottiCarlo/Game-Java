package Menu;

import java.util.List;

import GameEngine.Partita;
import General.Direction;
import OggettiGioco.Giocatore;

public class MovePlayersOption extends Option {

    public MovePlayersOption(Partita partita) {
        super(partita);
    }

    @Override
    public void execute(int choice) {
        List<Giocatore> giocatori = partita.getGameBoard().getLogicaDiGioco().getGiocatori();
        for (Giocatore giocatore : giocatori) {
            System.out.print("Move "+giocatore.getUsername()+" (N,S,E,W)[1,2,3,4]: ");
            // ToDo: controllare che sia un numero compreso tra 1 e 4
            int move = Menu.scanner.nextInt();
            partita.movePlayer(giocatore, Direction.values()[move-1]);
        }
    }

    @Override
    public String toString() {
        return "Move players";
    }
}
