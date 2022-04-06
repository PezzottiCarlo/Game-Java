package gameObjects;

import general.*;

/**
 * Potion class.
 * 
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Potion extends GameObject{

    /**
     * Character representing the potion.
     */
    public static final String POTION_CHARACTER = "& ";

    public static final String POTION_EMOJI = "🧪";

    /**
     * Color rappresentation of the potion.
     */
    public static final Color POTION_COLOR = new Color(Color.ANSI_PURPLE);
    /**
     * Constructor.
     *
     * @param position  The initial position of the game object.
     */
    public Potion(Point position, boolean useEmoji){
        super(position, (useEmoji? POTION_EMOJI : POTION_CHARACTER), POTION_COLOR,false);
    }

    /**
     * method used to return the name of the object
     * @return the name of the object
     */
    @Override
    public ObjectName getType() {
        return ObjectName.Potion;
    }
}
