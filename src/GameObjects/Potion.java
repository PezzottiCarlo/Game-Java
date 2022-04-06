package gameObjects;

import general.*;

public class Potion extends GameObject{

    public static final char POTION_CHARACTER = '&';

    public static final Color POTION_COLOR = new Color(Color.ANSI_PURPLE);
    /**
     * Constructor.
     *
     * @param position  The initial position of the game object.
     */
    public Potion(Point position){
        super(position, POTION_CHARACTER, POTION_COLOR,false);
    }

    @Override
    public ObjectName getType() {
        return ObjectName.Potion;
    }
}
