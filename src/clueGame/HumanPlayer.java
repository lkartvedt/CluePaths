package clueGame;

public class HumanPlayer extends Player{

	public HumanPlayer(String name, String color, BoardCell cell) {
		super(name, color, cell);
	}
	
	public BoardCell selectTarget(int move) {
		return new BoardCell(0,0,"W");
	}
}
