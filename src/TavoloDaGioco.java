class TavoloDaGioco{

    private int gameSize;
    private int[][] board;

    public TavoloDaGioco(int size){
        setGameSize(size);
    }



    private char getChar(int i){
        switch (i) {
            case 0 : return ' ';
            case 1 : return Giocatore.CHARACTER;
            case 2 : return Moneta.CHARACTER;
            default: return  ' ';
        }
    }

    public void displayGrid(){
        for(int i = 0; i < gameSize*6+1; i++){
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0; i < gameSize; i++){
            System.out.print("|  ");
            for(int j = 0; j < gameSize; j++){
                System.out.print(getChar(board[i][j]));
                System.out.print("  |  ");
            }
            System.out.println();
            for(int j = 0; j < gameSize*6+1; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void setGameSize(int size){
        if(size > 0){
            this.gameSize = size;
            this.board = new int[size][size];
        }
    }

    public void setValue(Point coordinate, Values value) {
        board[coordinate.getX()][coordinate.getY()] = value.ordinal();
    }
}