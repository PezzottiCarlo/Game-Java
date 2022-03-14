package Menu.Option;

/**
 * This class represents a generic option.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class GenericOption implements ExecuteOption {

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
     */
    public GenericOption(String name,char keyOption, GenericExecuteOption option) {
        this.name = name;
        this.option = option;
        this.keyOption = keyOption;
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
    public char getKeyOption() {
        return keyOption;
    }
}
