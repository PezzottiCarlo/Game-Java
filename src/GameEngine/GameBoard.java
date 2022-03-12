package GameEngine;
import GameObjects.GameObject;
import General.Color;
import General.Point;
import General.Util;

/**
 * Game Board.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class GameBoard{

    //==================== Attributes ===================
    /**
     * Default game board's rows.
     */
    public static final int DEFAULT_ROWS = 10;

    /**
     * Default game board's columns.
     */
    public static final int DEFAULT_COLUMNS = 10;

    /**
     * Logic of the game.
     */
    private final GameLogic gameLogic;

    /**
     * Game Board columns.
     */
    private int boardSizeX = DEFAULT_COLUMNS;

    /**
     * Game board rows.
     */
    private int boardSizeY = DEFAULT_ROWS;

    /**
     * Textual rappresentation of the options.
     */
    private final TextualRappresentation options;

    // ==================== Constructors ====================
    /**
     * Constructor.
     * @param sizeX Game board columns.
     * @param sizeY Game board rows.
     */
    public GameBoard(int sizeX, int sizeY){
        gameLogic = new GameLogic(sizeX, sizeY);
        if(sizeX > 0 && sizeY > 0){
            this.boardSizeX = sizeX;
            this.boardSizeY = sizeY;
        }
        options = new TextualRappresentation(this);
    }

    /**
     * Default constructor. The number of rows and columns are set to default values.
     */
    public GameBoard(){
        this(DEFAULT_COLUMNS, DEFAULT_ROWS);
    }


    // ==================== Getters and Setters ====================

    /**
     * Get the logic of the game.
     *
     * @return The logic of the game.
     */
    public GameLogic getGameLogic() {
        return gameLogic;
    }

    //==================== private methods ====================

    /**
     * Given a point, return the character rappresentation of the cell.
     *
     * @param point Point to check.
     * @return Character rappresentation of the cell.
     */
    private String getCellChar(Point point){
        for(GameObject gameObject : gameLogic.getGameObjects()){
            if(gameObject.getPosition().equals(point)){
                return gameObject.getColor()+""+gameObject.getCharacter()+Color.ANSI_RESET;
            }
        }
        return " ";
    }

    //==================== public methods ====================

    /**
     * Show the game board on the terminal.
     */
    public void show(){
        Util.clearScreen();
        for(int i = 0; i < boardSizeY*6+1; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0; i < boardSizeX; i++){
            System.out.print("|  ");
            for(int j = 0; j < boardSizeX; j++) {
                System.out.print(getCellChar(new Point(j, i)));
                System.out.print("  |  ");
            }
            System.out.println();
            for(int j = 0; j < boardSizeY*6+1; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    /**
     * Show the options on the terminal.
     */
    public void showOptions(){
        options.ask();
    }

    /**
     * Check if the game is over.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver(){
        return gameLogic.isGameOver();
    }

}