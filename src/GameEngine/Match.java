package GameEngine;

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
     */
    public Match(int sizeX, int sizeY){
        gameBoard = new GameBoard(sizeX, sizeY);
    }

    /**
     * Defaults constructor.
     */
    public Match(){
        gameBoard = new GameBoard();
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
        System.out.println("Thanks for playing");
    }

    
}
