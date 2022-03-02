package OggettiGioco;

import General.Util;

public class Dado {
    public static int throwIt() {
        return Util.getRandomNumber(1, 6);
    }
}
