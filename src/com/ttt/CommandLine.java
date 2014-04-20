package com.ttt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

public class CommandLine{
	private PrintStream output;
	private Scanner input;
	
	public CommandLine(Scanner scanner, PrintStream out) {
		this.output = out;
		this.input = scanner;
	}
	
	public void welcomeMessage() {
		output.println();
		output.println();
		output.println("               ------------------Welcome to Tic Tac Toe game------------------               ");
		output.println();
		output.println();
	}
	
	public void announceMachinePlayerToken(int playerOrder, String token) {
		output.println(String.format("Machine player %s plays with token %s", playerOrder, token));
		output.println();
	}
	
	public String askForPlayerType(int playerOrderWhenChoosingType) throws IOException{
		String inputForPlayerType;
		output.println(String.format("Type h or m to choose the type of player %s who will move in %s place: (h)uman or (m)achine", playerOrderWhenChoosingType, playerOrderWhenChoosingType == 1 ? "first" : "second"));
		inputForPlayerType = input.next();
		while(isTypeEnteredInvalid(inputForPlayerType)) {
			output.println("Please enter a valid type:");
			inputForPlayerType = input.next();
		}
		return inputForPlayerType;
	}
	
	public void announceHumanPlayerToken(int playerOrder, String token) {
		output.println(String.format("Human player %s plays with token %s", playerOrder, token));
		output.println();
	}
	
	public void printSquares(Board board) {
		String[] squares = board.getSquares();
		output.println("    __    __    __  ");
		output.println("");
		for(int i=0; i < 3; i++) { 
			output.print("  |  ");
			for (int k=0; k < 3; k++) {
				if(squares[k + 3*i] == "-") {
					output.print(String.valueOf(k + 3*i + 1) + "  |  ");
				} else {
					output.print(squares[k + 3*i] + "  |  ");
				}
			}
			output.println();
			output.println("    __    __    __  ");
			output.println();
		}
		output.println();
	}
	
	public void askHumanPlayerForMove(int playerOrder) {
		output.println(String.format("Please human player %s type the next move:", playerOrder));
	}
	
	public void askHumanPlayerForMoveAgain() {
		output.println("Please enter a valid move:");
	}
	
	public void askHumanPlayerForValidBoardPosition() {
		output.println("Please enter a valid board position:");
	}
	
	public void askMachinePlayerForMove(int playerOrder) {
		output.println(String.format("Machine player %s is thinking its next move...", playerOrder));
	}
	
	public int getBoardPositionFromHumanPlayer() {
		String positionTyped = input.next();
		while(isInvalidBoardPosition(positionTyped)) {
			askHumanPlayerForValidBoardPosition();
			positionTyped = input.next();
		}
		return Integer.parseInt(positionTyped);
	}
	
	public void printResultOfGame(String winnerType, int playerOrder) {
		output.println(String.format("The %s player %s won.", winnerType, playerOrder));
	}
	
	public void printMessageToShowBoardLabeling() {
		output.println("The moves must be entered according to the following labels:");
		output.println(" ");
	}
	
	public void writeMessage(String message){
		output.println(message);
	}
	
	public boolean isTypeEnteredInvalid(String input) {
		if(input.equals("m") || input.equals("h")) {
			return false;
		}
		return true;
	}
	
	public boolean isInvalidBoardPosition(String positionTyped) {
		List<String> validBoardPositions = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
		if(validBoardPositions.contains(positionTyped)) {
			return false;
		}
		return true;
	}
}