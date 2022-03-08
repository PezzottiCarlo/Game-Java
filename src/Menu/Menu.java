package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import General.Color;
import Menu.Option.IOption;

public class Menu {
    public static Scanner scanner;
    private final List<IOption> menuItems;
    private final boolean inline;

    static {
        scanner = new Scanner(System.in);
    }

    public Menu(boolean inline) {
        this.inline = inline;
        menuItems = new ArrayList<>();
    }

    public void ask() {
        int choice = -1;
        while (choice != 0) {
            if (!inline) {
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println(Color.ANSI_PURPLE +i+Color.ANSI_RESET + ":\t" + menuItems.get(i).toString());
                }
                System.out.print("Scelta: ");
            } else {
                System.out.print("Choose an option: ");
                for (int i = 0; i < menuItems.size(); i++) {
                    if (i == 0)
                        System.out.print("[");
                    if (i < menuItems.size() - 1)
                        System.out.print(Color.ANSI_PURPLE +i+Color.ANSI_RESET + ": "+ menuItems.get(i) + ", ");
                    if (i == menuItems.size()-1)
                        System.out.print(Color.ANSI_PURPLE +i+Color.ANSI_RESET + ": "+menuItems.get(i)+"]: ");
                }
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Valore non accettabile");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 0 && choice < menuItems.size()) {
                menuItems.get(choice).execute(choice);
                return;
            } else {
                System.out.println("Valore fuori dal range [0," + menuItems.size() + "] ");
            }
        }
    }

    public void addMenu(IOption menuItem) {
        menuItems.add(menuItem);
    }

    public void removeMenu(IOption menuItem) {
        menuItems.remove(menuItem);
    }
}
