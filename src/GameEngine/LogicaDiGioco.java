package GameEngine;

import General.Direction;
import OggettiGioco.Dado;
import OggettiGioco.GameObject;
import OggettiGioco.Giocatore;
import OggettiGioco.Point;
import java.util.ArrayList;
import java.util.List;

public class LogicaDiGioco {

    private int sizeX;
    private int sizeY;
    private List<GameObject> gameObjects;

    public LogicaDiGioco(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.gameObjects = new ArrayList<>();
    }

    public void addGameObject(GameObject gameObject){
        this.gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject){
        this.gameObjects.remove(gameObject);
    }

    public List<GameObject> getGameObjects(){
        return this.gameObjects;
    }

    public void fight(Giocatore g1, Giocatore g2) {
        int g1Score = Dado.throwIt();
        int g2Score = Dado.throwIt();
        if (g1Score > g2Score){
            //aggiungere 1 allo score del primo giocatore e togliere 1 dallo score del secondo
        }else{
            //viceversa
        }
    }

    public Giocatore getWinner(){
        return null;
    }

    public void move(Giocatore giocatore, Point coordinate, Direction direction){
        switch (direction){
            case NORTH :
                break;
            case SOUTH :
                break;
            case EAST :
                break;
            case WEST :
                break;
        }
    }

    private boolean onCoin(Point coordinate){
        return false;
    }
}
