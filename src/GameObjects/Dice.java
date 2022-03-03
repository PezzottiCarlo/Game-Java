package GameObjects;

import General.Util;

public class Dice {
    public static int throwIt() {
        return Util.getRandomNumber(1, 6);
    }
}
