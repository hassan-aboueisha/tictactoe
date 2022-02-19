
public class Engine {
	public static void main(String [] args) {
		Board threeByThree = new SquareBoard(3);
		Player [] players = new Player[2];
		players[0] = new HumanPlayer('X');
		players[1] = new HumanPlayer('O');
		Game g = new Game(threeByThree, players);
		g.start();
	}
}

/**
Player will be responsible of determining which move to take given a particular board status

Board should encode the status of the board and to decide whether a move is valid or not and to update
the board after the move.

Game is an infinite loop until the game is done where it keeps track of the player turns and
gets the move from them and consult the board

Should the board be the class responsible for determining when the game ends or the Game

*/