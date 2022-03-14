package Menu.Option;

/**
 * Interface for the Option class.
 */
public interface ExecuteOption{
    /**
     * Gets the name of the option.
     *
     * @return the name of the option.
     */
    void execute(int choice);

    /**
     * Gets the key of the option.
     *
     * @return the key of the option.
     */
    char getKeyOption();
}
