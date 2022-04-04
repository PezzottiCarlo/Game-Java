package GameObjects;

import General.*;

/**
 * This class represents a game object.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public abstract class GameObject{

    //==================== Attributes ===================

    /**
     * The position of the game object.
     */
    protected Point position;

    /**
     * The color of the game object.
     */
    private Color color;

    /**
     * The character representing the game object (is the same who will be printed).
     */
    private final char character;

    /**
     * Possible to collide or not
     */
    private boolean canCollide;

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param position The initial position of the game object.
     * @param character The character representing the game object.
     * @param color The color of the game object.
     */
    public GameObject(Point position, char character,Color color,boolean canCollide) {
        this.position = position;
        this.character = character;
        this.color = color;
        this.canCollide = canCollide;
    }

    // ==================== Getters and Setters ====================

    /**
     * Get the position of the game object.
     *
     * @return The position of the game object.
     */
    public Point getPosition(){
        return position;
    }

    /**
     * Get the X coordinate of the game object.
     *
     * @return The X coordinate of the game object.
     */
    public int getXPosition(){
        return position.getX();
    }

    /**
     * Get the Y coordinate of the game object.
     *
     * @return The Y coordinate of the game object.
     */
    public int getYPosition(){
        return position.getY();
    }

    /**
     * Get the character representing the game object.
     *
     * @return The character representing the game object.
     */
    public char getCharacter(){
        return character;
    }

    /**
     * Get the color of the game object.
     *
     * @return The color of the game object.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Get value of canCollide.
     * 
     * @return value of canCollide.
     */
    public boolean canCollide(){
        return canCollide;
    }
    
    /**
     * Set the position of the game object.
     *
     * @param position The position of the game object.
     */
    public void setPosition(Point position){
        setPosition(position.getX(), position.getY());
    }

    /**
     * Set the position of the game object.
     *
     * @param x The X coordinate of the game object.
     * @param y The Y coordinate of the game object.
     */
    public void setPosition(int x, int y){
        setXPosition(x);
        setYPosition(y);
    }

    /**
     * Set the X coordinate of the game object.
     *
     * @param x The X coordinate of the game object.
     */
    public void setXPosition(int x){
        position.setX(x);
    }

    /**
     * Set the Y coordinate of the game object.
     *
     * @param y The Y coordinate of the game object.
     */
    public void setYPosition(int y){
        position.setY(y);
    }

    /**
     * Set the color of the game object.
     *
     * @param color The color of the game object.
     */
    public void setColor(Color color){
        this.color = color;
    }

    public abstract Object getType();
}
