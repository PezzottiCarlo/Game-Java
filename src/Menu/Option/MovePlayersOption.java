package Menu.Option;

import GameEngine.GameLogic;
import GameObjects.Dice;
import GameObjects.GameObject;
import GameObjects.Player;
import General.Direction;
import Menu.Menu;

public class MovePlayersOption extends Option {

    public MovePlayersOption(GameLogic logic) {
        super(logic);
    }

    @Override
    public void execute(int choice) {
        for (GameObject gameObject : logic.getGameObjects()) {
            if (gameObject instanceof Player) {
                int movement = Dice.throwDice();
                Menu menu = new Menu(true);
                GenericOption north = new GenericOption("U", (n) -> logic.movePlayer((Player)gameObject, Direction.NORTH));
                GenericOption south = new GenericOption("D", (n) -> logic.movePlayer((Player)gameObject, Direction.SOUTH));
                GenericOption east = new GenericOption("R", (n) -> logic.movePlayer((Player)gameObject, Direction.EAST));
                GenericOption west = new GenericOption("L", (n) -> logic.movePlayer((Player)gameObject, Direction.WEST));
                menu.addMenu(north);
                menu.addMenu(south);
                menu.addMenu(east);
                menu.addMenu(west);
                for (int j = 0; j < movement; j++) menu.ask();
            }
        }
    }

    @Override
    public String toString() {
        return "Move players";
    }
}
