package GameObjects;

import General.*;

public abstract class GameObject{
    public Point position;
    private Color color;
    private final char character;

    public GameObject(Point position, char character,Color color) {
        this.position = position;
        this.character = character;
        this.color = color;
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

    public char getCharacter(){
        return character;
    }

    public Color getColor(){
        return color;
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

    public void setColor(Color color){
        this.color = color;
    }
    
}
