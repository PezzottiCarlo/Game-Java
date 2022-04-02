package GameObjects;

import General.Color;
import General.Point;

public class Potion extends GameObject{

    public static final char POTION_CHARACTER = '&';

    /**
     * Constructor.
     *
     * @param position  The initial position of the game object.
     */
    public Potion(Point position){
        super(position, POTION_CHARACTER, new Color(Color.ANSI_PURPLE));
    }
}
