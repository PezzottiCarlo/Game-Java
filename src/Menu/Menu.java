package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menu.Option.IOption;

public class Menu{
    public static Scanner scanner;
    private List<IOption> menuItems;
    
    static {
        scanner = new Scanner(System.in);
    }

    public Menu(boolean inline) {
        menuItems = new ArrayList<>();
    }

    public void ask(){
        int choice = -1;
        while (choice != 0) {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + "." + menuItems.get(i).toString());
            }
            System.out.print("Scelta: ");
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
