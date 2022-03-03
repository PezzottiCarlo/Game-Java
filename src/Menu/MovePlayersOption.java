package Menu;

import java.util.List;

import GameEngine.Partita;
import General.Direction;
import GameObjects.Player;

public class MovePlayersOption extends Option {

    public MovePlayersOption(Partita partita) {
        super(partita);
    }

    @Override
    public void execute(int choice) {
        List<Player> giocatori = partita.getGameBoard().getLogicaDiGioco().getGiocatori();
        int move = 0;
        for (Player giocatore : giocatori) {
            while(move < 1 || move > 4){
                System.out.print("Move "+giocatore.getUsername()+" (N,S,E,W)[1,2,3,4]: ");
                move = Menu.scanner.nextInt();
                Menu.scanner.nextLine();
            }
            partita.movePlayer(giocatore, Direction.values()[move-1]);
        }
    }

    @Override
    public String toString() {
        return "Move players";
    }
}
