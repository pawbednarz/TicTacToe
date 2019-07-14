package com.tictactoe;

/**
 * Created by: Paweł Bednarz
 * Date: 20-05-2019
 */

public abstract class Player {

	private String name = "Default name";
	private char symbol;

	public Player() {
		this("Default name", 'X');
	}

	public Player(String name, char symbol) {
		this.symbol = symbol;
		setName(name);
	}

	public abstract void makeMove(Board board);

	public String getName() {
		return name;
	}

	private void setName(String name) {
		//todo regex
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Invalid name.");
		}
	}

	protected char getSymbol() {
		return this.symbol;
	}

	public void setSymbol(char newSymbol) {
		if (newSymbol != 'X' && newSymbol != 'O') {
			throw new IllegalArgumentException("Invalid symbol.");
		} else {
			this.symbol = newSymbol;
		}
	}
}
