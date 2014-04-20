package com.ttt;

import java.io.IOException;

public class Game {
	private CommandLine commandLine;
	private Player player1;
	private Player player2;
	private Board board;
	private static final int rows = 3;
	private static final int columns = 3;
	private GameReferee gameReferee;
	
	public Game(CommandLine commandline) {
		this.commandLine = commandline;
	}
	
	public void showWelcomeMessage() {
		commandLine.welcomeMessage();
	}
	
	public void createBoard() {
		board = new Board(rows, columns);
	}
	
	public void createGameReferee() {
		this.gameReferee = new GameReferee();
	}
	
	public void announcePlayerToken(Player player) {
		if(player.isMachine()) {
			commandLine.announceMachinePlayerToken(player.getPlayerOrder(), player.getToken());
		} else {
			commandLine.announceHumanPlayerToken(player.getPlayerOrder(), player.getToken());
		}
	}
	
	public void showSquaresLabelsOnBoard() {
		commandLine.printMessageToShowBoardLabeling();
		commandLine.printSquares(board);
		
	}
	
	public void announcePlayersTokensAtStart() {
		announcePlayerToken(player1);
		announcePlayerToken(player2);
	}
	
	public String[] askForTypesOfPlayers() throws IOException{
		String[] playersTypes = new String[2];
		playersTypes[0] = commandLine.askForPlayerType(1);
		playersTypes[1] = commandLine.askForPlayerType(2);
		return playersTypes;
	}
	
	public void createPlayersBasedOnChosenTypes() throws IOException{
		String[] playersTypes = askForTypesOfPlayers();
		if(playersTypes[0].equals("m")) {
			player1 = new MachinePlayer("X", 1);
		} else {
			player1 = new HumanPlayer("X", 1);
		}
		if(playersTypes[1].equals("m")) {
			player2 = new MachinePlayer("O", 2);
		} else {
			player2 = new HumanPlayer("O", 2);
		}
	}
	
	public int getMoveFromHumanPlayer(Player player) throws IOException{
		int position;
		commandLine.askHumanPlayerForMove(player.getPlayerOrder());
		position = commandLine.getBoardPositionFromHumanPlayer();
		while(!board.isSquareEmpty(position)) {
			commandLine.askHumanPlayerForMoveAgain();
			position = commandLine.getBoardPositionFromHumanPlayer();
		}
		return position;
	}
	
	public int getMoveFromMachinePlayer(Player player) throws IOException{
		commandLine.askMachinePlayerForMove(player.getPlayerOrder());
		return -1;
	}
	
	public void makePlayerMove(Player player) throws IOException{
		int position;
		if (player.isMachine()) {
			position = getMoveFromMachinePlayer(player);
			board = player.getNextMove(board, position);
			commandLine.printSquares(board);
		} else {
			position = getMoveFromHumanPlayer(player);
			board = player.getNextMove(board, position);
			commandLine.printSquares(board);
		}
	}
	
	public void askPlayersForMoves() throws IOException{
		makePlayerMove(player1);
		if(gameReferee.isGameOver(board)) {
			return;
		}
		makePlayerMove(player2);
	}
	
	public void startGame() throws IOException{
		showWelcomeMessage();
		createBoard();
		createPlayersBasedOnChosenTypes();
		announcePlayersTokensAtStart();
		createGameReferee();
		showSquaresLabelsOnBoard();
	}
	
	public void announceWinner(Player player) {
		String winnerType; 
		if (player.isMachine()) {
			winnerType = "machine";
		} else {
			winnerType = "human";
		}
		commandLine.printResultOfGame(winnerType, player.getPlayerOrder());
	}
	
	public void endGame() {
		String winner;
		if (!gameReferee.isTie(board)) {
			winner = gameReferee.whoIsWinner(board);
			if(player1.getToken() == winner) {
				announceWinner(player1);
			}
			if(player2.getToken() == winner) {
				announceWinner(player2);
			}
		} else {
			commandLine.announceItWasATie();
		}
	}
	
	public void playGame() throws IOException{
		startGame();
		while(!gameReferee.isGameOver(board)) {
			askPlayersForMoves();
		}
		endGame();
	}
}
