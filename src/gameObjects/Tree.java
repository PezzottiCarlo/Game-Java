package gameObjects;

import general.*;

/**
 * Tree class.
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Tree extends GameObject {

    /**
     * The max health of the tree.
     */
    public static final int MAX_HEALTH = 2;
    /**
     * Character representing the tree.
     */
    public static final String TREE_CHARACTER = "# ";

    public static final String TREE_EMOJI = "🌲";
    /**
     * Color rappresentation of the tree.
     */
    public static final Color[] TREE_COLORS = {new Color(Color.ANSI_YELLOW_BACKGROUND),new Color(Color.ANSI_GREEN_BACKGROUND)};
    /**
     * The healt of the health.
     */
    private int health;

    /**
     * Constructor.
     * @param position The initial position of the game object.
     */
    public Tree(Point position, boolean useEmoji) {
        super(position, (useEmoji? TREE_EMOJI : TREE_CHARACTER), TREE_COLORS[TREE_COLORS.length-1],true);
        this.health = MAX_HEALTH;
    }

    /**
     * method returning tree health
     * @return tree health
     */
    public int getHealth() {
        return health;
    }

    /**
     * method used to hit a tree and take 1 life from it, with life changing colour
     */
    public void hit(){
        this.health--;
        if(health-1>=0)
            setColor(TREE_COLORS[health-1]);
    }

    /**
     * method used to return the name of the object
     * @return the name of the object
     */
    @Override
    public ObjectName getType() {
        return ObjectName.Tree;
    }
}
