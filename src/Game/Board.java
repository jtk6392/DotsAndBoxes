package Game;

public class Board {

    /**
     * Creates the box array for the i and j index.
     */
    private Box boxArray[][];

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
        this(4, 4);
    }

    /**
     * score[0]: total player 1
     * score[1]: total player 2
     * score[2]: total score
     *
     * @param i index of the row
     * @param j index of the column
     */
    public Board(int i, int j) {
        boxArray = new Box[i][j];
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                boxArray[i][j] = new Box(i, j);
            }
        }
        score = new int[3];
        score[2] = i * j;  // total score
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
    public void Play(Box.Side bs, Users player, int i, int j) {
        boolean boxSide = boxArray[i][j].getSide(bs);
        if (!boxSide) {
            boxArray[i][j].setSide(bs);
        }
        boxArray[i][j].checkClaimed(player);
    }

    /**
     * Checks for the shared side and sees if the side is the boarder of the box
     *
     * @param i index of the row
     * @param j index of the column
     * @param s the side being checked
     */
    public void claimSharedSide(int i, int j, Box.Side s) {
//        boxArray.length
//        int boxPosition = boxArray[i][j].getxVal();
        int xLength = boxArray[i].length;
//        if (xLength + 1) {  // get the length of the row and add one to indicate

        }
    }

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        return "No";
    }

    /**
     *
     */
    public static void Win() {

    }

    public boolean hasPartner(int i, int j, Game.Box.Side s) {
        switch (s) {
            case EAST:
                return i == getBoardSize();
            case WEST:
                return i == 0;
            case NORTH:
                return j == 0;
            case SOUTH:
                return j == getBoardSize();
        }
    }

    public boolean hasPartner(Box b, Game.Box.Side s) {
        switch (s) {
            case EAST:
                return  == getBoardSize();
            case WEST:
                return i == 0;
            case NORTH:
                return j == 0;
            case SOUTH:
                return j == getBoardSize();
        }
    }

    public Box getPartner(int i, int j, Game.Box.Side s) {
        switch (s) {
            case EAST:
                return this.boxArray[i + 1][j];
            case WEST:
                return this.boxArray[i - 1][j];
            case NORTH:
                return this.boxArray[i][j + 1];
            case SOUTH:
                return this.boxArray[i][j - 1];
        }
    }

    public Box getBox(int i, int j){
        return boxArray[i][j];
    }

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println("test");
        System.out.println(b);
    }
}