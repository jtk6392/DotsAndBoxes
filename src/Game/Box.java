package DotsAndBoxes.src.Game;

public class Box {

    public enum Side{
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

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

    public boolean checkSide(Side s) {
        switch(s) {
            case EAST: return this.east;
            case WEST: return this.west;
            case NORTH: return this.north;
            case SOUTH: return this.south;
            default: return false;
        }
    }

    public int checkClaimed(Users player){
        if(this.north && this.south && this.east && this.west){
            //Based on which player's turn it is.
            if(player == Users.PLAYER1) {
                this.claimed = 1;
            } else {
                this.claimed = 2;
            }
        }
        return this.claimed;
    }

}


