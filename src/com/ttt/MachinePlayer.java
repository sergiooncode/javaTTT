package com.ttt;

public class MachinePlayer implements Player {
	private String token;
	private int playerOrder;
	private UnbeatableAI unbeatableAi;
	
	public MachinePlayer(String token, int playerOrder) {
		this.token = token;
		this.playerOrder = playerOrder;
	}
	
	public int getPlayerOrder() {
		return playerOrder;
	}
	
	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return this.token;
	}

	@Override
	public boolean isMachine() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Board getNextMove(Board board, int position) {
		// TODO Auto-generated method stub
		unbeatableAi = new UnbeatableAI(board, token);
		board.setGivenSquare(unbeatableAi.generateMove(),getToken());
		return board;
	}

}
