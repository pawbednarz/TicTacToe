package com.tictactoe;

import java.util.Random;

/**
 * Created by: Paweł Bednarz
 * Date: 20-05-2019
 */

public class CompPlayer extends Player {

	public CompPlayer() {
		super();
	}

	public CompPlayer(String name, char symbol) {
		super(name, symbol);
	}

	@Override
	public void makeMove(Board board) {



		Random rand = new Random();
		int column = rand.nextInt(board.getDimension());
		int row = rand.nextInt(board.getDimension());
		if (board.isFieldEmpty(column, row)) {
			board.writeSymbol(column, row, getSymbol());
		} else {
			makeMove(board);
		}
	}







	private boolean checkWin(Board board) {
		for (int i = 0; i < board.getDimension(); i++) {
			if (checkBoardSegment(board.getColumn(i))) {
				return true;
			} else if (checkBoardSegment(board.getRow(i))) {
				return true;
			}
		}
		return checkBoardSegment(board.getDiagonal(0)) || checkBoardSegment(board.getDiagonal(1));
	}

	private boolean checkBoardSegment(char[] segment) {
		char first = segment[0];
		for (int i = 1; i < segment.length; i++) {
			if (segment[i] != first || segment[i] == ' ') return false;
		}
		return true;
	}
}
