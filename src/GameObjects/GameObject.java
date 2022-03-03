package GameObjects;

import General.Point;

public abstract class GameObject{
    public Point position;
    private char character;

    public GameObject(Point position, char character) {
        this.position = position;
        this.character = character;
    }

    public Point getPosition(){
        return position;
    }
    public int getXPosition(){
        return position.getX();
    }
    public int getYPosition(){
        return position.getY();
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
