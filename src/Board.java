
public interface Board {
	public boolean isAllowed(Move move);
	public boolean allFilled();
	public Board move(Move move);
	public Status getStatus();
	public char getWinner();
}
