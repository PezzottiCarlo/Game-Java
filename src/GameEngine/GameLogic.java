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
    private GameBoard gameBoard;
    private Player[] players;
    private Coin[] coins;
    private TextualRappresentation options;


    public GameLogic(int sizeX, int sizeY){
        gameBoard = new GameBoard(sizeX, sizeY);
        players = new Player[NUMBER_OF_PLAYERS];
        coins = new Coin[NUMBER_OF_COINS];
        generatePlayers();
        generateCoins();
        gameBoard.setCoins(coins);
        gameBoard.setPlayers(players);
        options = new TextualRappresentation(this);
    }

    private void generatePlayers(){
        players[0] = new Player(
                new Point(0,0),
                "Player0",
                'X'
        );

        players[1] = new Player(
                new Point(gameBoard.getSizeX() - 1, gameBoard.getSizeY() - 1),
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
        boolean isOkay = true;
        int x = 0;
        int y = 0;
        for(int i = 0; i < coins.length;){
            x = Util.getRandomNumber(0, gameBoard.getSizeX() - 1);
            y = Util.getRandomNumber(0, gameBoard.getSizeY() - 1);
            isOkay = true;

            if(x != 0 && y != 0){
                for(int j = 0; j < coins.length; j++){
                    if(coins[j] != null){
                        if(x == coins[j].getXPosition() && y == coins[j].getYPosition()){
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

    public void showGrid(){
        gameBoard.show();
    }

    public void showOptions(){
        options.ask();
    }

    public GameBoard getGameBoard(){
        return gameBoard;
    }

    public Player[] getPlayers(){
        return players;
    }

    private int throwDice(){
        int moovement = 0;
        System.out.print("Dice result: ");
        long start = System.currentTimeMillis();
        long end = 0l;
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
        int x = players[index].getXPosition();
        int y = players[index].getYPosition();
        for(int i = 0; i < moovement; i++){
            switch (direction){
                case NORTH:
                    players[index].setYPosition(checkPosition(y--, gameBoard.getSizeY()));
                    break;
                case SOUTH:
                    players[index].setYPosition(checkPosition(y++, gameBoard.getSizeY()));
                    break;
                case EAST:
                    players[index].setXPosition(checkPosition(x--, gameBoard.getSizeX()));
                    break;
                case WEST:
                    players[index].setXPosition(checkPosition(x++, gameBoard.getSizeX()));
                    break;
            }
            checkCoins(index, players[index].getXPosition(), players[index].getYPosition());
        }
    }

    private void checkCoins(int index, int x, int y){
        Point position = new Point(x,y);
        for(int i = 0; i < coins.length; i++){
            if(coins[i] != null){
                if(position.equals(coins[i].getPosition())){
                    coins[i] = null;
                    players[index].incrementCoins();
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

    public boolean isGameOver(){
        return gameOver;
    }



/*
    private int sizeX;
    private int sizeY;
    private List<GameObject> gameObjects;

    public GameLogic(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.gameObjects = new ArrayList<>();
    }

    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }

    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }

    public void fight(Player g1, Player g2) {
        int g1Score = Dice.throwIt();
        int g2Score = Dice.throwIt();
        if (g1Score > g2Score) {
            g1.incrementCoins();
            g2.decrementCoins();
        } else {
            g1.decrementCoins();
            g2.incrementCoins();
        }
    }

    public Player getWinner() {
        int maxCoin = 0;
        Player winner = null;
        for (Player g : getGiocatori()) {
            if (g.getCoins() > maxCoin) {
                maxCoin = g.getCoins();
                winner = g;
            }
        }
        return winner;
    }

    public List<Player> getGiocatori() {
        List<Player> giocatori = new ArrayList<>();
        for (GameObject gameObject : this.gameObjects) {
            if (gameObject instanceof Player) {
                giocatori.add((Player) gameObject);
            }
        }
        return giocatori;
    }

    public void update(Player g, Direction direction, int moovement) {
        switch (direction) {
            case NORTH:
                g.setYPosition(checkPosition(g.getPosition().getY() - moovement, sizeY));
                break;
            case SOUTH:
                g.setYPosition(checkPosition(g.getPosition().getY() + moovement, sizeY));
                break;
            case EAST:
                g.setXPosition(checkPosition(g.getPosition().getX() + moovement, sizeX));
                break;
            case WEST:
                g.setXPosition(checkPosition(g.getPosition().getX() - moovement, sizeX));
                break;
        }
        GameObject obj = onObject(g.getPosition(),g);
        if (obj != null) {
            //toDo: implementare bene il metodo over tipo tramite una interface (non ho voglia mo)
            ((Coin) obj).over(g);
            removeGameObject(obj);
        }
    }

    private void move(Player g, Point nextPoint) {
      //  if (!checkCollision(nextPoint)) {
        g.setPosition(nextPoint);
    //    }
    }

/*    private boolean checkCollision(Point nextPoint) {
        for (GameObject gameObject : this.gameObjects) {
            if (gameObject.getPosition().equals(nextPoint)) {
                return gameObject.isCollision();
            }
        }
        return false;
    }

    private int checkPosition(int n, int size) {
        if (n >= 0)
            return n % size;
        else
            return size + n % size;
    }

    private GameObject onObject(Point coordinate, GameObject currentGameObj) {
        for (GameObject gameObject : this.gameObjects) {
            if (!gameObject.equals(currentGameObj)) {
                if (gameObject.getPosition().equals(coordinate)) {
                    return gameObject;
                }
            }
        }
        return null;
    }

 */
}
