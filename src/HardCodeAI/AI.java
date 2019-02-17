package HardCodeAI;

import Game.Board;
import Game.Box;
import Game.Users;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that represents the AI enemy in dots and boxes.
 */
public class AI {
    private Board currentBoard;
    private Users player;
    private final static Random rng = new Random();

    /**
     * creates an instance of AI
     *
     * @param currentBoard the Board that the AI and player use
     * @param player       idk
     */
    public AI(Board currentBoard, Users player) {
        this.currentBoard = currentBoard;
        this.player = player;
    }

    /**
     * returns number of claimed edges around a box
     *
     * @param i x coordinate of box
     * @param j y coordinate of box
     * @return integer corresponding to number of claimed sizes
     */
    private int claimedEdges(int i, int j) {
        Box box1 = currentBoard.getBox(i, j);
        return claimedEdges(box1);
    }

    /**
     * returns number of claimed edges around a box
     *
     * @param b the Box we are looking at
     * @return integer corresponding to number of claimed sizes
     */
    private int claimedEdges(Box b) {
        int filledSides = 0;
        for (Box.Side s : Box.Side.values()) {
            if (b.getSide(s)) {
                filledSides++;
            }
        }

        return filledSides;
    }

    /**
     * checks to see if a move will create a new box with 3 claimed edges
     *
     * @param i x coordinate of box
     * @param j y coordinate of box
     * @param side side that we want to test
     * @return boolean whether or not the move is good
     */
    private boolean checkMove(int i, int j, Box.Side side) {
        if (currentBoard.hasPartner(currentBoard.getBox(i, j), side)) {
            Box newBox = currentBoard.getPartner(i, j, side);
            return claimedEdges(i, j) <= 2 && claimedEdges(newBox) <= 2;
        } else {
            return claimedEdges(i, j) <= 2;
        }

    }

    /**
     * tests to see if a box has only one unclaimed edge
     *
     * @param b Box b to check
     * @return true or false if box only has one unclaimed side
     */
    private boolean scorableBox(Box b) {
        return claimedEdges(b) == 3;
    }

    /**
     * tests to see if a box has only one unclaimed edge
     *
     * @param i x coordinate of box
     * @param j y coordinate of box
     * @return true or false if box only has one unclaimed side
     */
    private boolean scorableBox(int i, int j) {
        return scorableBox(currentBoard.getBox(i, j));
    }


    /**
     * looks through board array and determines if there is at least one box that satisfies scorableBox
     *
     * @return true or false if move is viable
     */
    private ArrayList<Box> determinePointMove() {

        ArrayList<Box> pointMoves = new ArrayList<>(0);
        for (int i = 0; i < currentBoard.getBoardSize(); i++) {
            for (int j = 0; j < currentBoard.getBoardSize(); j++) {
                if (scorableBox(i, j)) {
                    pointMoves.add(this.currentBoard.getBox(i,j));
                }
            }
        }
        return pointMoves;
    }
    /**
     * looks through Board array and determines if there is at least one move that satisfies checkMove
     *
     * @return true or false if move is viable
     */
    private boolean determineSafeMove() {
        for (int i = 0; i < currentBoard.getBoardSize(); i++) {
            for (int j = 0; j < currentBoard.getBoardSize(); j++) {
                for (Box.Side s : Box.Side.values()) {
                    if (checkMove(i, j, s)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * selects a random move that will not cause the other player to have a scorable box
     */
    private boolean randomMove() {
        int i, j, max, s;
        Box.Side side = null;
        max = this.currentBoard.getBoardSize();
        i = rng.nextInt(max);
        j = rng.nextInt(max);
        s = rng.nextInt(4);
        switch (s) {
            case 0:
                side = Box.Side.EAST;
                break;
            case 1:
                side = Box.Side.SOUTH;
                break;
            case 2:
                side = Box.Side.WEST;
                break;
            case 3:
                side = Box.Side.NORTH;
        }
        if (checkMove(i, j, side)) {
            this.currentBoard.Play(side, this.player, i, j);
            return true;
        } else {
            return false;
        }
    }

    /**
     * complete AI logic
     *
     * @param currentBoard board that the AI plays on
     */
    public void makePlay(Board currentBoard) {
        this.currentBoard = currentBoard;
        boolean madeMove = false;
        while (!madeMove) {

            if (determinePointMove().size() > 0 && !determineSafeMove() && !madeMove) {
                //
                madeMove = true;
            }

            if (determinePointMove().size() > 0 && !determineSafeMove() && !madeMove) {
                // recurse
                madeMove = true;
            }

            if (determinePointMove().size() > 0 && determineSafeMove() && !madeMove) {
                // take Point move box
                madeMove = true;
            }

            if (determinePointMove().size() > 0 && determineSafeMove() && !madeMove) {
                randomMove();
                madeMove = true;
            }
        }
    }

    public static void main(String[] args) {
        boolean madePlay;
        AI HAL = new AI(new Board(2), Users.PLAYER1);
        for(int i = 0; i < 12; i++) {
            madePlay = false;
            while(!madePlay) {
                madePlay = HAL.randomMove();
            }
        }
        HAL.currentBoard.completePrint();
    }
}

