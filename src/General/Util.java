package General;

public class Util {
    
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
