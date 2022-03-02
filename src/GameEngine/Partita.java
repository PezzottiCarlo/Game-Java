package GameEngine;

import OggettiGioco.Giocatore;
import OggettiGioco.Moneta;

import java.util.Scanner;

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
                    // TODO: implementare muovere un giocatore
                    break;
                case 3:
                    mostraGiocatori();
                    break;
                default:
                    System.out.println("Funzionalità ancora non implementata");
            }
        }
    }

    public void mostraGiocatori() {
        for (Giocatore giocatore : gameBoard.getLogicaDiGioco().getGiocatori()) {
            System.out.println(giocatore);
        }
    }
}
