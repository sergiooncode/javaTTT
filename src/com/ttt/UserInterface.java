package com.ttt;

import java.io.IOException;

public interface UserInterface {
	void printWelcomeMessage();
	void askForPlayerType (int playerOrder);
	String getPlayerType(int playerOrderWhenChoosingType) throws IOException;
	void printMachinePlayerToken(int playerOrder, String token);
	void printHumanPlayerToken(int playerOrder, String token);
	void printMessageBeforeShowingBoardLabeling();
	void printSquares(Board board);
	void askHumanPlayerForMove(int playerOrder);
	void askHumanPlayerForMoveAgain();
	void askHumanPlayerForValidBoardPosition();
	void printMessageMachinePlayerThinking(int playerOrder);
	int getBoardPositionFromHumanPlayer() throws NumberFormatException, IOException;
	void printResultOfGame(String winnerType, int playerOrder);
	void printMessageItWasATie();
}
