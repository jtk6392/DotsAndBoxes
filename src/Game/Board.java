package Game;

public class Board {

    /**
     * Creates the box array for the i and j index.
     */
    private Box[][] boxArray;

    /**
     * Creates score declaration.
     */
    private int[] score;

    /**
     * Creates a standard size for the board if the user does not select
     * a size.
     * Board Size: 4 x 4
     */
    public Board() {
        this(4);
    }

    /**
     * score[0]: total player 1
     * score[1]: total player 2
     * score[2]: total score
     *
     * @param n The length of the sides of the board.
     */
    public Board(int n) {
        boxArray = new Box[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boxArray[i][j] = new Box(i, j);
            }
        }
        score = new int[3];
        score[2] = n*n;  // total score
    }

    public int getBoardSize() {
        return this.boxArray.length;
    }

    /**
     * Sets the state of the size of the box to true
     * and update and check and see if a box if finished
     *
     * @param bs     box side
     * @param player the player
     * @param i      index of the row
     * @param j      index of the column
     */
    public static void Play(Box.Side bs, Users player, int i, int j) {

    }


    public static void claimSharedSide(int i, int j, Box.Side s) {

    }

    /**
     * Returns a string representation of the board.
     * @return An n*n string representing the board for debugging.
     */
    @Override
    public String toString() {
        String outString = "";
        int[] claims = new int[this.boxArray.length * this.boxArray.length];
        for(int i = 0; i < this.boxArray.length; i++){
            for(int j = 0; j < this.boxArray.length; j++) {
                claims[i+j] = this.boxArray[i][j].getClaimed();
            }
        }
        for(int i = 0; i < claims.length; i++) {
            outString += claims[i] + " ";
            if(i%this.boxArray.length == 0) {
                outString += "\n";
            }
        }
        return outString;
    }

    /**
     * hurray?
     */
    public static void Win() {

    }

    /**
     * Checks if a box at a specific index has an adjacent side.
     * @param i the column of the box
     * @param j the row of the box
     * @param s the side to check
     * @return True if there is a box adjacent to the current box.
     */
    public boolean hasPartner(int i, int j, Game.Box.Side s) {
        return hasPartner(getBox(i, j), s);
    }

    /**
     * Checks if a box at a specific index has an adjacent side.
     * @param b the box to check for adjacents
     * @param s the side to check.
     * @return True if there is a box adjacent to the current box.
     */
    public boolean hasPartner(Box b, Game.Box.Side s) {
        switch (s) {
            case EAST:
                return b.getxVal() == getBoardSize();
            case WEST:
                return b.getxVal() == 0;
            case NORTH:
                return b.getyVal() == 0;
            case SOUTH:
                return b.getyVal() == getBoardSize();
            default:
                return false; // Should never reach
        }
    }

    /**
     * Overload of getPartner
     * @param i the column of the box
     * @param j the row of the box
     * @param s the side to check
     * @return The 'partner' box
     */
    public Box getPartner(int i, int j, Game.Box.Side s) {
        return getPartner(getBox(i, j), s);
    }

    /**
     * Gets the partner to the box.
     * @param b the box to check for partners
     * @param s the side to check.
     * @return a box object that is adjacent to b.
     */
    public Box getPartner(Box b, Game.Box.Side s) {
        switch (s) {
            case EAST:
                return this.boxArray[b.getxVal() + 1][b.getyVal()];
            case WEST:
                return this.boxArray[b.getxVal() - 1][b.getyVal()];
            case NORTH:
                return this.boxArray[b.getxVal()][b.getyVal() + 1];
            case SOUTH:
                return this.boxArray[b.getxVal()][b.getyVal() - 1];
            default: return null; // Should never reach
        }
    }

    /**
     * Returns a box at a given index in the board.
     * @param i the column of the box
     * @param j the row of the box.
     * @return A box.
     */
    public Box getBox(int i, int j) {
        return boxArray[i][j];
    }

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println("test");
        System.out.println(b);
    }
}