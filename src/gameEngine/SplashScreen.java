package gameEngine;

import general.Util;

/**
 * Splashscreen class used to show the splash screen of the game 
 */
public class SplashScreen {

    /**
     * Lines of the splash screen
     */
    public static String[] lines = new String[] {
            "   ______                     __        ____              _",
            "  / ____/________ _____  ____/ /__     / __ \\____ _____  (_)___  ____ _",
            " / / __/ ___/ __ `/ __ \\/ __  / _ \\   / /_/ / __ `/ __ \\/ / __ \\/ __ `/",
            "/ /_/ / /  / /_/ / / / / /_/ /  __/  / _, _/ /_/ / /_/ / / / / / /_/ /",
            "\\____/_/   \\__,_/_/ /_/\\__,_/\\___/__/_/_|_|\\__,_/ .___/_/_/ /_/\\__,_/  ",
            "                                               /__/",
            "                             _    ______",
            "                            | |  / /  _/",
            "                            | | / // /",
            "                            | |/ // /",
            "                            |___/___/",
            "                       ___   ____ ___  ___",
            "                       |__ \\ / __ \\__ \\|__ \\",
            "                       __/ // / / /_/ /__/ /",
            "                      / __// /_/ / __// __/",
            "                     /____/\\____/____/____/",
            "          __  ______     __ __  __      ______",
            "         / / / / __ \\   / // / / /__   / ____/_______  ___ ",
            "        / /_/ / / / /  / // /_/ //_/  / /_  / ___/ _ \\/ _ \\",
            "       / __  / /_/ /  /__  __/ ,<    / __/ / /  /  __/  __/",
            "      /_/ /_/_____/     /_/ /_/|_|  /_/   /_/   \\___/\\___/"


    };

    /**
     * Method that prints the splashscreen using bottom-up animation
     */
    public static void print() {
        try {
            for (int i = lines.length - 1; i >= 0; i--) {
                Thread.sleep(50);
                System.out.println(lines[lines.length - i - 1]);
            }
            Thread.sleep(1000);
            Util.clearScreen();
        } catch (InterruptedException ie) {}
    }
}
