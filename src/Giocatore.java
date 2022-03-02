public class Giocatore {
    private String username;
    private Point coordinate;
    public final String CHARACTER = "X";

    public Giocatore(String username, Point coordinate) {
        this.username = username;
        this.coordinate = coordinate;
    }

    public String getUsername() {
        return username;
    }

    public Point getCoordinate() {
        return coordinate;
    }
}
