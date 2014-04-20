package com.ttt;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnbeatableAITest {
	static final int INFINITY = 1000000;
	Board board;
	UnbeatableAI unbeatableAI;
	String currentPlayer;
	int rows = 3;
	int columns = 3;
	
	@Before
	public void setUp() throws Exception {
		board = new Board(rows, columns);
		unbeatableAI = new UnbeatableAI(board, "X");
		currentPlayer = "X";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateSquaresWithNewMove() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		String[] squaresWithNewMove = unbeatableAI.generateSquaresWithNewMove(board, 4, "X");
		String[] squaresToCompare = {"X", "O", "O", "O", "X", "-", "O", "X", "X"};
		for(int i=0; i < board.getBoardSize(); i++) {
			assertEquals(squaresWithNewMove[i], squaresToCompare[i]);
		}
	}

	@Test
	public void testGetPlayableMoves() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		ArrayList<Integer> playableMoves = new ArrayList<Integer>();
		playableMoves.add(4);
		playableMoves.add(5);
		assertEquals(playableMoves, unbeatableAI.getPlayableMoves(board));
	}

	@Test
	public void testStaticEvaluationFunction() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "O");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "X");
		board.setGivenSquare(6, "X");
		board.setGivenSquare(7, "O");
		board.setGivenSquare(8, "X");
		board.setGivenSquare(9, "X");
		assertEquals(INFINITY, unbeatableAI.staticEvaluationFunction(currentPlayer, board));
	}
	
	@Test
	public void testAlternatePlayer() {
		assertEquals("O", unbeatableAI.alternatePlayer(currentPlayer));
	}

	@Test
	public void testWhenHasWinningMove() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		int[] negamaxResult = new int[2];
		int maxTreeDepth = board.getBoardSize();
		int currentTreeDepth = 0;
		negamaxResult = unbeatableAI.negamaxAlgorithmMethod(board, currentPlayer, maxTreeDepth, currentTreeDepth);
		assertEquals(INFINITY, negamaxResult[0]);
		assertEquals(2, negamaxResult[1]);
	}
	
	@Test
	public void testWhenMovesForATie() {
		board.setGivenSquare(1, "X");
		board.setGivenSquare(2, "X");
		board.setGivenSquare(3, "O");
		board.setGivenSquare(4, "O");
		board.setGivenSquare(5, "O");
		board.setGivenSquare(6, "X");
		board.setGivenSquare(7, "X");
		board.setGivenSquare(8, "O");
		board.setGivenSquare(9, "-");
		int[] negamaxResult = new int[2];
		int maxTreeDepth = board.getBoardSize();
		int currentTreeDepth = 0;
		negamaxResult = unbeatableAI.negamaxAlgorithmMethod(board, currentPlayer, maxTreeDepth, currentTreeDepth);
		assertEquals(0, negamaxResult[0]);
		assertEquals(8, negamaxResult[1]);
	}

	@Test
	public void testGeneratesValidMoveWhenBoardEmpty() {
		int[] negamaxResult = new int[2];
		int maxTreeDepth = board.getBoardSize();
		int currentTreeDepth = 0;
		negamaxResult = unbeatableAI.negamaxAlgorithmMethod(board, currentPlayer, maxTreeDepth, currentTreeDepth);
		assertEquals(0, negamaxResult[0]);
		assertEquals(0, negamaxResult[1]);
	}
	
	@Test
	public void testGeneratesValidMoveAfterHumanPlayer() {
		board.setGivenSquare(1, "O");
		int[] negamaxResult = new int[2];
		int maxTreeDepth = board.getBoardSize();
		int currentTreeDepth = 0;
		negamaxResult = unbeatableAI.negamaxAlgorithmMethod(board, currentPlayer, maxTreeDepth, currentTreeDepth);
		assertEquals(0, negamaxResult[0]);
		assertEquals(4, negamaxResult[1]);
	}
}
