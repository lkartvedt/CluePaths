//Lindsey Kartvedt, Amber Walker

package clueGame;


//stores information about the individual cells of the game board
public class BoardCell {
	int row;
	int column;
	String letters;
	char initial;
	DoorDirection doorDirection = DoorDirection.NONE;
	
	public BoardCell(int row, int column, String letters) {
		
		this.row = row;
		this.column = column;
		this.letters = letters;
		if(letters.length() > 1) {
			switch(letters.charAt(1)) {
				case 'U':
					doorDirection = DoorDirection.UP;
					break;
				case 'D':
					doorDirection = DoorDirection.DOWN;
					break;
				case 'L':
					doorDirection = DoorDirection.LEFT;
					break;
				case 'R':
					doorDirection = DoorDirection.RIGHT;
					break;
			}
		}else {
			this.initial = letters.charAt(0);
		}
	}
	
	public boolean isWalkway() {
		return (initial == 'W');
	}
	
	public boolean isRoom() {
		return (initial != 'W' && initial != 'X'); 
	}
	
	public boolean isDoorway() {
		if(doorDirection != DoorDirection.NONE)
			return true;
		return false;
	}
	
	public DoorDirection getDoorDirection() {
		return doorDirection;
	}

	public char getInitial() {
		return letters.charAt(0);
	}


}

