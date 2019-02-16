package HardCodeAI;

import Game.Board;
import Game.Box;
import Game.Users;
import java.util.Random;

public class AI {
    private Board currentBoard;
    private Users player;
    private final static Random rng = new Random();

    public AI(Board currentBoard, Users player) {
        this.currentBoard = currentBoard;
        this.player = player;
    }

    private boolean checkBox(int i, int j, Box.Side side){
        Box box1 = currentBoard.getBox(i, j);
        return checkBox(box1);
    }

    private boolean checkBox(Box b){
        int filledSides = 0;

        if (b.getSide(Box.Side.NORTH ){
            filledSides++;
        }
        if (b.getSide(Box.Side.SOUTH){
            filledSides++;
        }
        if (b.getSide(Box.Side.EAST){
            filledSides++;
        }
        if (b.getSide(Box.Side.WEST){
            filledSides++;
        }
        return (filledSides<=2);
    }

    private boolean checkMove(int i, int j, Box.Side side) {
        Box newBox = currentBoard.getPartner(i, j, side);

        return checkBox(i, i, side) && checkBox(newBox);
    }

    private boolean determinePointMove() {
        for (int i = 0; i < currentBoard.getBoardSize(); i++) {
            for (int j = 0; j < currentBoard.getBoardSize(); j++) {
                Box currentBox =
            }
        }

        return false;
    }

    private boolean determineSafeMove() {
        return false;
    }

    private void randomMove() {
        int i, j, max, s;
        Box.Side side = null;
        max = 0;

        i = rng.nextInt(max) + 1;
        j = rng.nextInt(max) + 1;
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
            Board.Play(side, this.player, i, j);
        }
    }

    public void makePlay(Board currentBoard) {
        this.currentBoard = currentBoard;
        boolean madeMove = false;
        while (!madeMove) {

            if (!determinePointMove() && determineSafeMove()) {
                randomMove();
                madeMove = true;
            }

            if (determinePointMove() && determineSafeMove() && !madeMove) {
                // take Point move
                madeMove = true;
            }

            if (determinePointMove() && !determineSafeMove() && !madeMove) {
                // recurse
                madeMove = true;
            }

            if (!determinePointMove() && !determineSafeMove() && !madeMove) {
                //
                madeMove = true;
            }
        }
    }
}
