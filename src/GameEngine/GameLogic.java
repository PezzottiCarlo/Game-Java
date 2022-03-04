package GameEngine;

import GameObjects.Dice;
import General.Direction;
import General.Point;
import GameObjects.Player;
import GameObjects.Coin;
import General.Util;


public class GameLogic {

    public static final int NUMBER_OF_COINS = 10;
    public static final int NUMBER_OF_PLAYERS = 2;

    private boolean gameOver = false;
    private final Player[] players;
    private final Coin[] coins;
    private final TextualRappresentation options;
    private final int sizeX;
    private final int sizeY;
    private GameLogicInterface gameBoard;


    public GameLogic(int sizeX, int sizeY, GameLogicInterface gameBoard){
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.gameBoard = gameBoard;
        players = new Player[NUMBER_OF_PLAYERS];
        coins = new Coin[NUMBER_OF_COINS];
        generatePlayers();
        generateCoins();
        options = new TextualRappresentation(this);
    }

    private void generatePlayers(){
        players[0] = new Player(
                new Point(0,0),
                "Player0",
                'X'
        );

        players[1] = new Player(
                new Point(sizeX - 1, sizeY - 1),
                "Player1",
                'Y'
        );
        /*
        int start = 58;
        for(int i = 0; i < players.length; i++){
            players[i] = new Player(
                    new Point(i * gameBoard.getSizeX() - 1, i * gameBoard.getSizeY() - 1),
                    "Player" + i,
                    (char)(start + i)
            );
        }
        */
    }

    private void generateCoins(){
        int x;
        int y;
        boolean isOkay = true;
        for(int i = 0; i < coins.length;){
            x = Util.getRandomNumber(0, sizeX - 1);
            y = Util.getRandomNumber(0, sizeY - 1);
            isOkay = true;

            if(x != 0 && y != 0){
                for (Coin coin : coins) {
                    if (coin != null) {
                        if (x == coin.getXPosition() && y == coin.getYPosition()) {
                            isOkay = false;
                        }
                    }
                }
                if(isOkay){
                    coins[i] = new Coin(x,y);
                    i++;
                }
            }
        }
    }

    public void showOptions(){
        options.ask();
    }

    public Player[] getPlayers(){
        return players;
    }

    public Coin[] getCoins(){
        return coins;
    }

    private int throwDice(){
        int moovement = 0;
        System.out.print("Dice result: ");
        long start = System.currentTimeMillis();
        long end = 0L;
        System.out.print("0");
        while(end - start < 2000){
            end = System.currentTimeMillis();
            moovement = Dice.throwIt();
            System.out.print("\b" + moovement);
        }
        System.out.println("\b" + moovement);
        return moovement;
    }

    public void moovePlayer(int index, Direction direction){
        System.out.println("Move " + players[index].getUsername() + " " + direction);
        int moovement = throwDice();
        int coins = players[index].getCoins();
        int x = players[index].getXPosition();
        int y = players[index].getYPosition();
        for(int i = 0; i <= moovement; i++){
            switch (direction) {
                case NORTH -> players[index].setYPosition(checkPosition(y--, sizeY));
                case SOUTH -> players[index].setYPosition(checkPosition(y++, sizeY));
                case EAST -> players[index].setXPosition(checkPosition(x++, sizeX));
                case WEST -> players[index].setXPosition(checkPosition(x--, sizeX));
            }
            checkCoins(index);
            checkPlayers(index);
        }
        System.out.println("Monete raccolte: " + (players[index].getCoins() - coins));
    }

    private void checkCoins(int index){
        for(int i = 0; i < coins.length; i++){
            if(coins[i] != null){
                if(players[index].getPosition().equals(coins[i].getPosition())){
                    coins[i] = null;
                    players[index].incrementCoins();
                    if(players[index].getCoins() == coins.length){
                        System.out.println(players[i].getUsername() + " has collected all coins! He/She wins");
                        gameOver();
                    }
                }
            }
        }
    }

    private void checkPlayers(int index){
        for(int i = 0; i < players.length; i++){
            if(index != i){
                if(players[i].getPosition().equals(players[index].getPosition())){
                    System.out.println("There is a match!!!");
                    System.out.print(players[index].getUsername() + " --> ");
                    int a = throwDice();
                    System.out.print(players[i].getUsername()+ " --> ");
                    int b = throwDice();

                    if(a > b){

                        if(players[i].getCoins() == 0){
                            System.out.println(players[index].getUsername() + " wins the game!!");
                            gameOver();
                        }else{
                            players[index].incrementCoins();
                            players[i].decrementCoins();
                            System.out.println(players[index].getUsername() + " wins the match!!");
                        }
                    }else if(a < b){
                        if(players[index].getCoins() == 0){
                            System.out.println(players[index].getUsername() + " wins the game!!");
                            gameOver();
                        }else{
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

    private int checkPosition(int n, int size) {
        if (n >= 0)
            return n % size;
        else
            return size + n % size;
    }

    public void gameOver(){
        gameOver = true;
    }
    public void showGrid(){
        gameBoard.showGrid();
    }

    public boolean isGameOver(){
        return gameOver;
    }
}
