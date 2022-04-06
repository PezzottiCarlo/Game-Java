package menu.option;

/**
 * This class represents a generic option.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class GenericOption extends Option {

    //==================== Attributes ===================

    /**
     * Interface to implement.
     */
    private final GenericExecuteOption option;

    /**
     * The name of the option.
     */
    private final String name;

    /**
     * The key of the option.
     */
    private final char keyOption;

    // ==================== Constructors ====================

    /**
     * Constructor of the class.
     *
     * @param name The name of the option.
     * @param option The interface to implement.
     * @param keyOption The key of the option.
     */
    public GenericOption(String name,char keyOption, GenericExecuteOption option) {
        this.name = name;
        this.option = option;
        this.keyOption = keyOption;
    }

    /**
     * Constructor of the class.
     * @param name The name of the option.
     * @param option The interface to implement.
     */
    public GenericOption(String name, GenericExecuteOption option) {
        this(name, (char)0, option);
    }


    //==================== public methods ====================


    /**
     * Execute the option.
     *
      * @param choice The choice of the player.
     */
    @Override
    public void execute(int choice) {
        this.option.execute();
    }

    /**
     * Get the name of the option.
     *
     * @return The name of the option.
     */
    @Override
    public String toString() {
        return this.name;
    }

    //==================== getter ====================
    /**
     * Get the key of the option.
     */
    public char getKeyOption() {
        return keyOption;
    }
}
