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

    public static void Play(Game.Box.Side bs, Users player, int i, int j){

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

    public static Box getPartner(){
        return new Box();
    }

}
