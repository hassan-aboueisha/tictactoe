
public class Game {
	Board board;
	Player [] players;
	int turn = 0;
	
	public Game(Board board, Player [] players) {
		this.board = board;
		this.players = players;
	}
	
	private void playGame() {
		while (board.getStatus() == Status.ON) {
			Move move = players[turn].play(board);
			if (board.isAllowed(move)) {
				board.move(move);
				turn = (turn + 1) % players.length;
			}
		}
	}
	
	private void displayResult() {
		System.out.println(board);
		if (board.getStatus() == Status.DRAW)
			System.out.println(":(:(:( nobody wins!!");
		else {
			char ch = board.getWinner();
			for (Player p : players)
				if (p.getCh() == ch) {
					System.out.print(p);
					System.out.println(" is our winner!!!");
					break;
				}
					
		}
	}
	
	public void start() {
		playGame();
		displayResult();
	}
}
