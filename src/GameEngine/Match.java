package GameEngine;

/**
 * Rappresentazione della partita.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Match {
    private GameBoard gameBoard;

    public Match(int sizeX, int sizeY){
        gameBoard = new GameBoard(sizeX, sizeY);
    }

    public Match(){
        gameBoard = new GameBoard();
    }

    public void play(){
        System.out.println("Let's play!");
        while(!gameBoard.isGameOver()){
            gameBoard.showOptions();
        }
        System.out.println("Thanks for playing");
    }
}
