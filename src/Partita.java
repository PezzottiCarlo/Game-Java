import java.util.Scanner;

public class Partita {
    public static final int BOARD_SIZE = 7;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean inGame = true;
        TavoloDaGioco gameBoard = new TavoloDaGioco(7);


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
