package gameObjects;

import general.*;

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
    public static final String COIN_CHARACTER = "$ ";

    public static final String COIN_EMOJI = "💰";
    /**
     * Color rappresentation of the coin.
     */
    public static final Color COIN_COLOR = new Color(Color.ANSI_YELLOW);


    // ==================== Constructors ====================

    /**
     * Constructor for the coin.
     *
     * @param position The position of the coin.
     */
    public Coin(Point position, boolean useEmoji) {
        super(position,(useEmoji? COIN_EMOJI : COIN_CHARACTER), COIN_COLOR,false);
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

    /**
     * method used to return the name of the object
     * @return the name of the object
     */
    @Override
    public ObjectName getType() {
        return ObjectName.Coin;
    }

}
