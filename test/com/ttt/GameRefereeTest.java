package com.ttt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameRefereeTest {
	Board board;
	int rows = 3;
	int columns = 3;
	int boardSize;
	GameReferee gameReferee;
	String[] squares;

	@Before
	public void setUp() throws Exception {
		board = new Board(rows, columns);
		boardSize = board.getBoardSize();
		gameReferee = new GameReferee();
	}

	@Test
	public void testCheckIfWinnerOnRow2() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "-");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "-");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnRows(squares));
	}
	
	@Test
	public void testCheckIfWinnerOnRow3() {
		board.setGivenSquare(1, "O");
		board.setGivenSquare(2, "-");
		board.setGivenSquare(3, "-");
		board.setGivenSquare(4, "X");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "X");
		board.setGivenSquare(7, "-");
		board.setGivenSquare(8, "-");
		board.setGivenSquare(9, "O");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnRows(squares));
	}
	
	@Test
	public void testCheckIfWinnerOnRow4() {
		board.setGivenSquare(1, "O");
		board.setGivenSquare(2, "-");
		board.setGivenSquare(3, "-");
		board.setGivenSquare(4, "-");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "-");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnRows(squares));
	}

	@Test
	public void testCheckIfWinnerOnColumn2() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "X");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "O");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnColumns(squares));
	}
	
	@Test
	public void testCheckIfWinnerOnColumn3() {
		board.setGivenSquare(1, "O");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "-");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "-");
		board.setGivenSquare(7, "-");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "-");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnColumns(squares));
	}
	
	@Test
	public void testCheckIfWinnerOnColumn4() {
		board.setGivenSquare(1, "O");
		board.setGivenSquare(2, "-");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "-");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "X");
		board.setGivenSquare(7, "-");
		board.setGivenSquare(8, "-");
		board.setGivenSquare(9, "X");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnColumns(squares));
	}

	@Test
	public void testCheckIfWinnerOnDiagonal2() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnDiagonals(squares));
	}
	
	@Test
	public void testCheckIfWinnerOnDiagonal3() {
		board.setGivenSquare(1, "O");
		board.setGivenSquare(2, "-");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "-");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "-");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "-");
		board.setGivenSquare(9, "O");
		squares = board.getSquares();
		assertEquals("X", gameReferee.checkIfWinnerOnDiagonals(squares));
	}

	@Test
	public void testBoardFilledIsTrue() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		assertEquals(true, gameReferee.isBoardFilled(board));
	}
	
	@Test
	public void testBoardFilledIsFalse() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "-");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		assertEquals(false, gameReferee.isBoardFilled(board));
	}

	@Test
	public void testIsGameOverBecauseWinnerOnRows() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "X");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "O");
		assertEquals(true, gameReferee.isGameOver(board));
	}
	
	@Test
	public void testIsGameOverBecauseWinnerOnColumns() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "X");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "O");
		assertEquals(true, gameReferee.isGameOver(board));
	}

	@Test
	public void testIsGameOverBecauseWinnerOnDiagonals() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		assertEquals(true, gameReferee.isGameOver(board));
	}
	
	@Test
	public void testIsGameOverBecauseBoardFilledAndNoWinner() {
		board.setGivenSquare(1, "O");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "X");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "X");
		assertTrue(gameReferee.isGameOver(board));
	}

	@Test
	public void testPlayerWithXIsWinnerOnRows() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "X");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "O");
		squares = board.getSquares();
		assertEquals("X", gameReferee.whoIsWinner(board));
	}
	
	@Test
	public void testPlayerWithXIsWinnerOnColumns() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "X");
		board.setGivenSquare(4, "X");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "O");
		squares = board.getSquares();
		assertEquals("X", gameReferee.whoIsWinner(board));
	}
	
	@Test
	public void testPlayerWithXIsWinnerOnDiagonals() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		squares = board.getSquares();
		assertEquals("X", gameReferee.whoIsWinner(board));
	}

	@Test
	public void tesTieIsTrue() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "X");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "X");
		assertEquals(true, gameReferee.isTie(board));
	}
	
	@Test
	public void tesTieIsFalse() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		assertEquals(false, gameReferee.isTie(board));
	}
}
