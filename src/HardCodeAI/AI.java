package HardCodeAI;

import DotsAndBoxes.src.Game.Board;
import DotsAndBoxes.src.Game.Users;
import java.util.Random;

public class AI {
    private Board currentBoard;
    private Users player;
    private final static Random rng = new Random();

    public AI(Board currentBoard, Users player) {
        this.currentBoard = currentBoard;
        this.player = player;
    }
    private boolean determinePointMove() {
        for (int i; i<currentBoard.)

        return false;
    }

    private boolean determineSafeMove() {
        return false;
    }


    public void makePlay(Board currentBoard) {
        this.currentBoard = currentBoard;
        boolean madeMove = false;
        int i, j, max;

        if(!determinePointMove() && determineSafeMove()) {
            max = 0;
            i = rng.nextInt(max + 1);
            j = rng.nextInt(max + 1);
            madeMove = true;
        }
        if(determinePointMove() && determineSafeMove() && !madeMove) {
            // take Point move
            madeMove = true;
        }
        if(determinePointMove() && !determineSafeMove() && !madeMove) {
            // recurse
            madeMove = true;
        }
        if(!determinePointMove() && !determineSafeMove() && !madeMove) {
            //
            madeMove = true;
        }
    }
}
