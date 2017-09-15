package com.test.usecases.usecase13;

public class ChessBoard {
	
	 private Spot[][] spots = new Spot[8][8];

	    public ChessBoard() {
	        super();
	        for(int i=0; i<spots.length; i++){
	            for(int j=0; j<spots.length; j++){
	                this.spots[i][j] = new Spot(i, j);
	            }
	        }
	    }

	    public Spot getSpot(int x, int y) {
	        return spots[x][y];
	    }

}
