package gameObjects;

import general.Util;

/**
 * Dice class.
 */
public class Dice {
    // ==================== public methods ====================

    /**
     * Rolls the dice and returns the result.
     *
     * @return The result of the dice roll.
     */
    public static int throwDice(int max) {
        if(max <= 1) {
            return 1;
        }
        int movement = 0;
        long start = System.currentTimeMillis();
        long end = 0L;
        System.out.print("0");
        while (end - start < 2000) {
            end = System.currentTimeMillis();
            movement = Util.randomNumber(1, max);
            if (end % 250 == 0)
                System.out.print("\b" + movement);
        }
        System.out.println("\b" + movement);
        return movement;
    }

    /**
     * Rolls the default dice (1 to 6) and returns the result.
     *
     * @return The result of the dice roll.
     */
    public static int throwDice() {
        return throwDice(6);
    }
}
