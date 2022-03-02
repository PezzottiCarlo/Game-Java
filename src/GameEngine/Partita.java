package GameEngine;

import OggettiGioco.Giocatore;
import OggettiGioco.Moneta;

import java.util.Scanner;

import General.Color;
import General.Direction;
import General.Point;

public class Partita {

    public static final int BOARD_SIZE_X = 7;
    public static final int BOARD_SIZE_Y = 3;

    private TavoloDaGioco gameBoard;
    private RappresentazioneTestuale rappresentazioneTestuale;

    public Partita() {
        this.gameBoard = new TavoloDaGioco(BOARD_SIZE_X, BOARD_SIZE_Y);
        this.rappresentazioneTestuale = new RappresentazioneTestuale();
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(0, 0)));
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(1, 0)));
        gameBoard.getLogicaDiGioco()
                .addGameObject(new Giocatore(new Point(2, 2), "Giocatore1", Color.getRandomColor()));
    }

    public void play() {
        rappresentazioneTestuale.ask();
    }

    public void showPlayers() {
        for (Giocatore giocatore : gameBoard.getLogicaDiGioco().getGiocatori()) {
            System.out.println(giocatore);
        }
    }

    public void movePlayers() {
        for (Giocatore giocatore : gameBoard.getLogicaDiGioco().getGiocatori()) {
            gameBoard.getLogicaDiGioco().move(giocatore, Direction.WEST);
        }
    }
}
