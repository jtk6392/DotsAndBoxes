package DotsAndBoxes.src.Game;

public class Box {

    //Fields
    boolean north;
    boolean south;
    boolean east;
    boolean west;
    int claimed;

    //Constructor for
    public Box(){
        north = false;
        south = false;
        east = false;
        west = false;
        claimed = 0;
    }

    public int checkClaimed(){
        if(north == true && south == true && east == true && west == true){
            //Based on which player's turn it is.
            claimed = 1;
            claimed =2;
        }
        return claimed;
    }

}


