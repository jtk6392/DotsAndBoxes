package HardCodeAI;

import Game.Board;
import Game.Users;
import java.util.Random;
public class AI {
    private Board currentBoard;
    private Users player;

    public AI(Board currentBoard, Users player) {
        this.currentBoard = currentBoard;
        this.player = player;
    }
    private boolean determinePointMove() {
        return false;
    }

    private boolean determineSafeMove() {
        return false;
    }

    public void makePlay(Board currentBoard) {
        this.currentBoard = currentBoard;
        boolean madeMove = false;
        int i, j;

        if(!determinePointMove() && determineSafeMove()) {

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
