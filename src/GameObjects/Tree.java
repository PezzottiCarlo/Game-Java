package GameObjects;

import General.Color;
import General.Point;

public class Tree extends GameObject {

    public static final int MAX_HEALTH = 2;
    public static final char TREE_CHARACTER = '#';

    private int health;

    public Tree(Point position) {
        super(position, TREE_CHARACTER, new Color(Color.ANSI_GREEN_BACKGROUND),true);
        this.health = MAX_HEALTH;
    }

    public int getHealth() {
        return health;
    }

    public void hit(){
        this.health--;
    }

    @Override
    public Object getType() {
        return Object.Tree;
    }
}
