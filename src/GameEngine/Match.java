package GameEngine;

public class Match {
    private GameLogic gameLogic;
    private boolean inGame = true;

    public Match(int sizeX, int sizeY){
        gameLogic = new GameLogic(sizeX, sizeY);
    }

    public Match(){
        gameLogic = new GameLogic();
    }

    public void play(){
        System.out.println("Let's play!");
        while(inGame){
            gameLogic.showOptions();
            if(gameLogic.isGameOver()){
                inGame = false;
            }
        }
        System.out.println("Thanks for playing");
    }
}
