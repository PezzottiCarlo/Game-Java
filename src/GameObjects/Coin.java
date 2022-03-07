package GameObjects;

import General.Point;

public class Coin extends GameObject{

    public static final char COIN_CHARACTER = '$';

    public Coin(Point position) {
        super(position, COIN_CHARACTER);
    }

    public Coin(int x, int y){
        super(new Point(x,y),COIN_CHARACTER);
    }
}
