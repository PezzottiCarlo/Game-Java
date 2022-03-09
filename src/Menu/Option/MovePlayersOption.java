package Menu.Option;

import GameEngine.GameBoard;
import GameEngine.GameLogic;
import GameObjects.Dice;
import GameObjects.GameObject;
import GameObjects.Player;
import General.Direction;
import Menu.Menu;

/**
 * This class represents the option to move players.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class MovePlayersOption extends Option {

        // ==================== Constructors ====================

        /**
         * Constructor for MovePlayersOption.
         *
         * @param board the board.
         */
        public MovePlayersOption(GameBoard board) {
                super(board);
        }
        // ==================== public methods ====================

        /**
         * The code to execute when this option is chosen (it moves a player).
         *
         * @param choice the choice.
         */
        @Override
        public void execute(int choice) {
                System.out.print(board.getGameLogic().getCurrentPlayer().getUsername() + " roll the dice: ");
                int movement = Dice.throwDice();
                Menu menu = new Menu(true);
                GenericOption north = new GenericOption("U",
                                (n) -> board.getGameLogic().movePlayer((Player) board.getGameLogic().getCurrentPlayer(),
                                                Direction.NORTH));
                GenericOption south = new GenericOption("D",
                                (n) -> board.getGameLogic().movePlayer((Player) board.getGameLogic().getCurrentPlayer(),
                                                Direction.SOUTH));
                GenericOption east = new GenericOption("R",
                                (n) -> board.getGameLogic().movePlayer((Player) board.getGameLogic().getCurrentPlayer(),
                                                Direction.EAST));
                GenericOption west = new GenericOption("L",
                                (n) -> board.getGameLogic().movePlayer((Player) board.getGameLogic().getCurrentPlayer(),
                                                Direction.WEST));
                menu.addMenu(north);
                menu.addMenu(south);
                menu.addMenu(east);
                menu.addMenu(west);
                for (int j = 0; j < movement; j++)
                        menu.ask();

                board.getGameLogic().nextTurn();
        }

        /**
         * Returns the name of this option.
         *
         * @return the name of this option.
         */
        @Override
        public String toString() {
                return "Move players";
        }
}
