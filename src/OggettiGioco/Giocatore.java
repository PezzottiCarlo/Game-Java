package OggettiGioco;

import General.Color;
import General.Point;

public class Giocatore extends GameObject {
    private String username;
    private int coins;
    private Color color;

    public Giocatore(Point coordinate, String username,Color color) {
        super(coordinate,'X',true);
        setUsername(username);
        setColor(color);
    }
    public void setUsername(String username) {
        if(username.matches("[a-zA-Z0-9]+")){
            this.username = username;
        }
    }
    public void setCoin(int coins) {
        this.coins = coins;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public int getCoin() {
        return coins;
    }
    
    public String getUsername() {
        return username;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "username='" + username + '\'' +
                ", coins=" + coins +
                '}';
    }
}
