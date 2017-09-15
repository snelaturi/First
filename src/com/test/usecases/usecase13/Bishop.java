package com.test.usecases.usecase13;

public class Bishop extends Piece{

	public Bishop(boolean available, int x, int y) {
        super(available, x, y);
    }

    @Override
    public boolean isValid(ChessBoard board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;

        if(toX - fromX == toY - fromY)
            return true;

        return false;
    }
}
