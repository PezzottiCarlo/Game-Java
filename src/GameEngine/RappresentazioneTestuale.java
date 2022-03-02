package GameEngine;

import java.util.Scanner;
public class RappresentazioneTestuale {
    private static final String[] options = {"Esci", "Mostra Griglia", "Muovi", "Mostra info giocatori"};

    public static int askWhatToDo(Scanner in) {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + "." + options[i]);
        }

        int num = Integer.MIN_VALUE;
        System.out.print("Scelta: ");
        do {
            if(num != Integer.MIN_VALUE){
                System.out.println("Valore fuori dal range [0," + options.length + "] ");
            }
            while (!in.hasNextInt()) {
                System.out.println("Valore non accettabile");
                in.nextLine();
            }
            num = in.nextInt();
        }while(num < 0 || num >= options.length);
        return num;
    }

}
