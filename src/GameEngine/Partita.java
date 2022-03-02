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

    public void play() {
        Scanner input = new Scanner(System.in);
        boolean inGame = true;
        gameBoard = new TavoloDaGioco(BOARD_SIZE_X, BOARD_SIZE_Y);
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(0, 0)));
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(1, 0)));
        gameBoard.getLogicaDiGioco()
                .addGameObject(new Giocatore(new Point(2, 2), "Giocatore1", Color.getRandomColor()));

        while (inGame) {
            int choose = RappresentazioneTestuale.askWhatToDo(input);
            switch (choose) {
                case 0:
                    input.close();
                    inGame = false;
                    return;
                case 1:
                    gameBoard.displayGrid();
                    break;
                case 2:
                    movePlayers();
                    break;
                case 3:
                    showPlayers();
                    break;
                default:
                    System.out.println("Funzionalità ancora non implementata");
            }
        }
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
