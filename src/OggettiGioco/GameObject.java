package OggettiGioco;

public abstract class GameObject{
    private Point coordinate;
    private char character;

    public GameObject(Point coordinate, char character){
        this.coordinate = coordinate;
        this.character = character;
    }

    public Point getCoordinate(){
        return coordinate;
    }

    public void setCoordinate(Point coordinate){
        this.coordinate = coordinate;
    }

    public char getCharacter(){
        return character;
    }
}
