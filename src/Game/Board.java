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
    public static void Play(Box.Side bs, Users player, int i, int j) {

    }


    public static void claimSharedSide(int i, int j, Box.Side s) {

    }

    @Override
    public String toString() {
        return "No";
    }

    public static void Win() {

    }

    public boolean hasPartner(int i, int j, Game.Box.Side s) {
        return hasPartner(getBox(i, j), s);
    }

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
        }
    }

    public Box getPartner(int i, int j, Game.Box.Side s) {
        return getPartner(getBox(i, j), s);
    }

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
        }
    }

    public Box getBox(int i, int j) {
        return boxArray[i][j];
    }

}