package com.ttt;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnbeatableAITest {
	private static final int INFINITY = 1000000;
	CommandLine commandLine;
	Board board;
	final String newLine = System.getProperty("line.separator");
	Scanner scanner;
	UnbeatableAI unbeatableAI;
	String currentPlayer;
	int rows = 3;
	int columns = 3;
	
	@Before
	public void setUp() throws Exception {
		board = new Board(rows, columns);
		unbeatableAI = new UnbeatableAI(board, "X");
		currentPlayer = "X";
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		commandLine = new CommandLine(scanner, out);
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

//	@Test
//	public void testNegamaxAlgorithmMethod() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testGenerateMove() {
		fail("Not yet implemented");
	}

}
