package GameObjects;

import General.Color;
import General.Point;

public class Rocks extends GameObject {

    public static final char WALL_CHARACTER = '@';

    /**
     * Constructor.
     * 
     * @param position
     * The initial position of the game object.
     */
    public Rocks(Point position) {
        super(position, WALL_CHARACTER, new Color(Color.ANSI_RED_BACKGROUND),true);
    }
    
}
