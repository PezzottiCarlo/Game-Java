package gameObjects;

import general.*;

public class Tree extends GameObject {

    public static final int MAX_HEALTH = 2;
    public static final char TREE_CHARACTER = '#';
    public static final Color[] TREE_COLORS = {new Color(Color.ANSI_YELLOW_BACKGROUND),new Color(Color.ANSI_GREEN_BACKGROUND)};

    private int health;

    public Tree(Point position) {
        super(position, TREE_CHARACTER, TREE_COLORS[TREE_COLORS.length-1],true);
        this.health = MAX_HEALTH;
    }

    public int getHealth() {
        return health;
    }

    public void hit(){
        this.health--;
        if(health-1>=0)
            setColor(TREE_COLORS[health-1]);
    }

    @Override
    public ObjectName getType() {
        return ObjectName.Tree;
    }
}
