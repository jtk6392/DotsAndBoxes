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
        int filledSides = 0;
        Box box1 = currentBoard.getBox(i, j);
        if (box1.getSide(Box.Side.NORTH ){
            filledSides++;
        }
        if (box1.getSide(Box.Side.SOUTH){
            filledSides++;
        }
        if (box1.getSide(Box.Side.EAST){
            filledSides++;
        }
        if (box1.getSide(Box.Side.WEST){
            filledSides++;
        }
        return (filledSides<=2);
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
        for (int i=0; i<currentBoard.getBoardSize(); i++){
            for (int j=0; j<currentBoard.getBoardSize(); j++){
                Box currentBox =
            }
        }

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
