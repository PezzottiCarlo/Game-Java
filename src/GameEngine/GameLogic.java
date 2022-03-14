package GameEngine;

import General.*;

import java.util.ArrayList;
import java.util.List;

import GameObjects.*;

/**
 * Logic for the game.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class GameLogic {

    // ==================== Attributes ===================

    /**
     * Default coins number.
     */
    public static final int NUMBER_OF_COINS = 10;

    /**
     * Default number of players.
     */
    public static final int NUMBER_OF_PLAYERS = 2;

    /**
     * Flag true when the game is ended.
     */
    private boolean gameOver = false;

    /**
     * List with all the objects of the game.
     */
    private final List<GameObject> gameObjects;

    /**
     * Board width.
     */
    private final int sizeX;

    /**
     * Board height.
     */
    private final int sizeY;

    /**
     * Current player (the one who is playing).
     */
    private Player currentPlayer;

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param sizeX Board width.
     * @param sizeY Board height.
     */
    public GameLogic(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        gameObjects = new ArrayList<>();
        generatePlayers();
        generateCoins();
    }

    // ==================== Getters and Setters ====================

    /**
     * Get the full list of game objects.
     *
     * @return The list of game objects.
     */
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Get the current player.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner(){
        Player bestPlayer = null;
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Player) {
                if(bestPlayer == null){
                    bestPlayer = (Player) gameObject;
                }else{
                    if(bestPlayer.getCoins() < ((Player) gameObject).getCoins()){
                        bestPlayer = (Player) gameObject;
                    }
                }
            }
        }
        return bestPlayer;
    }

    // ==================== private methods ====================

    /**
     * Method used to generate players.
     */
    private void generatePlayers() {
        currentPlayer = new Player(
            new Point(0, sizeY - 1),
            "Player0",
            'X');
        gameObjects.add(currentPlayer);
        gameObjects.add(new Player(
                new Point(sizeX - 1, 0),
                "Player1",
                'Y'));
    }

    /**
     * Method used to generate coins.
     */
    private void generateCoins() {
        for (int i = 0; i < NUMBER_OF_COINS; i++)
            gameObjects.add(new Coin(getRandomFreeCell()));
    }

    /**
     * Generate a random free cell.
     *
     * @return A random free cell.
     */
    private Point getRandomFreeCell() {
        int x;
        int y;
        do {
            x = (int) (Math.random() * sizeX);
            y = (int) (Math.random() * sizeY);
        } while (!isFreeCell(new Point(x, y)));
        return new Point(x, y);
    }

    /**
     * Check if a cell is free.
     *
     * @param point Cell to check.
     * @return true if the cell is free, false otherwise.
     */
    private boolean isFreeCell(Point point) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getPosition().equals(point))
                return false;
        }
        return true;
    }

    /**
     * Check if the player is on a coin.
     *
     * @param player Player to check.
     */
    private void checkCoins(Player player) {
        boolean found = false;
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Coin) {
                found = true;
                if (player.getPosition().equals(gameObject.getPosition())) {
                    gameObjects.remove(gameObject);
                    player.incrementCoins();
                    break;
                }
            }
        }
        if(gameObjects.size() == NUMBER_OF_PLAYERS && player.getCoins() == NUMBER_OF_COINS){
            gameOver();
        }
    }

    /**
     * Check if the player is on another player.
     *
     * @param player Player to check (the one who is playing).
     */
    private void checkPlayers(Player player) {
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

    /**
     * Fight between two players.
     *
     * @param player1 Player 1.
     * @param player2 Player 2.
     */
    private void fight(Player player1, Player player2) {
        System.out.println("\n" + player1.getUsername() + " vs " + player2.getUsername());
        System.out.print(player1.getUsername()+"'s result: ");
        int a = Dice.throwDice();
        System.out.print(player2.getUsername()+"'s result: ");
        int b = Dice.throwDice();
        if (a > b) {
            if (player1.getCoins() == 0) {
                gameOver();
            } else {
                player2.incrementCoins();
                player1.decrementCoins();
                System.out.println(player2.getUsername() + " wins the match!!");
            }
        } else if (a < b) {
            if (player2.getCoins() == 0) {
                gameOver();
            } else {
                player1.incrementCoins();
                player2.decrementCoins();
                System.out.println(player1.getUsername() + " wins the match!!");
            }
        }
        else {
            System.out.println("Draw!");
            fight(player1, player2);
        }
    }

    /**
     * Method used to check if a number is over another number, used to make the
     * 'Pacman' effect.
     *
     * @param n    Number to check.
     * @param size Size that we don't want to go over.
     * @return The new number (the same if it was already good).
     */
    private int checkPosition(int n, int size) {
        if (n >= 0)
            return n % size;
        else
            return size + n % size;
    }

    // ==================== public methods ====================

    /**
     * Move the player passed as parameter.
     *
     * @param player    Player to move.
     * @param direction Direction to move (North, South, East or West).
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
     * Set the game as over.
     */
    public void gameOver() {
        gameOver = true;
    }

    /**
     * Check if the game is over.
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Play the next turn, showing the available options.
     */
    public void nextTurn() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Player) {
                if (!gameObject.equals(currentPlayer)) {
                    currentPlayer = (Player) gameObject;
                    return;
                }
            }
        }
    }
}
