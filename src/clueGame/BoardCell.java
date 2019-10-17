//Lindsey Kartvedt

package clueGame;


//stores information about the individual cells of the game board
public class BoardCell {
	int row;
	int column;
	char initial;
	
	public BoardCell(int row, int column, char initial) {
		this.row = row;
		this.column = column;
		this.initial = initial;
	}
	
	public boolean isWalkway() {
		return (initial == 'W');
	}
	
	public boolean isRoom() {
		return (initial == 'C' || initial == 'H' || initial == 'S' ||
				initial == 'G' || initial == 'K' || initial == 'R' ||
				initial == 'Y' || initial == 'WB);
	}
	
	public boolean isDoorway() {
		if() {
			return true;
		}
		return false;
	}
}

