import java.util.Arrays;

public class SquareBoard implements Board {
	char [][] grid;
	int moves = 0;
	int dimension;
	final static char SENTINEL = '.';
	
	public SquareBoard(int dimension) {
		this.dimension = dimension;
		grid = new char[dimension][dimension];
		initializeGrid(SENTINEL);
	}


	@Override
	public boolean isAllowed(Move move) {
		int row = move.getRow(), column = move.getColumn();
		if (row >= 0 && row < grid.length &&
			column >= 0 && move.column < grid[row].length &&
			grid[row][column] == SENTINEL)
			return true;
		return false;
	}


	@Override
	public boolean allFilled() {
		return moves >= this.dimension * this.dimension;
	}


	@Override
	public Board move(Move move) {
		if (!isAllowed(move))
			return null;
		this.grid[move.getRow()][move.getColumn()] = move.getCh();
		moves++;
		return this;
	}

	@Override
	public Status getStatus() {
		if (getWinner() != SENTINEL)
			return Status.WIN;
		if (allFilled())
			return Status.DRAW;
		return Status.ON;
	}
	
	private void initializeGrid(char sentinelValue) {
		for (int i = 0;i < grid.length;i++)
			Arrays.fill(grid[i], sentinelValue);
	}
	
	private char sameRow(int row) {
		char ch = grid[row][0];
		for (int col = 0;col < grid.length;col++)
			if (grid[row][col] != ch)
				return SENTINEL;
		return ch;
	}
	
	private char sameColumn(int col) {
		char ch = grid[0][col];
		for (int row = 0;row < grid.length;row++)
			if (grid[row][col] != ch)
				return SENTINEL;
		return ch;
	}
	
	private char isMainDiagonal() {
		char ch = grid[0][0];
		for (int i = 0;i < grid.length;i++)
			if (grid[i][i] != ch)
				return SENTINEL;
		return ch;
	}
	
	private char isReverseDiagonal() {
		char ch = grid[0][grid.length - 1];
		for (int i = 0;i < grid.length;i++)
			if (grid[0][grid.length - 1 - i] != ch)
				return SENTINEL;
		return ch;
	}

	@Override
	public char getWinner() {
		char ch = isMainDiagonal();
		if (ch != SENTINEL)
			return ch;
		ch = isReverseDiagonal();
		if (ch != SENTINEL)
			return ch;
		for (int i = 0;i < dimension;i++) {
			ch = sameRow(i);
			if (ch != SENTINEL)
				return ch;
			ch = sameColumn(i);
			if (ch != SENTINEL)
				return ch;
		}
		return SENTINEL;
	}
	
	public String toString() {
		String str = "";
		for (char [] g : grid)
			str += new String(g) + "\n";
		return str;
	}

}
