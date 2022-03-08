package General;

/**
 * Class for representing a color.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Color {

    //==================== Attributes ===================

    /**
     * Color black.
     */
    public static final String ANSI_BLACK = "\u001B[30m";

    /**
     * Color red.
     */
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Color green.
     */
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Color yellow.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Color blue.
     */
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Color purple.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";

    /**
     * Color cyan.
     */
    public static final String ANSI_CYAN = "\u001B[36m";

    /**
     * Color white.
     */
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Set the background color to black.
     */
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    /**
     * Set the background color to red.
     */
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    /**
     * Set the background color to green.
     */
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    /**
     * Set the background color to yellow.
     */
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    /**
     * Set the background color to blue.
     */
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    /**
     * Set the background color to purple.
     */
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    /**
     * Set the background color to cyan.
     */
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    /**
     * Set the background color to white.
     */
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    /**
     * Reset the color.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Color setted.
     */
    private final String color;

    // ==================== Constructors ====================

    /**
     * Constructor.
     *
     * @param color Color to set.
     */
    public Color(String color) {
        this.color = color;
    }

    // ==================== Getters and Setters ====================

    /**
     * Get the color.
     *
     * @return Color.
     */
    public String getColor() {
        return color;
    }

    //==================== public methods ====================

    /**
     * Return the color as a string.
     *
     * @return Color as a string.
     */
    @Override
    public String toString() {
        return color;
    }
}
