//Lindsey Kartvedt

package experiment;


//IMPORT Statements
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class IntBoard {
	private Map<BoardCell, Set<BoardCell>> adjMtx;
	private Set<BoardCell> visited;
	private Set<BoardCell> targets;
	private BoardCell[][] grid;
	
	//constructor
	public IntBoard(BoardCell[][] grid) {
		this.grid = grid;
		calcAdjacencies();
	}
	
	//calculates all adjacencies and puts them in a Set for each point on the grid
	public void calcAdjacencies() {
		
		adjMtx = new HashMap<> ();
		
		//nested for loops because our board is 2 dimensional
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				Set<BoardCell> validAdjacencies = new HashSet<BoardCell> ();
				
				if(i != 0 && grid[i-1][j].isValid) {
						validAdjacencies.add(grid[i-1][j]);
				}
				if(i != grid.length-1 && grid[i+1][j].isValid) {
					validAdjacencies.add(grid[i+1][j]);
				}
				if(j != 0 && grid[i][j-1].isValid) {
					validAdjacencies.add(grid[i][j-1]);
				}
				if(j != grid[i].length-1 && grid[i][j+1].isValid) {
					validAdjacencies.add(grid[i][j+1]);
				}
				
				adjMtx.put(grid[i][j], validAdjacencies);
			}
		}
	}
	
	//returns the Set of all adjunct spaces for a given cell
	public Set<BoardCell> getAdjList(BoardCell cell) {
		return adjMtx.get(cell);
	}
	
	//resets visited and targets, then calls the recursive method to actaully calculate targets
	public void calcTargets(BoardCell startCell, int pathLength){
		visited = new HashSet<BoardCell> ();
		visited.add(startCell);
		targets = new HashSet<BoardCell> ();
		findAllTargets(startCell, pathLength);
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
	
	//returns the cell
	public BoardCell getCell(int row, int col) {
		return grid[row][col];
	}
}

