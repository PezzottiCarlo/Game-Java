package gameObjects;

import general.*;

public class Gem extends GameObject {

    public static final char GEM_CHARACTER = '%';
    
    public static final Color GEM_COLOR = new Color(Color.ANSI_GREEN);

    public Gem(Point position) {
        super(position, GEM_CHARACTER, GEM_COLOR,false);
    }

    @Override
    public ObjectName getType() {
        return ObjectName.Gem;
    }

}
