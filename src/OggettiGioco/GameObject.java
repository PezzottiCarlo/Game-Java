package OggettiGioco;

import General.Point;

public abstract class GameObject{
    private Point coordinate;
    private char character;
    private boolean collision = false;

    public GameObject(Point coordinate, char character, boolean collision) {
        this.coordinate = coordinate;
        this.character = character;
        this.collision = collision;
    }

    public GameObject(Point coordinate, char character) {
        this.coordinate = coordinate;
        this.character = character;
    }

    public boolean isCollision() {
        return collision;
    }
    
    public Point getCoordinate(){
        return coordinate;
    }

    public void setCoordinate(Point coordinate){
        this.coordinate = coordinate;
    }

    public char getCharacter(){
        return character;
    }
}
