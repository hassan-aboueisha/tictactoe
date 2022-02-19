
public class Move {
	int row;
	int column;
	char ch;
	
	public Move(int row, int column, char ch) {
		super();
		this.row = row;
		this.column = column;
		this.ch = ch;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public char getCh() {
		return ch;
	}

	public String toString() {
		return String.format("Player %c movee to row %d, column %d", ch, row, column);
	}
}
