package DotsAndBoxes.src.Game;

public class Board {

    private int i = 4;
    private int j = 4;
    private DotsAndBoxes.src.Game.Box boxArray[][] = new DotsAndBoxes.src.Game.Box[i][j];
    private int score[]= new int[3];


    public Board(){
        score[2] = i*j;
    }

    public Board(int i, int j){
        this.i = i;
        this.j = j;
        score[2] = i*j;
    }

    public static void Play(DotsAndBoxes.src.Game.Box.Side bs, DotsAndBoxes.src.Game.Users player, int i, int j){

    }

    public static void claimSharedSide(DotsAndBoxes.src.Game.Box.Side s, int i, int j){

    }

    @Override
    public String toString()
    {
        return "No";
    }

    public static void Win(){

    }

    public static DotsAndBoxes.src.Game.Box getPartner(){
        return new DotsAndBoxes.src.Game.Box();
    }

}
