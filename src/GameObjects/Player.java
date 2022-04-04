package GameObjects;

import General.Color;
import General.Point;

/**
 * The Player class is a subclass of the GameObject class.
 *
 * @author Matteo Arena
 * @author Carlo Pezzotti
 */
public class Player extends GameObject {

    //==================== Attributes ===================

    /**
     * The player's username.
     */
    private String username;

    /**
     * The number of coins the player has.
     */
    private int coins = 0;

    /**
     * The number of gems;
     */
    private int gems = 0;

    /**
     * The number of potions the player has.
     */
    private int potions = 0;

    /**
     * The default id for the player if the username is not specified or unacceptable.
     */
    private static int defaultId = 100;

    // ==================== Constructors ====================

    /**
     * Constructor of the Player class.
     *
     * @param position the position of the player.
     * @param username the player's username.
     * @param marker the player's marker (the character who will be printed on the terminal).
     */
    public Player(Point position, String username, char marker) {
        super(position,marker,new Color(Color.ANSI_CYAN),false);
        setUsername(username);
    }

    // ==================== Getters and Setters ====================

    /**
     * Sets the player's username, if the username is not acceptable it would be 'player' + defaultId.
     *
     * @param username the player's username.
     */
    public void setUsername(String username) {
        if(username.matches("[a-zA-Z0-9]+")){
            this.username = username;
        }else{
            this.username = "Player" + defaultId++;
        }
    }

    /**
     * Returns the number of coins the player has.
     *
     * @return the number of coins the player has.
     */
    public int getCoins() {
        return coins;
    }

    public int getGems() {
        return gems;
    }

    public int getPotions() {
        return potions;
    }
    /**
     * Returns the player's username.
     *
     * @return the player's username.
     */
    public String getUsername() {
        return username;
    }

    //==================== private methods ====================
    //==================== public methods ====================

    /**
     * Adds a coin to the player.
     */
    public void incrementCoins(){
        coins++;
    }

    /**
     * Adds a gem to the player.
     */
    public void incrementGems(){
        gems++;
    }

    /**
     * Adds a potion to the player.
     */
    public void incrementPotions(){
        potions++;
    }

    /**
     * Removes a coin from the player.
     */
    public void decrementCoins(){
        if(coins > 0){
            coins--;
        }
    }

    /**
     * Removes a gem from the player.
     */
    public void decrementGems(){
        if(gems > 0){
            gems--;
        }
    }

    /**
     * Removes a potion from the player.
     */
    public void decrementPotions(){
        if(potions > 0){
            potions--;
        }
    }

    /**
     * Returns a string representation of the player.
     *
     * @return a string representation of the player.
     */
    @Override
    public String toString() {
        return "====================\n" +
                "Player " + username + ":\n" +
                "Coins: " + coins + "\n" +
                "Position : " + position.toString() + "\n" +
                "====================";
    }

    @Override
    public Object getType() {
        return Object.Player;
    }

}
