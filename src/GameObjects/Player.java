package GameObjects;

import General.Color;
import General.Point;

public class Player extends GameObject {
    private String username;
    private int coins = 0;

    public Player(Point position, String username, char marker) {
        super(position,marker,new Color(Color.ANSI_CYAN));
        setUsername(username);
    }


    public void setUsername(String username) {
        if(username.matches("[a-zA-Z0-9]+")){
            this.username = username;
        }
    }

    public int getCoins() {
        return coins;
    }

    public void incrementCoins(){
        coins++;
    }

    public void decrementCoins(){
        if(coins > 0){
            coins--;
        }
    }

    
    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "====================\n" +
                "Player " + username + ":\n" +
                "Coins: " + coins + "\n" +
                "Position : " + position.toString() + "\n" +
                "====================";
    }
}
