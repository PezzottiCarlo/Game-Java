package gameEngine;
import general.*;
import gameObjects.*;

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
    public static final int DEFAULT_ROWS = 15;

    /**
     * Default game board's columns.
     */
    public static final int DEFAULT_COLUMNS = 15;

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
    public GameBoard(int sizeX, int sizeY, boolean useEmoji){
        gameLogic = new GameLogic(sizeX, sizeY, useEmoji);
        if(sizeX > 0 && sizeY > 0){
            this.boardSizeX = sizeX;
            this.boardSizeY = sizeY;
        }
        options = new TextualRappresentation(this);
    }

    /**
     * Default constructor. The number of rows and columns are set to default values.
     */
    public GameBoard(boolean useEmoji){
        this(DEFAULT_COLUMNS, DEFAULT_ROWS, useEmoji);
    }

    public GameBoard(){
        this(DEFAULT_COLUMNS, DEFAULT_ROWS, false);
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
        return "  ";
    }

    //==================== public methods ====================

    /**
     * Show the game board on the terminal.
     */
    public void show(){
        Util.clearScreen();
        for(int i = 0; i < boardSizeY*7+1; i++){
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
            for(int j = 0; j < boardSizeY*7+1; j++){
                System.out.print("-");
            }
            System.out.println();
        }

        //Print players info 
        for(GameObject gameObject : getGameLogic().getGameObjects()){
            if(gameObject instanceof Player){
                Player p = (Player) gameObject;
                System.out.print(p.getColor()+""+p.getCharacter()+Color.ANSI_RESET+"\t");
                System.out.print(Coin.COIN_COLOR+""+Coin.COIN_CHARACTER+p.getCoins()+Color.ANSI_RESET+"\t");
                System.out.print(Gem.GEM_COLOR+""+Gem.GEM_CHARACTER+" "+p.getGems()+Color.ANSI_RESET+"\t");
                System.out.print(Potion.POTION_COLOR+""+Potion.POTION_CHARACTER+" "+p.getPotions()+Color.ANSI_RESET+"\t");
                System.out.println();
            }
        }
        System.out.println();
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