package GameEngine;

import General.Direction;
import General.Point;
import OggettiGioco.Dado;
import OggettiGioco.GameObject;
import OggettiGioco.Giocatore;

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

    public void move(Giocatore giocatore, Point coordinate, Direction direction) {
        switch (direction) {
            case NORTH:
                giocatore.setCoordinate(new Point(coordinate.getX(), (coordinate.getY() - 1) % sizeY));
                break;
            case SOUTH:
                giocatore.setCoordinate(new Point(coordinate.getX(), (coordinate.getY() + 1) % sizeY));
                break;
            case EAST:
                giocatore.setCoordinate(new Point((coordinate.getX() + 1) % sizeX, coordinate.getY()));
                break;
            case WEST:
                giocatore.setCoordinate(new Point((coordinate.getX() - 1) % sizeX, coordinate.getY()));
                break;
        }
    }

    private boolean onCoin(Point coordinate) {
        return false;
    }
}
