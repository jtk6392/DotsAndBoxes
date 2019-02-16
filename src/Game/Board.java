package Game;

public class Board {

    private int i = 4;
    private int j = 4;
    private Box boxArray[][] = new Box[i][j];
    private int score[]= new int[3];


    public Board(){
        score[2] = i*j;
    }

    public Board(int i, int j){
        this.i = i;
        this.j = j;
        score[2] = i*j;
    }

    public int getBoardSize(){
        return this.boxArray.length;
    }

    public Box getBox(int i, int j){
        return boxArray[i][j];
    }

    public static void Play(Box.Side bs, Users player, int i, int j){

    }

    public static void claimSharedSide(Box.Side s, int i, int j){

    }

    @Override
    public String toString()
    {
        return "No";
    }

    public static void Win(){

    }

    public Box hasPartner(int i, int j, Game.Box.Side s){
        switch(s) {
            case EAST && i == getBoardSize(): return this.boxArray[i+1][j];
            case WEST: return this.boxArray[i-1][j];
            case NORTH: return this.boxArray[i][j+1];
            case SOUTH: return this.boxArray[i][j-1];
        }
    }

    public Box getPartner(int i, int j, Game.Box.Side s){
        switch(s) {
            case EAST: return this.boxArray[i+1][j];
            case WEST: return this.boxArray[i-1][j];
            case NORTH: return this.boxArray[i][j+1];
            case SOUTH: return this.boxArray[i][j-1];
        }
    }

}
