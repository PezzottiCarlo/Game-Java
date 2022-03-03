package Menu;

import java.util.List;

import GameEngine.GameLogic;
import GameEngine.Partita;
import General.Direction;
import GameObjects.Player;

public class MovePlayersOption extends Option {

    public MovePlayersOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice) {
        Player[] players = logic.getPlayers();
        int direction = 0;
        for (int i = 0; i < players.length;) {
            System.out.print("Move "+ players[i].getUsername()+ " (N,S,E,W)[1,2,3,4]: ");
            direction = Menu.scanner.nextInt();
            if(direction >= 1 && direction <= 4){
                //MUOVERE GIOCATORE
                logic.moovePlayer(i, Direction.values()[direction-1]);
                i++;
            }else{
                System.out.println("Direzione inserita non valida, riprovare");
                Menu.scanner.nextLine();
            }
        }
    }

    @Override
    public String toString() {
        return "Move players";
    }
}
