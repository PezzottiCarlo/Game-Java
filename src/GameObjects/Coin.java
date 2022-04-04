package GameObjects;

import General.*;

/**
 * Coin class.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Coin extends GameObject{

    //==================== Attributes ===================

    /**
     * Character representing the coin.
     */
    public static final char COIN_CHARACTER = '$';

    // ==================== Constructors ====================

    /**
     * Constructor for the coin.
     *
     * @param position The position of the coin.
     */
    public Coin(Point position) {
        super(position, COIN_CHARACTER, new Color(Color.ANSI_YELLOW),false);
    }

    /**
     * Constructor for the coin.
     *
     * @param x The x coordinate of the coin.
     * @param y The y coordinate of the coin.
     */
    public Coin(int x, int y){
        super(new Point(x,y),COIN_CHARACTER,new Color(Color.ANSI_YELLOW),false);
    }

    @Override
    public Object getType() {
        return Object.Coin;
    }

}
