package GameEngine;

import OggettiGioco.Giocatore;
import OggettiGioco.Moneta;
import General.Color;
import General.Direction;
import General.Point;

public class Partita {

    public static final int BOARD_SIZE_X = 10;
    public static final int BOARD_SIZE_Y = 10;

    private boolean inGame = true;
    private TavoloDaGioco gameBoard;
    private RappresentazioneTestuale rappresentazioneTestuale;

    public Partita() {
        this.gameBoard = new TavoloDaGioco(BOARD_SIZE_X, BOARD_SIZE_Y);
        this.rappresentazioneTestuale = new RappresentazioneTestuale(this);
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(0, 0)));
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(1, 0)));
        gameBoard.getLogicaDiGioco()
                .addGameObject(new Giocatore(new Point(2, 0), "Giocatore1", Color.getRandomColor()));
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
        for (Giocatore giocatore : gameBoard.getLogicaDiGioco().getGiocatori()) {
            System.out.println(giocatore);
        }
    }

    public void movePlayer(Giocatore g, Direction d) {
        System.out.println("Move " + g.getUsername() + " " + d);
        gameBoard.getLogicaDiGioco().update(g, d);
    }

    public TavoloDaGioco getGameBoard() {
        return gameBoard;
    }
}
