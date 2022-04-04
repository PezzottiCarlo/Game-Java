package GameObjects;

import General.Color;
import General.Point;

public class Rock extends GameObject {

    public static final char WALL_CHARACTER = '@';

    /**
     * Constructor.
     * 
     * @param position
     * The initial position of the game object.
     */
    public Rock(Point position) {
        super(position, WALL_CHARACTER, new Color(Color.ANSI_RED_BACKGROUND),true);
    }
    
}
