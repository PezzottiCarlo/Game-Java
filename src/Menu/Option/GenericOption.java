package Menu.Option;

public class GenericOption implements IOption {
    
    private IOption option;
    private String name;

    public GenericOption(String name, IOption option) {
        this.name = name;
        this.option = option;
    }
    
    @Override
    public void execute(int choice) {
        this.option.execute(choice);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
