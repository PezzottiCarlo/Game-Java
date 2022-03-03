package GameEngine;
import General.Point;
import GameObjects.GameObject;

public class GameBoard{

    private int boardSizeX = 10;
    private int boardSizeY = 10;
    private GameLogic logicaDiGioco;

    public GameBoard(int sizeX, int sizeY){
        if(sizeX > 0 && sizeY > 0){
            this.boardSizeX = sizeX;
            this.boardSizeY = sizeY;
        }
        this.logicaDiGioco = new GameLogic(sizeX, sizeY);
    }

    public void show(){
        for(int i = 0; i < boardSizeX*6+1; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0; i < boardSizeY; i++){
            System.out.print("|  ");
            for(int j = 0; j < boardSizeY; j++){
                System.out.print(getCellChar(new Point(j, i)));
                System.out.print("  |  ");
            }
            System.out.println();
            for(int j = 0; j < boardSizeX*6+1; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public char getCellChar(Point point){
        for(GameObject gameObject : logicaDiGioco.getGameObjects()){
            if(gameObject.getPosition().equals(point)){
                return gameObject.getCharacter();
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

    public GameLogic getLogicaDiGioco() {
        return logicaDiGioco;
    }
}