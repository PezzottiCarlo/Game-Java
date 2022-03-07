package GameEngine;

import General.*;

import java.util.ArrayList;
import java.util.List;

import GameObjects.*;

/**
 * Logica del gioco.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class GameLogic {

    /**
     * Numero di default per le monete.
     */
    public static final int NUMBER_OF_COINS = 10;

    /**
     * Numero default di giocatori.
     */
    public static final int NUMBER_OF_PLAYERS = 2;

    /**
     * Flag per capire quando il gioco è finito.
     */
    private boolean gameOver = false;

    private List<GameObject> gameObjects;

    /**
     * Rappresentazione testuale delle opzioni.
     */
    private final TextualRappresentation options;

    /**
     * Colonne della tavola da gioco.
     */
    private final int sizeX;

    /**
     * Righe della tavola da gioco.
     */
    private final int sizeY;

    /**
     * Logica legata al gioco.
     */
    private final GameLogicInterface gameBoard;

    /**
     * Metodo costruttore.
     *
     * @param sizeX     Colonne della tavola da gioco.
     * @param sizeY     Righe della tavola da gioco.
     * @param gameBoard Interfaccia tavola da gioco.
     */
    public GameLogic(int sizeX, int sizeY, GameLogicInterface gameBoard) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.gameBoard = gameBoard;
        gameObjects = new ArrayList<>();
        generatePlayers();
        generateCoins();
        options = new TextualRappresentation(this);
    }

    /**
     * Metodo per generare i giocatori.
     */
    private void generatePlayers() {
        gameObjects.add(new Player(
                new Point(0, 0),
                "Player0",
                'X'));

        gameObjects.add(new Player(
                new Point(sizeX - 1, sizeY - 1),
                "Player1",
                'Y'));
    }

    /**
     * Metodo che genera e posiziona in ordine casuale le monete.
     */
    private void generateCoins() {
        for (int i = 0; i < NUMBER_OF_COINS; i++)
            gameObjects.add(new Coin(getRandomFreeCell()));
    }

    private Point getRandomFreeCell() {
        int x =0;
        int y =0;
        do {
            x = (int) (Math.random() * sizeX);
            y = (int) (Math.random() * sizeY);
        } while (!isFreeCell(new Point(x, y)));
        return new Point(x, y);
    }

    private boolean isFreeCell(Point point) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getPosition().equals(point))
                return false;
        }
        return true;
    }

    /**
     * Chiede al menu di stampare le opzioni.
     */
    public void showOptions() {
        options.ask();
    }

    /**
     * Permette di spostare un giocatore di una sola casella.
     *
     * @param index     Indice del giocatore.
     * @param direction Direzione in cui si vuole spostare.
     */
    public void movePlayer(Player player, Direction direction) {
        int x = player.getXPosition();
        int y = player.getYPosition();
        switch (direction) {
            case NORTH -> player.setYPosition(checkPosition(--y, sizeY));
            case SOUTH -> player.setYPosition(checkPosition(++y, sizeY));
            case EAST -> player.setXPosition(checkPosition(++x, sizeX));
            case WEST -> player.setXPosition(checkPosition(--x, sizeX));
        }
        checkCoins(player);
        checkPlayers(player);
    }

    /**
     * Controlla se su un determinato index è presente una moneta.
     *
     * @param index Index che si vuole controllare.
     */
    private void checkCoins(Player player) {
        boolean found = false;
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Coin) {
                found = true;
                if (player.getPosition().equals(gameObject.getPosition())) {
                    gameObject = null;
                    player.incrementCoins();
                }
            }
        }
        if (!found)
            gameOver();
    }

    /**
     * Controllo se due giocatori si trovano sulla stessa casella.
     *
     * @param index Index che si vuole controllare.
     */

    private void checkPlayers(Player player) {
        boolean found = false;
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Player) {
                if (!gameObject.equals(player)) {
                    if (player.getPosition().equals(gameObject.getPosition())) {
                        fight(player, (Player) gameObject);
                    }
                }
            }
        }
    }

    private void fight(Player player1, Player player2) {
        int a = Dice.throwDice();
        int b = Dice.throwDice();
        if (a > b) {
            if (player1.getCoins() == 0) {
                System.out.println(player2.getUsername() + " wins the game!!");
                gameOver();
            } else {
                player2.incrementCoins();
                player1.decrementCoins();
                System.out.println(player2.getUsername() + " wins the match!!");
            }
        } else if (a < b) {
            if (player2.getCoins() == 0) {
                System.out.println(player2.getUsername() + " wins the game!!");
                gameOver();
            } else {
                player1.incrementCoins();
                player2.decrementCoins();
                System.out.println(player1.getUsername() + " wins the match!!");
            }
        }
    }

    /**
     * Controllo se un numero oltrepassa un altro numero, usato per fare l'effetto
     * 'Pacman'.
     *
     * @param n    Numero che si vuole controllare.
     * @param size Dimensione che non si vuole oltrepassare.
     * @return Il nuovo numero (lo stesso se andava già bene).
     */
    private int checkPosition(int n, int size) {
        if (n >= 0)
            return n % size;
        else
            return size + n % size;
    }

    /**
     * Imposta il gioco come finito.
     */
    public void gameOver() {
        gameOver = true;
    }

    /**
     * Dice alla tavola da gioco di stamparsi.
     */
    public void showGrid() {
        gameBoard.showGrid();
    }

    /**
     * Permette di sapere se il gioco è finito oppure no.
     *
     * @return true se il gioco è finito, altrimenti false.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
