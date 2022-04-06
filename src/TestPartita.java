import gameEngine.Match;
import gameEngine.SplashScreen;

public class TestPartita {
    public static void main(String[] args) {
        SplashScreen.print();
        Match game = new Match();
        game.play();
    }
}
