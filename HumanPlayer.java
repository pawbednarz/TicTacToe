package com.tictactoe;

import java.util.Scanner;

/**
 * Created by: Paweł Bednarz
 * Date: 20-05-2019
 */

public class HumanPlayer extends Player {

	public HumanPlayer() {
		super();
	}

	public HumanPlayer(String name, char symbol) {
		super(name, symbol);
	}

	@Override
	public void makeMove(Board board) {
		Scanner read = new Scanner(System.in);
		System.out.println(getName() + " enter column.");
		int column = read.nextInt() - 1;
		System.out.println(getName() + " enter row.");
		int row = read.nextInt() - 1;
		if (board.isFieldEmpty(column, row)) {
			board.writeSymbol(column, row, getSymbol());
		} else {
			System.out.println("Field isn't empty, try again.");
			makeMove(board);
		}
	}
}
