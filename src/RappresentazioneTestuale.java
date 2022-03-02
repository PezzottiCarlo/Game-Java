import java.util.Scanner;

public class RappresentazioneTestuale {
    private static final String[] options = {"Esci", "Mostra Griglia", "Muovi", "Mostra info giocatori"};

    public static int askWhatToDo() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + "." + options[i]);
        }

        int num = Integer.MIN_VALUE;
        Scanner in = new Scanner(System.in);
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
        in.close();
        return num;
    }

}
