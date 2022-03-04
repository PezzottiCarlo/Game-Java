package GameEngine;
import GameObjects.Coin;
import GameObjects.Player;
import General.Point;

public class GameBoard{

    private int boardSizeX = GameLogic.COLUMNS;
    private int boardSizeY = GameLogic.ROWS;
    private Player[] players;
    private Coin[] coins;

    public GameBoard(int sizeX, int sizeY){
        if(sizeX > 0 && sizeY > 0){
            this.boardSizeX = sizeX;
            this.boardSizeY = sizeY;
        }
    }

    public void setPlayers(Player[] players){
        this.players = players;
    }

    public void setCoins(Coin[] coins){
        this.coins = coins;
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

    public char getCellChar(Point point){
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

    public int getSizeX(){
        return boardSizeX;
    }

    public int getSizeY(){
        return boardSizeY;
    }

}