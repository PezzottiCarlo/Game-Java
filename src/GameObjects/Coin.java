package GameObjects;

import General.Point;

public class Coin extends GameObject{

    public static final char COIN_CHARACTER = '$';

    public Coin(Point position) {
        super(position, COIN_CHARACTER);
    }

    public void over(GameObject gameObject) {
        if(gameObject instanceof Player){
            Player g = (Player) gameObject;
            g.incrementCoins();
        }
    }
}
