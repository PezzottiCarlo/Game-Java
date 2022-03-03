package GameEngine;

import General.Direction;
import General.Point;
import GameObjects.Dice;
import GameObjects.GameObject;
import GameObjects.Player;
import GameObjects.Coin;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {

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
    }*/

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
}
