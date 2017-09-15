package com.test.usecases.usecase13;

public class ChessGame {
	private ChessBoard board = new ChessBoard();
    private Player white;
    private Player black;
    public ChessGame() {
        super();
    }

    public void setColorWhite(Player player) {
        this.white = player;
    }

    public void setColorBlack(Player player) {
        this.black = player;
    }

    public ChessBoard getBoard() {
		return board;
	}

	public void setBoard(ChessBoard board) {
		this.board = board;
	}

	public Player getWhite() {
        return white;
    }

    public void setWhite(Player white) {
        this.white = white;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(Player black) {
        this.black = black;
    }

    public boolean initializeBoardGivenPlayers() {
        if(this.black == null || this.white == null)
            return false;
        this.board = new ChessBoard();
        for(int i=0; i<black.getPieces().size(); i++){
            board.getSpot(black.getPieces().get(i).getX(), black.getPieces().get(i).getY()).occupySpot(black.getPieces().get(i));
        }
        return true;
    }


}
