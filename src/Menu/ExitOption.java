package Menu;
public class ExitOption extends Option {

    @Override
    public void execute(int choice) {
        System.out.println(this +" "+ choice);
    }
    @Override
    public String toString() {
        return "Exit";
    }
}
