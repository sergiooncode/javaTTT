package com.ttt;

public class Board {
	private final int boardSize;
	private String[] squares;
	
	public Board(int rows , int columns) {
		this.boardSize = rows*columns;
		squares = new String[boardSize];
		initSquares(); 
	}	
	
	public Board(String[] givenSquares) {
		this.boardSize = givenSquares.length;
		squares = new String[boardSize];
		for(int k=0; k < givenSquares.length; k++) {
			squares[k] = givenSquares[k];
		}
	}
	
	public void initSquares() {
		for(int j=0; j < boardSize; j++) {
			squares[j] = "-";
		}
	}
	
	public String[] getSquares() {
		return squares;
	}
	
	public boolean isSquareEmpty(int position) {
		if (squares[position - 1] == "-") {
			return true;
		}
		return false;
	}
	
	public int getBoardSize() {
		return boardSize;
	} 
	
	public boolean isFilled() {
		boolean filled = true;
		for(int k=0; k < squares.length; k++) {
			if(squares[k] == "-") {
				filled = false;
			}
		}
		return filled;
	}
	
	public String getGivenSquare(int position) {
		return squares[position - 1];
	}
	
	public void setGivenSquare(int position, String value) {
		squares[position - 1] = value;
	}
}