package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import General.Color;
import Menu.Option.IOption;

/**
 * Menu class.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Menu {

    //==================== Attributes ===================

    /**
     * The scanner used for the user input.
     */
    public static Scanner scanner;

    /**
     * The list of the options.
     */
    private final List<IOption> menuItems;

    /**
     * Flag used to print on the same line.
     */
    private final boolean inline;

    // ==================== Constructors ====================

    static {
        scanner = new Scanner(System.in);
    }

    /**
     * Constructor.
     *
     * @param inline flag used to print on the same line.
     */
    public Menu(boolean inline) {
        this.inline = inline;
        menuItems = new ArrayList<>();
    }

    // ==================== Getters and Setters ====================
    //==================== private methods ====================
    //==================== public methods ====================

    /**
     * Prints the menu on the console.
     */
    public void ask() {
        int choice = -1;
        while (choice != 0) {
            if (!inline) {
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println(Color.ANSI_PURPLE +i+Color.ANSI_RESET + ":\t" + menuItems.get(i).toString());
                }
                System.out.print("Choose: ");
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
                System.out.println("Invalid input");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 0 && choice < menuItems.size()) {
                menuItems.get(choice).execute(choice);
                return;
            } else {
                System.out.println("Value out of range [0," + menuItems.size() + "] ");
            }
        }
    }

    /**
     * Adds an option to the menu.
     *
     * @param menuItem the option to add.
     */
    public void addMenu(IOption menuItem) {
        menuItems.add(menuItem);
    }

    /**
     * Removes an option from the menu.
     *
     * @param menuItem the option to remove.
     */
    public void removeMenu(IOption menuItem) {
        menuItems.remove(menuItem);
    }
}
