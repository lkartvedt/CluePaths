package clueGame;

import java.util.Random;
import java.util.Set;

public class ComputerPlayer extends Player{

	public ComputerPlayer(String name, String color, BoardCell cell) {
		super(name, color, cell);
	}
	
	public BoardCell selectTarget(Set<BoardCell> a) {
		for(BoardCell temp : a) {
			if(temp.isDoorway() && temp.getInitial() != lastRoom) {
				return temp;
			}
		}
		Random rand = new Random();
		int randomInt = rand.nextInt(a.size());
		
		for(BoardCell temp: a) {
			if(randomInt == 0) {
				return temp;
			}
			randomInt--;
		}
		return new BoardCell(0,0,"W");
	}
}
