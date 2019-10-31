package clueGame;

public class ComputerPlayer extends Player{

	public ComputerPlayer(String name, String color, BoardCell cell) {
		super(name, color, cell);
	}
	
	public BoardCell selectTarget(int move) {
		return new BoardCell(0,0,"W");
	}
}
