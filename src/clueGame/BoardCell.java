//Lindsey Kartvedt, Amber Walker

package clueGame;


//stores information about the individual cells of the game board
public class BoardCell {
	int row;
	int column;
	String letters;
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
		}
	}
	
	public boolean isWalkway() {
		return (letters.charAt(0) == 'W');
	}
	
	public boolean isRoom() {
		return false;
//		return (initial == 'C' || initial == 'B' || initial == 'G' ||
//				initial == 'R' || initial == 'H' || initial == 'S' ||
//				initial == 'Y' || initial == 'K' || initial == 'Z' ); 
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

