package com.ttt;

import java.io.IOException;

public class Game {
	private UserInterface userInterface;
	private Player player1;
	private Player player2;
	private Board board;
	private static final int rows = 3;
	private static final int columns = 3;
	private GameReferee gameReferee;
	
	public Game(UserInterface userInterface) {
		this.userInterface = userInterface;
	}
	
	public void playGame() throws IOException{
		startGame();
		while(!gameReferee.isGameOver(board)) {
			askPlayersForMoves();
		}
		endGame();
	}
	
	public void startGame() throws IOException{
		showWelcomeMessage();
		createBoard();
		askSettings();
		announcePlayersTokensAtStart();
		createGameReferee();
		showSquaresLabelsOnBoard();
	}
	
	public void showWelcomeMessage() {
		userInterface.printWelcomeMessage();
	}
	
	public void createBoard() {
		board = new Board(rows, columns);
	}
	
	public Player createPlayer(String input, String token, int order) throws IOException{
		Player player;
		if(input.equals("m")) {
			player = new MachinePlayer(token, order);
		} else {
			player = new HumanPlayer(token, order);
		}
		return player;
	}
	
	public void askFirstPlayerForType() throws IOException{
		String first = userInterface.getPlayerType(1);
		player1 = createPlayer(first, "X", 1);
	}
	
	public void askSecondPlayerForType() throws IOException{
		String second = userInterface.getPlayerType(2);
		player2 = createPlayer(second, "O", 2);
	}
	
	public void askSettings() throws IOException{
		askFirstPlayerForType();
		askSecondPlayerForType();
	}
	
	public void announcePlayersTokensAtStart() {
		announcePlayerToken(player1);
		announcePlayerToken(player2);
	}
	
	public void announcePlayerToken(Player player) {
		if(player.isMachine()) {
			userInterface.printMachinePlayerToken(player.getPlayerOrder(), player.getToken());
		} else {
			userInterface.printHumanPlayerToken(player.getPlayerOrder(), player.getToken());
		}
	}
	
	public void createGameReferee() {
		this.gameReferee = new GameReferee();
	}
	
	public void showSquaresLabelsOnBoard() {
		userInterface.printMessageBeforeShowingBoardLabeling();
		userInterface.printSquares(board);
	}
	
	public void askPlayersForMoves() throws IOException{
		makePlayerMove(player1);
		if(gameReferee.isGameOver(board)) {
			return;
		}
		makePlayerMove(player2);
	}
	
	public void makePlayerMove(Player player) throws IOException{
		int position;
		if (player.isMachine()) {
			position = getMoveFromMachinePlayer(player);
			board = player.getNextMove(board, position);
			userInterface.printSquares(board);
		} else {
			position = getMoveFromHumanPlayer(player);
			board = player.getNextMove(board, position);
			userInterface.printSquares(board);
		}
	}
	
	public int getMoveFromMachinePlayer(Player player) throws IOException{
		userInterface.printMessageMachinePlayerThinking(player.getPlayerOrder());
		return -1;
	}
	
	public int getMoveFromHumanPlayer(Player player) throws NumberFormatException, IOException{
		int position;
		userInterface.askHumanPlayerForMove(player.getPlayerOrder());
		position = userInterface.getBoardPositionFromHumanPlayer();
		while(!board.isSquareEmpty(position)) {
			userInterface.askHumanPlayerForMoveAgain();
			position = userInterface.getBoardPositionFromHumanPlayer();
		}
		return position;
	}
	
	public void endGame() {
		String winner;
		if (!gameReferee.isTie(board)) {
			winner = gameReferee.whoIsWinner(board);
			if(player1.getToken().equals(winner)) {
				announceWinner(player1);
			}
			if(player2.getToken().equals(winner)) {
				announceWinner(player2);
			}
		} else {
			userInterface.printMessageItWasATie();
		}
	}
	
	public void announceWinner(Player player) {
		String winnerType; 
		if (player.isMachine()) {
			winnerType = "machine";
		} else {
			winnerType = "human";
		}
		userInterface.printResultOfGame(winnerType, player.getPlayerOrder());
	}
}
