package Menu.Option;

/**
 * This class represents a generic option.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class GenericOption implements IOption {

    //==================== Attributes ===================

    /**
     * Interface to implement.
     */
    private final IOption option;

    /**
     * The name of the option.
     */
    private final String name;

    // ==================== Constructors ====================

    /**
     * Constructor of the class.
     *
     * @param name The name of the option.
     * @param option The interface to implement.
     */
    public GenericOption(String name, IOption option) {
        this.name = name;
        this.option = option;
    }

    //==================== public methods ====================

    /**
     * Execute the option.
     *
      * @param choice The choice of the player.
     */
    @Override
    public void execute(int choice) {
        this.option.execute(choice);
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
}
