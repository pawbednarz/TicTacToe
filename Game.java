package com.tictactoe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by: Paweł Bednarz
 * Date: 20-05-2019
 */

public class Game {

	private Board gameBoard;
	private char[] symbols = {'X', 'O'};
	private List<Player> players = new ArrayList<>(2);

	public Game() {
		gameBoard = new Board(3);
	}   //todo sprawdzenie dla playera czy wygral

	public Game(int boardDimension) {
		gameBoard = new Board(boardDimension);
	}

	public void addPlayer(Player player) {
		if (player != null) {
			if (players.size() < 2) {
				players.add(player);
			} else {
				System.err.println("Two players are already in game");
			}
		} else {
			throw new IllegalArgumentException("Player can't be \"null\"");
		}
	}

	public String whoStarts() {
		Collections.shuffle(players);
		return players.get(0).getName();
	}

	private boolean checkWin() {
		for (int i = 0; i < gameBoard.getDimension(); i++) {
			if (checkBoardSegment(gameBoard.getColumn(i))) {
				return true;
			} else if (checkBoardSegment(gameBoard.getRow(i))) {
				return true;
			}
		}
		return checkBoardSegment(gameBoard.getDiagonal(0)) || checkBoardSegment(gameBoard.getDiagonal(1));
	}

	private boolean checkBoardSegment(char[] segment) {
		char first = segment[0];
		for (int i = 1; i < segment.length; i++) {
			if (segment[i] != first || segment[i] == ' ') return false;
		}
		return true;
	}

	public void play() {
		boolean someoneWon;
		Player winner = null;
		String firstPlayerName = whoStarts();
		players.get(0).setSymbol(symbols[0]);
		players.get(1).setSymbol(symbols[1]);
		System.out.println(firstPlayerName + " starts!\nLet's start!");

		do {
			for (Player player : players) {
				gameBoard.printBoard();
				System.out.println(player.getName() + " turn.\n");
				player.makeMove(gameBoard);
				if (gameBoard.getEmptyFields() == 0 || checkWin()) {
					winner = player;
					break;
				}
				clearScreen();
			}
			clearScreen();
			someoneWon = checkWin();
		} while (!someoneWon && gameBoard.getEmptyFields() > 0);
		gameBoard.printBoard();
		System.out.println(checkWin() ? winner.getName() + " won!" : "Draw!");
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
