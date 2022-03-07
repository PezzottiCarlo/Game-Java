package GameEngine;

import General.*;
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

    /**
     * Array contenente tutti i giocatori.
     */
    private final Player[] players;

    /**
     * Array contenente tutte le monete.
     */
    private final Coin[] coins;

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
     * @param sizeX Colonne della tavola da gioco.
     * @param sizeY Righe della tavola da gioco.
     * @param gameBoard Interfaccia tavola da gioco.
     */
    public GameLogic(int sizeX, int sizeY, GameLogicInterface gameBoard) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.gameBoard = gameBoard;
        players = new Player[NUMBER_OF_PLAYERS];
        coins = new Coin[NUMBER_OF_COINS];
        generatePlayers();
        generateCoins();
        options = new TextualRappresentation(this);
    }

    /**
     * Metodo per generare i giocatori.
     */
    private void generatePlayers() {
        players[0] = new Player(
                new Point(0, 0),
                "Player0",
                'X',
                new Color(Color.ANSI_BLUE));

        players[1] = new Player(
                new Point(sizeX - 1, sizeY - 1),
                "Player1",
                'Y',
                new Color(Color.ANSI_GREEN));
        /*
         * int start = 58;
         * for(int i = 0; i < players.length; i++){
         * players[i] = new Player(
         * new Point(i * gameBoard.getSizeX() - 1, i * gameBoard.getSizeY() - 1),
         * "Player" + i,
         * (char)(start + i)
         * );
         * }
         */
    }

    /**
     * Metodo che genera e posiziona in ordine casuale le monete.
     */
    private void generateCoins() {
        int x;
        int y;
        boolean isOkay;
        for (int i = 0; i < coins.length;) {
            x = Util.getRandomNumber(0, sizeX - 1);
            y = Util.getRandomNumber(0, sizeY - 1);
            isOkay = true;

            if (x != 0 && y != 0) {
                for (Coin coin : coins) {
                    if (coin != null) {
                        if (x == coin.getXPosition() && y == coin.getYPosition()) {
                            isOkay = false;
                        }
                    }
                }
                if (isOkay) {
                    coins[i] = new Coin(x, y);
                    i++;
                }
            }
        }
    }

    /**
     * Chiede al menu di stampare le opzioni.
     */
    public void showOptions() {
        options.ask();
    }

    /**
     * Metodo getter per i giocatori.
     *
     * @return Array di giocatori.
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Metodo getter per le monete.
     *
     * @return Array di monete.
     */
    public Coin[] getCoins() {
        return coins;
    }


    /**
     * Permette di spostare un giocatore di una sola casella.
     *
     * @param index Indice del giocatore.
     * @param direction Direzione in cui si vuole spostare.
     */
    public void movePlayer(int index, Direction direction) {
        int x = players[index].getXPosition();
        int y = players[index].getYPosition();
        switch (direction) {
            case NORTH -> players[index].setYPosition(checkPosition(--y, sizeY));
            case SOUTH -> players[index].setYPosition(checkPosition(++y, sizeY));
            case EAST -> players[index].setXPosition(checkPosition(++x, sizeX));
            case WEST -> players[index].setXPosition(checkPosition(--x, sizeX));
        }
        checkCoins(index);
        checkPlayers(index);
    }

    /**
     * Controlla se su un determinato index è presente una moneta.
     *
     * @param index Index che si vuole controllare.
     */
    private void checkCoins(int index) {
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] != null) {
                if (players[index].getPosition().equals(coins[i].getPosition())) {
                    coins[i] = null;
                    players[index].incrementCoins();
                    if (players[index].getCoins() == coins.length) {
                        gameOver();
                    }
                }
            }
        }
    }

    /**
     * Controllo se due giocatori si trovano sulla stessa casella.
     *
     * @param index Index che si vuole controllare.
     */
    private void checkPlayers(int index) {
        for (int i = 0; i < players.length; i++) {
            if (index != i) {
                if (players[i].getPosition().equals(players[index].getPosition())) {
                    System.out.println("There is a match!!!");
                    System.out.print(players[index].getUsername() + " --> ");
                    int a = Dice.throwDice();
                    System.out.print(players[i].getUsername() + " --> ");
                    int b = Dice.throwDice();

                    if (a > b) {

                        if (players[i].getCoins() == 0) {
                            System.out.println(players[index].getUsername() + " wins the game!!");
                            gameOver();
                        } else {
                            players[index].incrementCoins();
                            players[i].decrementCoins();
                            System.out.println(players[index].getUsername() + " wins the match!!");
                        }
                    } else if (a < b) {
                        if (players[index].getCoins() == 0) {
                            System.out.println(players[index].getUsername() + " wins the game!!");
                            gameOver();
                        } else {
                            players[i].incrementCoins();
                            players[index].decrementCoins();
                            System.out.println(players[i].getUsername() + " wins the match!!");
                        }
                    }

                    System.out.println(players[i].getUsername() + "'s coins " + players[i].getCoins());
                    System.out.println(players[index].getUsername() + "'s coins " + players[index].getCoins());
                }
            }
        }
    }


    /**
     * Controllo se un numero oltrepassa un altro numero, usato per fare l'effetto 'Pacman'.
     *
     * @param n Numero che si vuole controllare.
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
}
