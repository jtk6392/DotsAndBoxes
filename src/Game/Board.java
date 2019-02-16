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
        boxArray = new Box[4][4];
        score = new int[3];
        score[2] = 16;
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
        score = new int[3];
        score[2] = i * j;  // total score
    }

    /**
     * Sets the state of the side of the box to true
     * and update and check and see if a box if finished
     *
     * @param B      a box object that gets passed in]
     * @param bs     box side
     * @param player the player
     * @param i      index of the row
     * @param j      index of the column
     */
    public static void Play(Box B, Box.Side bs, Users player, int i, int j) {
//        B.checkSide(bs)
    }

    public static void claimSharedSide(Box.Side s, int i, int j) {

    }

    @Override
    public String toString() {
        return "No";
    }

    public static void Win() {

    }

    public static Box getPartner() {
        return new Box();
    }

}