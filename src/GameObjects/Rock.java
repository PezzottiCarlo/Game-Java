package GameObjects;

import General.Color;
import General.Point;

public class Rock extends GameObject {

    public static final char WALL_CHARACTER = '@';

    public static final Color WALL_COLOR = new Color(Color.ANSI_RED_BACKGROUND);
    /**
     * Constructor.
     * 
     * @param position
     * The initial position of the game object.
     */
    public Rock(Point position) {
        super(position, WALL_CHARACTER, WALL_COLOR,true);
    }

    @Override
    public Object getType() {
        return Object.Rock;
    }
    
}
