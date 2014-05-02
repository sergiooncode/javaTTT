package com.ttt;

import java.io.IOException;

public interface UserInterface {
	void printWelcomeMessage();
	String getPlayerType(int playerOrderWhenChoosingType) throws IOException;
	void printSquares(Board board);
	int getBoardPositionFromHumanPlayer() throws NumberFormatException, IOException;
	void printResultOfGame(String winnerType, int playerOrder);
}
