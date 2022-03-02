package GameEngine;

import General.Direction;
import General.Point;
import OggettiGioco.Dado;
import OggettiGioco.GameObject;
import OggettiGioco.Giocatore;
import OggettiGioco.Moneta;

import java.util.ArrayList;
import java.util.List;

public class LogicaDiGioco {

    private int sizeX;
    private int sizeY;
    private List<GameObject> gameObjects;

    public LogicaDiGioco(int sizeX, int sizeY) {
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

    public void fight(Giocatore g1, Giocatore g2) {
        int g1Score = Dado.throwIt();
        int g2Score = Dado.throwIt();
        if (g1Score > g2Score) {
            g1.setCoin(g1.getCoin() + 1);
            g2.setCoin(g2.getCoin() - 1);
        } else {
            g1.setCoin(g1.getCoin() - 1);
            g2.setCoin(g2.getCoin() + 1);
        }
    }

    public Giocatore getWinner() {
        int maxCoin = 0;
        Giocatore winner = null;
        for (Giocatore g : getGiocatori()) {
            if (g.getCoin() > maxCoin) {
                maxCoin = g.getCoin();
                winner = g;
            }
        }
        return winner;
    }

    public List<Giocatore> getGiocatori() {
        List<Giocatore> giocatori = new ArrayList<>();
        for (GameObject gameObject : this.gameObjects) {
            if (gameObject instanceof Giocatore) {
                giocatori.add((Giocatore) gameObject);
            }
        }
        return giocatori;
    }

    public void move(Giocatore g, Direction direction) {

        switch (direction) {
            case NORTH:
                g.setCoordinate(new Point(g.getCoordinate().getX(),getCoordNum(g.getCoordinate().getY()-1, sizeY)));
                break;
            case SOUTH:
                g.setCoordinate(new Point(g.getCoordinate().getX(),getCoordNum(g.getCoordinate().getY()+1, sizeY)));
                break;
            case EAST:
                g.setCoordinate(new Point(getCoordNum(g.getCoordinate().getX()+1, sizeX),g.getCoordinate().getY()));
                break;
            case WEST:
                g.setCoordinate(new Point(getCoordNum(g.getCoordinate().getX()-1, sizeX),g.getCoordinate().getY()));
                break;
        }
    }

    private int getCoordNum(int n,int size){
        if(n>=0)
            return n%size;
        else
            return size+n%size;
    }

    private boolean onCoin(Point coordinate) {
        for (GameObject gameObject : this.gameObjects) {
            if (gameObject instanceof Moneta) {
                if (gameObject.getCoordinate().equals(coordinate)) {
                    return true;
                }
            }
        }
        return false;
    }
}
