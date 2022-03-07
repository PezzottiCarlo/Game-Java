package GameEngine;
import GameObjects.Coin;
import GameObjects.GameObject;
import GameObjects.Player;
import General.Color;
import General.Point;

/**
 * Tavola da gioco.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class GameBoard implements GameLogicInterface{

    /**
     * Righe di default della tavola da gioco.
     */
    public static final int DEFAULT_ROWS = 10;

    /**
     * Colonne di default della tavola da gioco.
     */
    public static final int DEFAULT_COLUMNS = 10;

    /**
     * Logica legata al gioco.
     */
    private final GameLogic gameLogic;

    /**
     * Dimensione orizzontale (colonne) della tavola da gioco.
     */
    private int boardSizeX = DEFAULT_COLUMNS;

    /**
     * Dimensione verticale (righe) della tavola da gioco.
     */
    private int boardSizeY = DEFAULT_ROWS;

    /**
     * Metodo costruttore con grandezze della tavola.
     *
     * @param sizeX Colonne della tavola da gioco.
     * @param sizeY Righe della tavola da gioco.
     */
    public GameBoard(int sizeX, int sizeY){
        gameLogic = new GameLogic(sizeX, sizeY, this);
        if(sizeX > 0 && sizeY > 0){
            this.boardSizeX = sizeX;
            this.boardSizeY = sizeY;
        }
    }

    /**
     * Costruttore di default, imposta come grandezza della tavola i valori di default.
     */
    public GameBoard(){
        this(DEFAULT_COLUMNS, DEFAULT_ROWS);
    }

    /**
     * Metodo per mostrare la tavola da gioco su terminale.
     */
    public void show(){
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
     * Permette di mostrare le scelte al giocatore.
     */
    public void showOptions(){
        gameLogic.showOptions();
    }

    /**
     * In base ad un punto (coordinate sulla tavola da gioco) ritorna il carattere che va stampato in quella cella.
     *
     * @param point Punto del quale si vuole sapere il carattere.
     * @return Il carattere da stampare a terminale che rappresenta l'oggetto da stampare.
     */
    public String getCellChar(Point point){
        for(GameObject gameObject : gameLogic.getGameObjects()){
            if(gameObject.getPosition().equals(point)){
                return gameObject.getColor()+""+gameObject.getCharacter()+Color.ANSI_RESET;
            }
        }
        return " ";
    }

    /**
     * Controlla se il gioco è terminato.
     *
     * @return true se il gioco è finito, altrimenti false.
     */
    public boolean isGameOver(){
        return gameLogic.isGameOver();
    }

    /**
     * Metodo richiamato quando bisogna stampare la tavola da gioco.
     */
    @Override
    public void showGrid() {
        show();
    }
}