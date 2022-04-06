package general;

/**
 * This class contains some utility methods.
 *
 * @author Carlo Pezzotti
 * @author Matteo Arena
 */
public class Util {

    //==================== public methods ====================

    /**
     * Generate a random number between min and max.
     *
     * @param min the minimum value.
     * @param max the maximum value.
     * @return a random number between min and max.
     */
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Clear the console.
     */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
