package GameObjects;

import General.*;

public class Coin extends GameObject{

    public static final char COIN_CHARACTER = '$';

    public Coin(Point position) {
        super(position, COIN_CHARACTER, new Color(Color.ANSI_YELLOW));
    }

    public Coin(int x, int y){
        super(new Point(x,y),COIN_CHARACTER,new Color(Color.ANSI_YELLOW));
    }
}
