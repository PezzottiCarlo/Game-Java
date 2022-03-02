public class LogicaDiGioco {

    public void fight(Giocatore g1, Giocatore g2) {
        int g1Score = Dado.lanzar();
        int g2Score = Dado.lanzar();
        if (g1Score > g2Score){
            //aggiungere 1 allo score del primo giocatore e togliere 1 dallo score del secondo
        }else{
            //viceversa
        }
    }

    public Giocatore getWinner(){
        return null;
    }

    public void move(Giocatore giocatore, Point coordinate, Direction direction){
        switch (direction){
            case NORTH :
                break;
            case SOUTH :
                break;
            case EAST :
                break;
            case WEST :
                break;
        }
    }

    private boolean onCoin(Point coordinate){
        return false;
    }
}
