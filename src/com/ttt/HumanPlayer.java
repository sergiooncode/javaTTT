package com.ttt;

public class HumanPlayer implements Player {
	private String token;
	private int playerOrder;
	
	public HumanPlayer(String token, int playerOrder) {
		this.token = token;
		this.playerOrder = playerOrder;
	}
	
	public int getPlayerOrder() {
		return playerOrder;
	}
	
	@Override
	public String getToken() {
		return this.token;
	}
	
	@Override
	public boolean isMachine() {
		return false;
	}
	
	@Override
	public Board getNextMove(Board board, int position){
		board.setGivenSquare(position, getToken());
		return board;
	}
}
