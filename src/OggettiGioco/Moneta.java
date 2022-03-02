package OggettiGioco;

import General.Point;

public class Moneta extends GameObject{

    public Moneta(Point coordinate) {
        super(coordinate, '$');
    }

    public void over(GameObject gameObject) {
        if(gameObject instanceof Giocatore){
            Giocatore g = (Giocatore) gameObject;
            g.setCoin(g.getCoin()+1);
        }
    }
}
