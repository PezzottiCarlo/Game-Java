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

    public void update(Giocatore g, Direction direction, int moovement) {
        switch (direction) {
            // To Do: non creare sempre un nuovo punto ma aggiornarlo
            case NORTH:
                move(g, new Point(g.getCoordinate().getX(), getCoordNum(g.getCoordinate().getY() - moovement, sizeY)));
                break;
            case SOUTH:
                move(g, new Point(g.getCoordinate().getX(), getCoordNum(g.getCoordinate().getY() + moovement, sizeY)));
                break;
            case EAST:
                move(g, new Point(getCoordNum(g.getCoordinate().getX() + moovement, sizeX), g.getCoordinate().getY()));
                break;
            case WEST:
                move(g, new Point(getCoordNum(g.getCoordinate().getX() - moovement, sizeX), g.getCoordinate().getY()));
                break;
        }
        GameObject obj = onObject(g.getCoordinate(),g);
        if (obj != null) {
            //toDo: implementare bene il metodo over tipo tramite una interface (non ho voglia mo)
            ((Moneta) obj).over(g);
            removeGameObject(obj);
        }
    }

    private void move(Giocatore g, Point nextPoint) {
        if (!checkCollision(nextPoint)) {
            g.setCoordinate(nextPoint);
        }
    }

    private boolean checkCollision(Point nextPoint) {
        for (GameObject gameObject : this.gameObjects) {
            if (gameObject.getCoordinate().equals(nextPoint)) {
                return gameObject.isCollision();
            }
        }
        return false;
    }

    private int getCoordNum(int n, int size) {
        if (n >= 0)
            return n % size;
        else
            return size + n % size;
    }

    private GameObject onObject(Point coordinate, GameObject currentGameObj) {
        for (GameObject gameObject : this.gameObjects) {
            if (!gameObject.equals(currentGameObj)) {
                if (gameObject.getCoordinate().equals(coordinate)) {
                    return gameObject;
                }
            }
        }
        return null;
    }
}
