//Lindsey Kartvedt

package clueGame;


//stores information about the individual cells of the game board
public class BoardCell {
	int row;
	int column;
	String letters;
	
	public BoardCell(int row, int column, String letters) {
		
		this.row = row;
		this.column = column;
		this.letters = letters;
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
		if(letters.length() > 1)
			return true;
		return false;
	}
	
	public char getDoorDirection() {
		return ' ';
	}

	public char getInitial() {
		return letters.charAt(0);
	}


}

