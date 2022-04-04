package GameObjects;

import General.Color;
import General.Point;

public class Gem extends GameObject {

    public static final char GEM_CHARACTER = '%';

    public Gem(Point position) {
        super(position, GEM_CHARACTER, new Color(Color.ANSI_GREEN),false);
    }

    @Override
    public Object getType() {
        return Object.Gem;
    }

}
