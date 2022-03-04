package GameEngine;
import GameObjects.Coin;
import GameObjects.Player;
import General.Point;

public class GameBoard implements GameLogicInterface{

    public static final int DEFAULT_ROWS = 10;
    public static final int DEFAULT_COLUMNS = 10;

    private GameLogic gameLogic;
    private int boardSizeX = 10;
    private int boardSizeY = 10;

    public GameBoard(int sizeX, int sizeY){
        gameLogic = new GameLogic(sizeX, sizeY, this);
        if(sizeX > 0 && sizeY > 0){
            this.boardSizeX = sizeX;
            this.boardSizeY = sizeY;
        }
    }

    public GameBoard(){
        this(DEFAULT_COLUMNS, DEFAULT_ROWS);
    }

    public void show(){
        for(int i = 0; i < boardSizeY*6+1; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0; i < boardSizeX; i++){
            System.out.print("|  ");
            for(int j = 0; j < boardSizeX; j++){
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

    public void showOptions(){
        gameLogic.showOptions();
    }

    public char getCellChar(Point point){
        Player[] players = gameLogic.getPlayers();
        Coin[] coins = gameLogic.getCoins();


        for(int i = 0; i < players.length; i++){
            if(players[i].getPosition().equals(point)){
                return players[i].getCharacter();
            }
        }

        for(int i = 0; i < coins.length; i++){
            if(coins[i] != null){
                if(coins[i].getPosition().equals(point)){
                    return coins[i].getCharacter();
                }
            }

        }
        return ' ';
    }

    public boolean isGameOver(){
        return gameLogic.isGameOver();
    }

    public int getSizeX(){
        return boardSizeX;
    }

    public int getSizeY(){
        return boardSizeY;
    }

    @Override
    public void showGrid() {
        show();
    }
}