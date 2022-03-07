package Menu.Option;

import GameEngine.GameLogic;
import GameObjects.Dice;
import GameObjects.Player;
import General.Direction;
import Menu.Menu;

public class MovePlayersOption extends Option {

    public MovePlayersOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice) {
        Player[] players = logic.getPlayers();
        
        for (int i = 0; i < players.length; i++) {
            int movement = Dice.throwDice();
            System.out.println("Player " +players[i].getUsername() + ": ");
            int indexPlayer = i;
            Menu menu = new Menu(true);
            GenericOption north = new GenericOption("North", (n) -> logic.movePlayer(indexPlayer, Direction.NORTH));
            GenericOption south = new GenericOption("South", (n) -> logic.movePlayer(indexPlayer, Direction.SOUTH));
            GenericOption east = new GenericOption("East", (n) -> logic.movePlayer(indexPlayer, Direction.EAST));
            GenericOption west = new GenericOption("West", (n) -> logic.movePlayer(indexPlayer, Direction.WEST));
            menu.addMenu(north);
            menu.addMenu(south);
            menu.addMenu(east);
            menu.addMenu(west);
            for(int j = 0; j < movement; j++) menu.ask();
        }
    }

    @Override
    public String toString() {
        return "Move players";
    }
}
