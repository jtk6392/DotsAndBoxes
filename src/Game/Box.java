package DotsAndBoxes.src.Game;

public class Box {

    //Fields
    private boolean north;
    private boolean south;
    private boolean east;
    private boolean west;
    private int claimed;

    //Constructor for
    public Box(){
        north = false;
        south = false;
        east = false;
        west = false;
        claimed = 0;
    }

    public int checkClaimed(Users player){
        if(this.north && this.south && this.east && this.west){
            //Based on which player's turn it is.
            if(player == Users.Player) {
                this.claimed = 1;
            } else {
                this.claimed = 2;
            }
        }
        return this.claimed;
    }

}


