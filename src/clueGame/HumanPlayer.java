package clueGame;

import java.util.Set;

public class HumanPlayer extends Player{

	public HumanPlayer(String name, String color, BoardCell cell) {
		super(name, color, cell);
	}
	
	public BoardCell selectTarget(Set<BoardCell> a) {
		return new BoardCell(0,0,"W");
	}
}
