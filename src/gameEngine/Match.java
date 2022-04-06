package gameEngine;

import gameObjects.Player;
import menu.Menu;
import menu.option.GenericOption;

/**
 * Represents the match.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Match {
    //==================== Attributes ===================

    /**
     * Game Board.
     */
    private final GameBoard gameBoard;
    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param sizeX Board size X.
     * @param sizeY Board size Y.
     * @param useEmoji True if the player wants to use emoji.
     */
    public Match(int sizeX, int sizeY){
        gameBoard = new GameBoard(sizeX, sizeY, useEmoji());
    }

    /**
     * Defaults constructor.
     */
    public Match(){
        gameBoard = new GameBoard(useEmoji());
    }

    //==================== public methods ====================

    /**
     * Method that represent the match.
      */
    public void play(){
        System.out.println("Let's play!");
        while(!gameBoard.isGameOver()){
            System.out.println("\n"+gameBoard.getGameLogic().getCurrentPlayer().getUsername()+"'s turn!");
            gameBoard.showOptions();
        }
        Player winner = gameBoard.getGameLogic().getWinner();
        System.out.println(winner.getUsername()+" won!");
        System.out.println("Thanks for playing");
    }

    //==================== private methods ====================

    private boolean useEmoji(){
        Menu menu = new Menu(false, "Choose");
        GenericOption useEmoji = new GenericOption("Use emoji", 'y',()->{});
        GenericOption dontUseEmoji = new GenericOption("Don't use emoji", 'n',()->{});
        menu.addMenu(useEmoji);
        menu.addMenu(dontUseEmoji);
        return menu.ask()==0;
    }
    
}
