package Menu;

public class ExitMenu implements MenuInterface {

    @Override
    public void execute(int choice) {
        System.out.println(this +" "+ choice);
    }
    @Override
    public String toString() {
        return "Exit";
    }
}
