package gameObjects;

import general.*;
/**
 * Gem class
 * 
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Gem extends GameObject {
    /**
     * Character representing the gem.
     */
    public static final String GEM_CHARACTER = "% ";

    public static final String GEM_EMOJI = "💎";
    /**
     * Color rappresentation of the gem.
     */
    public static final Color GEM_COLOR = new Color(Color.ANSI_GREEN);

    /**
     * Constructor for the gem.
     * @param position The position of the gem.
     */
    public Gem(Point position, boolean useEmoji) {
        super(position, (useEmoji? GEM_EMOJI : GEM_CHARACTER), GEM_COLOR,false);
    }

    /**
     * method used to return the name of the object
     * @return the name of the object
     */
    @Override
    public ObjectName getType() {
        return ObjectName.Gem;
    }

}
