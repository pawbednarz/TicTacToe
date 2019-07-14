package com.tictactoe;

/**
 * Created by: Paweł Bednarz
 * Date: 20-05-2019
 */

public class TicTacToe {
	public static void main(String[] args) {
		Game game = new Game();
		game.addPlayer(new HumanPlayer("Pawel", 'X'));
		game.addPlayer(new CompPlayer("Kacper", 'O'));
		game.play();
	}
}