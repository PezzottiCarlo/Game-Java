package GameEngine;

import GameObjects.Coin;
import GameObjects.Player;
import General.Point;
import General.Util;

public class Match {
    private GameLogic gameLogic;
    private boolean inGame = true;

    public Match(int sizeX, int sizeY){
        gameLogic = new GameLogic(sizeX, sizeY);
    }

    public void play(){
        while(inGame){
            gameLogic.showOptions();
        }
    }
}
