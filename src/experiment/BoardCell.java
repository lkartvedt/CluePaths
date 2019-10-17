//Lindsey Kartvedt, Brianna Lijewski, Amber Walker

package experiment;


//stores information about the individual cells of the game board
public class BoardCell {
	int row;
	int column;
	boolean isValid; //needs to be expanded upon later, will evaluate the validity of a BoardCell
	
	public BoardCell(int row, int column) {
		this.row = row;
		this.column = column;
		this.isValid = true;   //currently set to true, will not be the case in the real game
	}
}

