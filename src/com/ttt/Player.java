package com.ttt;

import java.io.IOException;

public interface Player {
	String getToken();
	boolean isMachine();
	int getPlayerOrder();
	Board getNextMove(Board board, int position) throws IOException;
}
