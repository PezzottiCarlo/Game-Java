package GameEngine;

import GameObjects.Player;
import GameObjects.Coin;
import General.Color;
import General.Direction;
import General.Point;
import GameObjects.Dice;
/*
public class Partita {

    public static final int BOARD_SIZE_X = 10;
    public static final int BOARD_SIZE_Y = 10;

    private boolean inGame = true;
    private GameBoard gameBoard;
    private TextualRappresentation rappresentazioneTestuale;

    public Partita() {
        gameBoard = new GameBoard(BOARD_SIZE_X, BOARD_SIZE_Y);
        this.rappresentazioneTestuale = new TextualRappresentation(this);
        gameBoard.getLogicaDiGioco().addGameObject(new Coin(new Point(0, 0)));
        gameBoard.getLogicaDiGioco().addGameObject(new Coin(new Point(1, 0)));
        gameBoard.getLogicaDiGioco()
                .addGameObject(new Player(new Point(2, 0), "Giocatore1", Color.getRandomColor()));
    }

    public void play() {
        while (inGame){
            rappresentazioneTestuale.ask();
        }
    }

    public void gameOver(){
        this.inGame = false;
    }

    public void showPlayers() {
        for (Player giocatore : gameBoard.getLogicaDiGioco().getGiocatori()) {
            System.out.println(giocatore);
        }
    }

    public void movePlayer(Player g, Direction d) {
        System.out.println("Move " + g.getUsername() + " " + d);
        int moovement = 0;
        System.out.print("Dice result: ");
        long start = System.currentTimeMillis();
        long end = 0l;
        System.out.print("0");
        while(end - start < 2000){
            end = System.currentTimeMillis();
            moovement = Dice.throwIt();
            System.out.print("\b" + moovement);
        }
        System.out.println("\b" + moovement);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
*/

