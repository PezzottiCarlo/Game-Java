import java.util.Scanner;

public class RappresentazioneTestuale {
    private static String[] options = {"Esci", "Mostra Griglia", "Muovi", "Mostra info giocatori"};

    public static int askWhatToDo() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + "." + options[i]);
        }

        int num = -1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Scelta: ");
            while (!in.hasNextInt()) {
                System.out.print("Scelta:");
                in.nextLine();
            }
            num = in.nextInt();
        }while(num >= 0 && num < options.length);
        in.close();
        return num;
    }

}
