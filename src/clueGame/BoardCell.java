//Lindsey Kartvedt

package clueGame;


//stores information about the individual cells of the game board
public class BoardCell {
	int row;
	int column;
	char initial;
	
	public BoardCell(int row, int column, String letters) {
		
		this.row = row;
		this.column = column;
		//this.initial = initial;
	}
	
	public boolean isWalkway() {
		return false;
		//return (initial == 'W');
	}
	
	public boolean isRoom() {
		return false;
//		return (initial == 'C' || initial == 'B' || initial == 'G' ||
//				initial == 'R' || initial == 'H' || initial == 'S' ||
//				initial == 'Y' || initial == 'K' || initial == 'Z' ); 
		}
	
	public boolean isDoorway() {
		return false;
	}
	
	public char getDoorDirection() {
		return ' ';
	}

	public char getInitial() {
		return initial;
	}


}

