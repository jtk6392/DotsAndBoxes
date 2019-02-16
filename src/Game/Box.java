package Game;

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

    public void setSide(Side s){
        if(s == Side.EAST){
            east = true;
        }
        if(s == Side.WEST){
            west = true;
        }
        if(s == Side.NORTH){
            north = true;
        }
        if(s == Side.SOUTH){
            south = true;
        }
    }

    public boolean getSide(Side s) {
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


