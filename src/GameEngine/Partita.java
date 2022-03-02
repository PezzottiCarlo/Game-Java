package GameEngine;

import OggettiGioco.Moneta;
import OggettiGioco.Point;

import java.util.Scanner;

public class Partita {
    public static final int BOARD_SIZE_X = 7;
    public static final int BOARD_SIZE_Y = 3;

    public void play(){
        Scanner input = new Scanner(System.in);
        boolean inGame = true;
        TavoloDaGioco gameBoard = new TavoloDaGioco(BOARD_SIZE_X,BOARD_SIZE_Y);
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(0,0)));
        gameBoard.getLogicaDiGioco().addGameObject(new Moneta(new Point(1,0)));
        while(inGame){
            int choose = RappresentazioneTestuale.askWhatToDo(input);
            switch (choose){
                case 0:
                    input.close();
                    inGame = false;
                    return;
                case 1:
                    gameBoard.displayGrid();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Funzionalità ancora non implementata");
            }
        }
    }
}
