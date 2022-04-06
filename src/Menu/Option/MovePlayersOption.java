package menu.option;

import gameEngine.GameBoard;
import general.Direction;
import gameObjects.*;
import menu.Menu;

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

	// ==================== private methods ====================
	/**
	 * Method called at the end of each movement
	 * @param movingObj the object into which the player moved or tried to move
	 * @param menu the menu
	 */
	private void moveAction(GameObject movingObj, Menu menu) {
		if (movingObj != null) {
			if (movingObj.getType() == ObjectName.Tree) {
				((Tree) movingObj).hit();
				if (((Tree) movingObj).getHealth() == 0) {
					board.getGameLogic().getGameObjects().remove(movingObj);
				}
			} else {
				board.show();
				menu.ask();
			}
		}
	}

	// ==================== public methods ====================

	/**
	 * The code to execute when this option is chosen (it moves a player).
	 *
	 * @param choice the choice.
	 * 
	 *               todo: add dynamic trees
	 */
	@Override
	public void execute(int choice) {
		System.out.print(board.getGameLogic().getCurrentPlayer().getUsername() + " roll the dice: ");
		int movement = Dice.throwDice();
		Menu menu = new Menu(true);
		GenericOption north = new GenericOption("North", 'w',
				() -> {
					GameObject obj = board.getGameLogic().movePlayer(board.getGameLogic().getCurrentPlayer(),
							Direction.NORTH);
					moveAction(obj, menu);
				});
		GenericOption south = new GenericOption("South", 's',
				() -> {
					GameObject obj = board.getGameLogic().movePlayer(board.getGameLogic().getCurrentPlayer(),
							Direction.SOUTH);
					moveAction(obj, menu);
				});
		GenericOption west = new GenericOption("West", 'a',
				() -> {
					GameObject obj = board.getGameLogic().movePlayer(board.getGameLogic().getCurrentPlayer(),
							Direction.WEST);
					moveAction(obj, menu);
				});
		GenericOption east = new GenericOption("East", 'd',
				() -> {
					GameObject obj = board.getGameLogic().movePlayer(board.getGameLogic().getCurrentPlayer(),
							Direction.EAST);
					moveAction(obj, menu);
				});
		menu.addMenu(north);
		menu.addMenu(south);
		menu.addMenu(west);
		menu.addMenu(east);
		for (int j = 0; j < movement; j++) {
			if (!board.isGameOver()) {
				menu.ask();
				board.show();
			}
		}

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
