package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import General.Color;
import General.Util;
import Menu.Option.ExecuteOption;

/**
 * Menu class.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Menu {

    // ==================== Attributes ===================

    /**
     * The scanner used for the user input.
     */
    public static Scanner scanner;

    /**
     * The list of the options.
     */
    private final List<ExecuteOption> menuItems;

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
    // ==================== private methods ====================

    /**
     * Prints the menu on the console.
     * TODO: modificare il metodo per stampare il menu in modo più elegante
     */
    private void printMenu() {
        if (!inline) {
            for (int i = 0; i < menuItems.size(); i++) {
                if (menuItems.get(i).getKeyOption() != 0) {
                    System.out.println(Color.ANSI_PURPLE + menuItems.get(i).getKeyOption() + Color.ANSI_RESET + ":\t" + menuItems.get(i).toString());
                } else {
                    System.out.println(Color.ANSI_PURPLE + i + Color.ANSI_RESET + ":\t" + menuItems.get(i).toString());
                }
            }
            System.out.print("Choose: ");
        } else {
            System.out.print("Choose an option: ");
            for (int i = 0; i < menuItems.size(); i++) {
                if (i == 0)
                    System.out.print("[");
                if (i < menuItems.size() - 1){
                    if (menuItems.get(i).getKeyOption() != 0) {
                        System.out.print(Color.ANSI_PURPLE + menuItems.get(i).getKeyOption() + Color.ANSI_RESET + ": " + menuItems.get(i) + ", ");
                    }else{
                        System.out.print(Color.ANSI_PURPLE + i + Color.ANSI_RESET + ": " + menuItems.get(i) + ", ");
                    }
                }
                if (i == menuItems.size() - 1){
                    if (menuItems.get(i).getKeyOption() != 0) {
                        System.out.print(Color.ANSI_PURPLE + menuItems.get(i).getKeyOption() + Color.ANSI_RESET + ": " + menuItems.get(i) + "]: ");
                    }else{
                        System.out.print(Color.ANSI_PURPLE + i + Color.ANSI_RESET + ": " + menuItems.get(i) + "]: ");
                    }
                    
                }
            }
        }
    }

    /**
     * Return true if input is a char
     * @param input the input
     * @return true if input is a char
     */
    private boolean isChar(String input) {
        return input.length() == 1;
    }

    /**
     * Return the correnct error message
     * @param value the value
     * @return the correnct error message
     */
    private String getError(final String value){
        String error = Color.ANSI_RED+"Error: "+Color.ANSI_RESET+"\'"+value+"\' is not a valid option. Choose between [";
        for(int i =0; i<menuItems.size();i++){
            if(menuItems.get(i).getKeyOption() != 0){
                error += Color.ANSI_PURPLE+menuItems.get(i).getKeyOption()+Color.ANSI_RESET + (i == menuItems.size()-1 ? "]" : ", ");
            }else{
                error += Color.ANSI_PURPLE+i+Color.ANSI_RESET + (i == menuItems.size()-1 ? "]" : ",");
            }
        }
        return error;
    }

    /**
     * Method that returns the index of the choice according to the passed character if it does not find any correspondence it returns -1
     * @param choice the choice character
     * @return index of the choice
     */
    private int getOptionIndex(final int choice){
        //check if value is a char number
        if(choice-48>=0 && choice-48<=9){
            return choice-48;
        }
        for(int i =0; i<menuItems.size();i++){
            if(menuItems.get(i).getKeyOption() == choice){
                return i;
            }
        }
        return -1;
    }
    // ==================== public methods ====================

    /**
     * Prints the menu on the console.
     */
    public void ask() {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            String input = scanner.next();
            while(!isChar(input)){
                System.out.println(getError(input));
                printMenu();
                input = scanner.next();
            }
            choice = input.charAt(0);
            scanner.nextLine();
            int optionIndex = getOptionIndex(choice);
            if (optionIndex != -1) {
                menuItems.get(optionIndex).execute(optionIndex);
                return;
            } else {
                System.out.println(getError(""+(char)choice));
            }
        }
        Util.clearScreen();
    }

    /**
     * Adds an option to the menu.
     *
     * @param menuItem the option to add.
     */
    public void addMenu(ExecuteOption menuItem) {
        menuItems.add(menuItem);
    }

    /**
     * Removes an option from the menu.
     *
     * @param menuItem the option to remove.
     */
    public void removeMenu(ExecuteOption menuItem) {
        menuItems.remove(menuItem);
    }
}
