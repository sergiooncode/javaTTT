package com.ttt;

public class Board {
	private int boardSize;
	private String[] squares;
	private int rows, columns;
	
	public Board(int rows , int columns) {
		this.rows = rows;
		this.columns = columns;
		boardSize = this.rows*this.columns;
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
		if (squares[position - 1].equals("-")) {
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
			if(squares[k].equals("-")) {
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