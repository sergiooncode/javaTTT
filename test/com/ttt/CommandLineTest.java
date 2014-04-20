package com.ttt;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommandLineTest {
	final String newLine = System.getProperty("line.separator");
	CommandLine commandLine;
	Scanner scanner;

	@Before
	public void setUp() throws Exception {
//		commandLine = new CommandLine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWelcomeMessage() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.welcomeMessage();
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith(newLine + newLine));
		assertTrue(output.contains("               ------------------Welcome to Tic Tac Toe game------------------               "));
		assertTrue(output.contains(newLine + newLine));
	}

	@Test
	public void testAnnounceMachinePlayerToken() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.announceMachinePlayerToken(1, "X");
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Machine player 1 plays with token X"));
		assertTrue(output.contains(newLine));
	}

	@Test
	public void testAskForPlayerTypeWhenIsValid() throws IOException{
		scanner = new Scanner("h ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.askForPlayerType(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Type h or m to choose the type of player 1 who will move in first place: (h)uman or (m)achine"));
	}
	
	@Test
	public void testAskForPlayerTypeWhenIsInvalid() throws IOException{
		scanner = new Scanner("g h ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.askForPlayerType(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Type h or m to choose the type of player 1 who will move in first place: (h)uman or (m)achine"));
		assertTrue(output.contains("Please enter a valid type:"));
	}
	
	@Test
	public void testAskForPlayerTypeAndReturnsHuman() throws IOException{
		scanner = new Scanner("h ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		assertEquals("h", commandLine.askForPlayerType(1));
	}
	
	@Test
	public void testAskForPlayerTypeAndReturnsMachine() throws IOException{
		scanner = new Scanner("m ");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		assertEquals("m", commandLine.askForPlayerType(1));
	}


	@Test
	public void testAnnounceHumanPlayerToken() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.announceHumanPlayerToken(1, "X");
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Human player 1 plays with token X"));
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
		commandLine = new CommandLine(scanner, out);
		commandLine.printSquares(board);
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
		
		commandLine = new CommandLine(scanner, out);
		commandLine.askHumanPlayerForMove(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Please human player 1 type the next move:"));
	}
	
	@Test
	public void testAskMachinePlayerForMove() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.askMachinePlayerForMove(1);
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("Machine player 1 is thinking its next move..."));
		assertTrue(output.contains(newLine));
	}
	
	@Test
	public void testPrintResultOfGame() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.printResultOfGame("machine", 1);
		final String output = outputBuffer.toString(); 
		assertTrue(output.startsWith("The machine player 1 won."));
	}

	@Test
	public void testAnnounceItWasATie() {
		scanner = new Scanner("");
		scanner.useDelimiter(" ");
		
		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);
		
		commandLine = new CommandLine(scanner, out);
		commandLine.announceItWasATie();
		final String output = outputBuffer.toString();
		assertTrue(output.startsWith("It was a tie. Well played."));
	}
}
