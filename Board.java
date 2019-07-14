package com.tictactoe;

import java.util.Arrays;

/**
 * Created by: Paweł Bednarz
 * Date: 20-05-2019
 */

public class Board {

	private int dimension = 3;
	private char[][] board = new char[dimension][dimension];
	private int emptyFields = dimension * dimension;


	public Board() {
		this(3);
	}

	public Board(int dimension) {
		setDimension(dimension);
		for (char[] c : board) {
			Arrays.fill(c, ' ');
		}
	}

	//todo rozjezdzanie sie przy 2+ cyfrach rozmiaru
	public void printBoard() {
		StringBuilder horizontalSeparator = new StringBuilder("\n---");
		StringBuilder firstLine = new StringBuilder("   |  ");
		for (int i = 1; i <= board.length; i++) {
			firstLine.append(i).append("  |  ");
			horizontalSeparator.append("+-----");
		}
		horizontalSeparator.append("|");
		System.out.println(firstLine.toString() + horizontalSeparator.toString());
		for (int i = 0; i < board.length; i++) {
			System.out.print(" " + (i + 1) + " |  ");
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + "  |  ");
			}
			System.out.println(horizontalSeparator);
		}
		System.out.println();
	}

	public boolean isFieldEmpty(int column, int row) {
		return board[row][column] == ' ';
	}

	public void writeSymbol(int column, int row, char symbol) {
		board[row][column] = symbol;
		emptyFields--;
	}

	public int getEmptyFields() {
		return emptyFields;
	}

	public int getDimension() {
		return dimension;
	}

	public char[] getRow(int row) {
		return board[row];
	}

	public char[] getColumn(int column) {
		char[] result = new char[dimension];
		for (int i = 0; i < dimension; i++) {
			result[i] = board[i][column];
		}
		return result;
	}

	public char[] getDiagonal(int diagonal) {
		char[] result = new char[dimension];
		if (diagonal == 0) {
			for (int i = 0; i < dimension; i++) {
				result[i] = board[i][i];
			}
		} else {
			for (int i = dimension - 1; i >= 0; i--) {
				result[i] = board[i][i];
			}
		}
		return result;
	}

	public void setDimension(int dimension) {
		if (dimension <= 2) {
			throw new IllegalArgumentException("Invalid board dimension.");
		} else {
			this.dimension = dimension;
			board = new char[dimension][dimension];
			emptyFields = dimension * dimension;
		}
	}
}
