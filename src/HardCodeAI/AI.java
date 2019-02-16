package HardCodeAI;

import Game.Board;

public class AI {
    private Board currentBoard;
    public AI(Board currentBoard) {
        this.currentBoard = currentBoard;
    }
    public boolean determinePointMove() {
        return false;
    }

    public boolean determineSafeMove() {
        return false;
    }

    public void makePlay(Board currentBoard) {
        this.currentBoard = currentBoard;

    }
}
