package com.test.usecases.usecase13;

public class Pawn extends Piece{

	public Pawn(boolean available, int x, int y) {
        super(available, x, y);
    }

	 @Override
	    public boolean isValid(ChessBoard board, int fromX, int fromY, int toX, int toY) {
	        if(super.isValid(board, fromX, fromY, toX, toY) == false)
	            return false;

	        if(toX != fromX - 1 && toX != fromX + 1 && toX != fromX + 2 && toX != fromX - 2)
	            return false;
	        if(toY != fromY - 2 && toY != fromY + 2 && toY != fromY - 1 && toY != fromY + 1)
	            return false;

	        return true;
	    }
}
