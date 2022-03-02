package GameEngine;
import General.Point;
import OggettiGioco.GameObject;

class TavoloDaGioco{

    private int gameSizeX;
    private int gameSizeY;
    private LogicaDiGioco logicaDiGioco;

    public TavoloDaGioco(int sizeX, int sizeY){
        setGameSize(sizeX, sizeY);
        this.logicaDiGioco = new LogicaDiGioco(sizeX, sizeY);
    }

    private void setGameSize(int sizeX, int sizeY){
        if(sizeX > 0 && sizeY > 0){
            this.gameSizeX = sizeX;
            this.gameSizeY = sizeY;
        }
    }

    public void displayGrid(){
        for(int i = 0; i < gameSizeX*6+1; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0; i < gameSizeY; i++){
            System.out.print("|  ");
            for(int j = 0; j < gameSizeX; j++){
                System.out.print(getCellChar(new Point(j, i)));
                System.out.print("  |  ");
            }
            System.out.println();
            for(int j = 0; j < gameSizeX*6+1; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public char getCellChar(Point point){
        for(GameObject gameObject : logicaDiGioco.getGameObjects()){
            if(gameObject.getCoordinate().equals(point)){
                return gameObject.getCharacter();
            }
        }
        return ' ';
    }

    public LogicaDiGioco getLogicaDiGioco() {
        return logicaDiGioco;
    }
}