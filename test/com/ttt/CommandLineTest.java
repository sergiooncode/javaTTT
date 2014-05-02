package com.ttt;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.IOException;

import org.junit.Test;

public class CommandLineTest {
	final String newLine = System.getProperty("line.separator");
	private UserInterface userInterface;
	private CommandLine commandLine;
	private Scanner scanner;

	@Test
	public void testWelcomeMessage() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printWelcomeMessage();
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith(newLine));
		assertTrue(output.contains("               ------------------Welcome to Tic Tac Toe game------------------               "));
		assertTrue(output.contains(newLine));
	}

	@Test
	public void testAnnounceMachinePlayerToken() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printMachinePlayerToken(1, "X");
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Machine player 1 plays with token X"));
		assertTrue(output.contains(newLine));
	}

	@Test
	public void testAskForPlayerType() throws IOException{
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.askForPlayerType(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Type h or m to choose the type of player 1 who will move in first place: (h)uman or (m)achine"));
	}
	
	@Test
	public void testGetPlayerTypeWhenIsInvalidFirstTime() throws IOException{
		scanner = new Scanner("g h ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.getPlayerType(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Type h or m to choose the type of player 1 who will move in first place: (h)uman or (m)achine"));
		assertTrue(output.contains("Please enter a valid type:"));
	}
	
	@Test
	public void testGetPlayerTypeAndReturnsHuman() throws IOException{
		scanner = new Scanner("h ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		userInterface = new CommandLine(scanner, out);
		assertEquals("h", userInterface.getPlayerType(1));
	}
	
	@Test
	public void testGetPlayerTypeAndReturnsMachine() throws IOException{
		scanner = new Scanner("m ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		userInterface = new CommandLine(scanner, out);
		assertEquals("m", userInterface.getPlayerType(1));
	}
	
	@Test
	public void testGetPlayerTypeAndIsValidButUppercase() throws IOException{
		scanner = new Scanner("M ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		userInterface = new CommandLine(scanner, out);
		assertEquals("m", userInterface.getPlayerType(1));
	}
	
	@Test
	public void testGetPlayerTypeAndIsInvalidAndUppercase() throws IOException{
		scanner = new Scanner("J H ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.getPlayerType(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Type h or m to choose the type of player 1 who will move in first place: (h)uman or (m)achine"));
		assertTrue(output.contains("Please enter a valid type:"));
	}


	@Test
	public void testPrintHumanPlayerToken() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printHumanPlayerToken(1, "X");
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Human player 1 plays with token X"));
		assertTrue(output.contains(newLine));
	}
	
	@Test
	public void testPrintMachinePlayerToken() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printMachinePlayerToken(1, "X");
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Machine player 1 plays with token X"));
		assertTrue(output.contains(newLine));
	}
	
	@Test
	public void testPrintMessageBeforeShowingBoardLabeling() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printMessageBeforeShowingBoardLabeling();
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("The moves must be entered according to the following labels:"));
		assertTrue(output.contains(newLine));
	}

	@Test
	public void testPrintSquares() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		String[] squares = {"O", "X", "O", "-", "X", "X", "-", "X", "O"};
		Board board = new Board(squares);
		userInterface = new CommandLine(scanner, out);
		userInterface.printSquares(board);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("    __    __    __  "));
		assertTrue(output.contains(newLine));
		assertTrue(output.contains("  |  O  |  X  |  O  |  "));
		assertTrue(output.contains(newLine));
		assertTrue(output.contains("    __    __    __  "));
		assertTrue(output.contains(newLine));
		assertTrue(output.contains("  |  4  |  X  |  X  |  "));
		assertTrue(output.contains(newLine));
		assertTrue(output.contains("    __    __    __  "));
		assertTrue(output.contains(newLine));
		assertTrue(output.contains("  |  7  |  X  |  O  |  "));
		assertTrue(output.contains(newLine));
		assertTrue(output.contains("    __    __    __  "));
		assertTrue(output.contains(newLine));
		assertTrue(output.contains(newLine));
	}
	
	@Test
	public void testAskHumanPlayerForMove() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.askHumanPlayerForMove(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Please human player 1 type the next move:"));
	}
	
	@Test
	public void testAskHumanPlayerForMoveAgain() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.askHumanPlayerForMoveAgain();
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Please enter a valid move:"));
	}
	
	@Test
	public void testPrintMessageMachinePlayerThinking() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printMessageMachinePlayerThinking(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Machine player 1 is thinking its next move..."));
		assertTrue(output.contains(newLine));
	}
	
	@Test
	public void testGetValidBoardPositionFromHumanPlayer() throws IOException{
		scanner = new Scanner("1 ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		assertEquals(1, userInterface.getBoardPositionFromHumanPlayer());
	}
	
	@Test
	public void testGetInvalidBoardPositionFromHumanPlayer() throws IOException{
		scanner = new Scanner("10 1 ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.getBoardPositionFromHumanPlayer();
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Please enter a valid board position:"));
		assertTrue(output.contains(newLine));
	}
	
	@Test
	public void testGetInvalidBoardPositionFromHumanPlayerAndThenAValidOne() throws IOException{
		scanner = new Scanner("10 1 ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		assertEquals(1, userInterface.getBoardPositionFromHumanPlayer());
	}
	
	@Test
	public void testPrintResultOfGameMachineWon() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printResultOfGame("machine", 1);
		final String output = outputBuffer.toString(); 
		assertTrue(output.startsWith("The machine player 1 won."));
	}
	
	@Test
	public void testPrintResultOfGameHumanWon() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printResultOfGame("human", 1);
		final String output = outputBuffer.toString(); 
		assertTrue(output.startsWith("The human player 1 won."));
	}

	@Test
	public void testPrintMessageItWasATie() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		userInterface = new CommandLine(scanner, out);
		userInterface.printMessageItWasATie();
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("It was a tie. Well played."));
	}
	
	@Test
	public void testTypeEnteredIsInvalid() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		assertTrue(commandLine.isTypeEnteredInvalid("g"));
	}
	
	@Test
	public void TestTypeEnteredIsValid() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		assertFalse(commandLine.isTypeEnteredInvalid("h"));
	}
	
	@Test
	public void testBoardPositionEnteredIsInvalid() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		assertTrue(commandLine.isBoardPositionInvalid("10"));
	}
	
	@Test
	public void testBoardPositionEnteredIsValid() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		assertFalse(commandLine.isBoardPositionInvalid("1"));
	}
}
