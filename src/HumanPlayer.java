import java.util.Scanner;

public class HumanPlayer implements Player {
	char ch;
	Scanner sc = new Scanner(System.in);
	
	public HumanPlayer(char ch) {
		this.ch = ch;
	}

	@Override
	public Move play(Board b) {
		System.out.println(b);
		System.out.println("Please enter the row you want to move to:");
		int row = sc.nextInt();
		System.out.println("Please enter the column you want to move to:");
		int col = sc.nextInt();
		return new Move(row, col, ch);
	}

	@Override
	public char getCh() {
		return ch;
	}
	
	public String toString() {
		return ch+"";
	}
	
}
