package com.ttt;

import java.util.ArrayList;

public class UnbeatableAI{
	private static final int INFINITY = 1000000;
	private Board board;
	private GameReferee gameReferee = new GameReferee();
	private String token;
	
	public UnbeatableAI(Board board, String token) {
		this.board = board;
		this.token = token;
	}
	
	public String[] generateSquaresWithNewMove(Board nextBoard, int move, String currentPlayer) {
		String[] newSquares = new String[nextBoard.getBoardSize()];
		for(int j=0; j < nextBoard.getBoardSize(); j++) {
			newSquares[j] = nextBoard.getGivenSquare(j + 1);
		}
		newSquares[move] = currentPlayer;
		return newSquares;
	}
	
	public ArrayList<Integer> getPlayableMoves(Board nextBoard) {
		ArrayList<Integer> playableMoves = new ArrayList<Integer>();
		for(int k=0; k < nextBoard.getBoardSize(); k++) {
			if(nextBoard.getGivenSquare(k + 1) == "-") {
				playableMoves.add(k);
			}
		}
		return playableMoves;
	}
	
	public int staticEvaluationFunction(String currentPlayer, Board nextBoard) {
		String winner = gameReferee.whoIsWinner(nextBoard);
		int score = -1;
		if(!gameReferee.isTie(nextBoard)) {
			if(winner == currentPlayer) {
				score = INFINITY;
			}
			if(winner != currentPlayer) {
				score = -INFINITY;
			} 
		} else {
			score = 0;
		}
		return score;
	}
	
	public String alternatePlayer(String currentPlayer) {
		String otherPlayer;
		if(currentPlayer == "X") {
			otherPlayer = "O";
		} else {
			otherPlayer = "X";
		}
		return otherPlayer;
	}
 	
	public int[] negamaxAlgorithmMethod(Board nextBoard, String currentPlayer, int maxTreeDepth, int currentTreeDepth) {
		int bestMove;
		int bestScore;
		int[] negamaxRecursedResult = new int[2];
		int currentScore, recursedScore;
		String[] squaresAfterMove = new String[nextBoard.getBoardSize()];
		ArrayList<Integer> playableMoves;
		if(gameReferee.isGameOver(nextBoard) || currentTreeDepth == maxTreeDepth) {
			negamaxRecursedResult[0] = staticEvaluationFunction(currentPlayer, nextBoard);
			negamaxRecursedResult[1] = -1;
			return negamaxRecursedResult;
		}
		bestMove = -1;
		bestScore = -INFINITY;
		playableMoves = getPlayableMoves(nextBoard);
		for(int move : playableMoves) {
			squaresAfterMove = generateSquaresWithNewMove(nextBoard, move, currentPlayer);
			Board newBoard = new Board(squaresAfterMove);
			negamaxRecursedResult = negamaxAlgorithmMethod(newBoard, alternatePlayer(currentPlayer), maxTreeDepth, currentTreeDepth + 1);
			recursedScore = negamaxRecursedResult[0];
			currentScore = -recursedScore;
			if(currentScore > bestScore) {
				bestScore = currentScore;
				bestMove = move;
			}
		}
		negamaxRecursedResult[0] = bestScore;
		negamaxRecursedResult[1] = bestMove;
		return negamaxRecursedResult;
	}
	
	public int generateMove() {
		int[] negamaxResult = new int[2];
		int maxTreeDepth = board.getBoardSize();
		int currentTreeDepth = 0;
		String currentPlayer = token;
		negamaxResult = negamaxAlgorithmMethod(board, currentPlayer, maxTreeDepth, currentTreeDepth);
		for(int m=0; m < negamaxResult.length; m++) System.out.print(negamaxResult[m] + "   ");
		System.out.println();
		return negamaxResult[1] + 1;
	}
}
