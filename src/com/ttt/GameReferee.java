package com.ttt;

public class GameReferee {	
	public String checkIfWinnerOnRows(String[] squares) {
		int startingRow = 0;
		String winner = "\0";
		while(startingRow < 7) {
			if(squares[startingRow] != "-" && squares[startingRow] == squares[startingRow + 1] && squares[startingRow] == squares[startingRow + 2]) {
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
			if(squares[startingColumn] != "-" && squares[startingColumn] == squares[startingColumn + 3] && squares[startingColumn] == squares[startingColumn + 6]) {
				winner = squares[startingColumn];
			}
			startingColumn = startingColumn + 1;
		}
		return winner;
	}
	
	public String checkIfWinnerOnDiagonals(String[] squares) {
		int startingDiagonal = 0;
		String winner = "\0";
		if(squares[startingDiagonal] != "-" && squares[startingDiagonal] == squares[startingDiagonal + 4] && squares[startingDiagonal] == squares[startingDiagonal + 8]) {
			winner = squares[startingDiagonal];
		}
		startingDiagonal = startingDiagonal + 6;
		if(squares[startingDiagonal] != "-" && squares[startingDiagonal] == squares[startingDiagonal - 2] && squares[startingDiagonal] == squares[startingDiagonal - 4]) {
			winner = squares[startingDiagonal];
		}
		return winner;
	}
	
	public boolean isBoardFilled(Board board) {
		return board.isFilled();
	}
	
	public boolean isGameOver(Board board) {
		String[] squares = board.getSquares();
		boolean gameOver = false;
		if(checkIfWinnerOnRows(squares) != "\0" || checkIfWinnerOnColumns(squares) != "\0" || checkIfWinnerOnDiagonals(squares) != "\0") {
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
		if(checkIfWinnerOnRows(squares) != "\0") {
			winner = checkIfWinnerOnRows(squares);
		}
		if(checkIfWinnerOnColumns(squares) != "\0") {
			winner = checkIfWinnerOnColumns(squares);
		}
		if(checkIfWinnerOnDiagonals(squares) != "\0") {
			winner = checkIfWinnerOnDiagonals(squares);
		}
		return winner;
	}
	
	public boolean isTie(Board board) {
		String[] squares = board.getSquares();
		boolean tie = false;
		if(isBoardFilled(board)) {
			if(checkIfWinnerOnRows(squares) == "\0" && checkIfWinnerOnColumns(squares) == "\0" && checkIfWinnerOnDiagonals(squares) == "\0") {
				tie = true;
			}
		}
		return tie;
	}
}
