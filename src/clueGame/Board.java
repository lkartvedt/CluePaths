package clueGame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Board {

	public final int MAX_BOARD_SIZE = 50;
	private int numColumns;
	private int numRows;
	private BoardCell board[][];
	private Map<Character, String> legend;
	private Map<BoardCell, Set<BoardCell>> adjMtx;
	private Set<BoardCell> targets;
	private Set<BoardCell> visited;
	private String boardConfigFile;
	private String roomConfigFile;

	// variable used for singleton pattern
	private static Board theInstance = new Board();
	// constructor is private to ensure only one can be created
	private Board() {}
	// this method returns the only Board
	public static Board getInstance() {
		return theInstance;
	}

	public void initialize() {
		legend = new HashMap<Character, String>();
		//read in files
		
		//set up board
		loadRoomConfig();
		loadBoardConfig();
	}

	public void loadRoomConfig() {

	}

	public void loadBoardConfig() {

	}

	public void calcAdjacencies() {

		adjMtx = new HashMap<> ();

		//nested for loops because our board is 2 dimensional
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				Set<BoardCell> validAdjacencies = new HashSet<BoardCell> ();

				if(i != 0) {// && board[i-1][j].isValid) {
					validAdjacencies.add(board[i-1][j]);
				}
				if(i != board.length-1) {// && board[i+1][j].isValid) {
					validAdjacencies.add(board[i+1][j]);
				}
				if(j != 0) {// && board[i][j-1].isValid) {
					validAdjacencies.add(board[i][j-1]);
				}
				if(j != board[i].length-1) {// && board[i][j+1].isValid) {
					validAdjacencies.add(board[i][j+1]);
				}

				adjMtx.put(board[i][j], validAdjacencies);
			}
		}
	}

	//returns the Set of all adjunct spaces for a given cell
	public Set<BoardCell> getAdjList(BoardCell cell) {
		return adjMtx.get(cell);
	}

	//resets visited and targets, then calls the recursive method to actaully calculate targets
	public void calcTargets(BoardCell cell, int pathLength){
		visited = new HashSet<BoardCell> ();
		visited.add(cell);
		targets = new HashSet<BoardCell> ();
		findAllTargets(cell, pathLength);
	}

	//returns targets, best to do that here rather than in getAdjList for highlighting
	public Set<BoardCell> getTargets(){
		return targets;
	}

	//Paths algorithm, finds all potential moves for the player. Recursive.
	public void findAllTargets(BoardCell thisCell, int numSteps) {
		Set<BoardCell> adjacentCells = adjMtx.get(thisCell);		
		for(BoardCell adjCell : adjacentCells) {
			if(visited.contains(adjCell)) {
				continue;
			}else {
				visited.add(adjCell);
				if(numSteps == 1) {
					targets.add(adjCell);
				}else {
					findAllTargets(adjCell, numSteps-1);
				}

				visited.remove(adjCell);
			}
		}
	}
	
	public void setConfigFiles(String string, String string2) {
		
	}
	
	public Map<Character, String> getLegend() {
		return legend;	
	}
	
	public int getNumRows() {
		return 0;
	}
	
	public int getNumColumns() {
		return 0;
	}
	
	//returns the cell
	public BoardCell getCellAt(int i, int j) {
		return board[i][j];
	}

}
