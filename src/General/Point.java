package general;

/**
 * A point in 2D space.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Point {

    //==================== Attributes ===================

    /**
     * The x coordinate of the point.
     */
    private int x;

    /**
     * The y coordinate of the point.
     */
    private int y;

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param x the x coordinate of the point.
     * @param y the y coordinate of the point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ==================== Getters and Setters ====================

    /**
     * Get the x coordinate of the point.
     *
     * @return the x coordinate of the point.
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y coordinate of the point.
     *
     * @return the y coordinate of the point.
     */
    public int getY() {
        return y;
    }

    /**
     * Set the x coordinate of the point.
     *
     * @param x the x coordinate of the point.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set the y coordinate of the point.
     *
     * @param y the y coordinate of the point.
     */
    public void setY(int y) {
        this.y = y;
    }

    //==================== public methods ====================

    /**
     * Check if the point is equal to another point.
     *
     * @param p the point to compare.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point p){
        return (this.x == p.getX() && this.y == p.getY());
    }

    /**
     * Return a string representation of the point.
     *
     * @return a string representation of the point.
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
