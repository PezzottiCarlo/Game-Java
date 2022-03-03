package OggettiGioco;

import General.Point;

public abstract class GameObject{
    public Point position;
    private char character;
    private boolean collision = false;

    public GameObject(Point position, char character, boolean collision) {
        this.position = position;
        this.character = character;
        this.collision = collision;
    }

    public GameObject(Point coordinate, char character) {
        this.position = coordinate;
        this.character = character;
    }

    public boolean isCollision() {
        return collision;
    }
    
    public Point getPosition(){
        return position;
    }

    public void setPosition(Point position){
        setPosition(position.getX(), position.getY());
    }

    public void setPosition(int x, int y){
        setXPosition(x);
        setYPosition(y);
    }
    public void setXPosition(int x){
        position.setX(x);
    }
    public void setYPosition(int y){
        position.setY(y);
    }

    public char getCharacter(){
        return character;
    }
}
