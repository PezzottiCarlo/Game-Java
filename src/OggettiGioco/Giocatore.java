package OggettiGioco;

import General.Point;

public class Giocatore extends GameObject {
    private String username;
    private int coins;

    public Giocatore(Point coordinate, String username) {
        super(coordinate,'X');
        setUsername(username);
    }
    public void setUsername(String username) {
        if(username.matches("[a-zA-Z0-9]+")){
            this.username = username;
        }
    }
    public int getCoin() {
        return coins;
    }
    public void setCoin(int coins) {
        this.coins = coins;
    }
    public String getUsername() {
        return username;
    }
}
