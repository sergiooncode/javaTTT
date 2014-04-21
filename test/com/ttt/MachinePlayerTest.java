package com.ttt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MachinePlayerTest {

	MachinePlayer machinePlayer;
	String token;
	int playerOrder;

	@Before
	public void setUp() throws Exception {
		token = "O";
		playerOrder = 2;
		machinePlayer = new MachinePlayer(token, playerOrder);
	}
	
	@Test
	public void testGetPlayerOrder() {
		assertEquals(2, machinePlayer.getPlayerOrder());
	}
	
	@Test
	public void testGetToken() {
		assertEquals("O", machinePlayer.getToken());
	}
	
	@Test
	public void isMachine() {
		assertTrue(machinePlayer.isMachine());
	}

	@Test
	public void testGetNextMove(){
		Board board = new Board(3, 3);
		int position = -1;
		String[] squaresWithNextMove = {"O","-","-","-","-","-","-","-","-"};
		board = machinePlayer.getNextMove(board, position);
		for(int i=0; i < board.getBoardSize(); i++) {
			assertEquals(squaresWithNextMove[i], board.getGivenSquare(i + 1));
		}
	}
}
