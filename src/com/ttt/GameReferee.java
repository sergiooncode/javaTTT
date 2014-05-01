package com.ttt;

public class GameReferee {	
	public String checkIfWinnerOnRows(String[] squares) {
		int startingRow = 0;
		String winner = "\0";
		while(startingRow < 7) {
			if(!squares[startingRow].equals("-") && squares[startingRow].equals(squares[startingRow + 1]) && squares[startingRow].equals(squares[startingRow + 2])) {
				winner = squares[startingRow];
			}
			startingRow = startingRow + 3;
		}
		return winner;
	}
	
	public String checkIfWinnerOnColumns(String[] squares) {
		int startingColumn = 0;
		String winner = "\0";
		while(startingColumn < 3) {
			if(!squares[startingColumn].equals("-") && squares[startingColumn].equals(squares[startingColumn + 3]) && squares[startingColumn].equals(squares[startingColumn + 6])) {
				winner = squares[startingColumn];
			}
			startingColumn = startingColumn + 1;
		}
		return winner;
	}
	
	public String checkIfWinnerOnDiagonals(String[] squares) {
		int startingDiagonal = 0;
		String winner = "\0";
		if(!squares[startingDiagonal].equals("-") && squares[startingDiagonal].equals(squares[startingDiagonal + 4]) && squares[startingDiagonal].equals(squares[startingDiagonal + 8])) {
			winner = squares[startingDiagonal];
		}
		startingDiagonal = startingDiagonal + 6;
		if(!squares[startingDiagonal].equals("-") && squares[startingDiagonal].equals(squares[startingDiagonal - 2]) && squares[startingDiagonal].equals(squares[startingDiagonal - 4])) {
			winner = squares[startingDiagonal];
		}
		return winner;
	}
	
	public boolean isBoardFilled(Board board) {
		boolean filled = true;
		for(int k = 0; k < board.getBoardSize(); k++) {
			if(board.isSquareEmpty(k + 1)) {
				filled = false;
			}
		}
		return filled;
	}
	
	public boolean isGameOver(Board board) {
		String[] squares = board.getSquares();
		boolean gameOver = false;
		if(!checkIfWinnerOnRows(squares).equals("\0") || !checkIfWinnerOnColumns(squares).equals("\0") || !checkIfWinnerOnDiagonals(squares).equals("\0")) {
			gameOver = true;
		}
		if(isBoardFilled(board)) {
			gameOver = true;
		}
		return gameOver;
	}
	
	public String whoIsWinner(Board board) {
		String[] squares = board.getSquares();
		String winner = "\0";
		if(!checkIfWinnerOnRows(squares).equals("\0")) {
			winner = checkIfWinnerOnRows(squares);
		}
		if(!checkIfWinnerOnColumns(squares).equals("\0")) {
			winner = checkIfWinnerOnColumns(squares);
		}
		if(!checkIfWinnerOnDiagonals(squares).equals("\0")) {
			winner = checkIfWinnerOnDiagonals(squares);
		}
		return winner;
	}
	
	public boolean isTie(Board board) {
		String[] squares = board.getSquares();
		boolean tie = false;
		if(isBoardFilled(board)) {
			if(checkIfWinnerOnRows(squares).equals("\0") && checkIfWinnerOnColumns(squares).equals("\0") && checkIfWinnerOnDiagonals(squares).equals("\0")) {
				tie = true;
			}
		}
		return tie;
	}
}
