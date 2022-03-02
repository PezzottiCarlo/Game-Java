package OggettiGioco;

public class Dado {
    public static int throwIt() {
        return (int) (Math.random() * 6 + 1);
    }
}
