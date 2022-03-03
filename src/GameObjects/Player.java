package GameObjects;

import General.Color;
import General.Point;

public class Player extends GameObject {
    private String username;
    private int coins = 0;
    private Color color;

    public Player(Point position, String username) {
        super(position,'X');
        setUsername(username);
    }
    public void setUsername(String username) {
        if(username.matches("[a-zA-Z0-9]+")){
            this.username = username;
        }
    }

    public void incrementCoins(){
        coins++;
    }

    public void decrementCoins(){
        if(coins > 0){
            coins--;
        }
    }

    public int getCoins() {
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
        return "====================\n" +
                "Player " + username + ":\n" +
                "Coins: " + coins + "\n" +
                "Position : " + position.toString() + "\n" +
                "====================";
    }
}
