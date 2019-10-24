package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;

public class Targets {

	private static Board board;
	@BeforeClass
	public static void setUp() {
		// Board is singleton, get the only instance
		board = Board.getInstance();
		// set the file names to use my config files
		board.setConfigFiles("CTest_ClueLayout.csv", "CTest_ClueLegend.txt");
		// Initialize will load BOTH config files 
		board.initialize();
	}

	@Test
	public void TargetWalkwayTest() {
		BoardCell room = board.getCellAt(19, 8);  //Pink W at bottom left in middle of walkway, length 1
		Set<BoardCell> ans = new HashSet<BoardCell>();
		ans.add(board.getCellAt(20, 8));
		ans.add(board.getCellAt(18, 8));
		ans.add(board.getCellAt(19, 7));
		ans.add(board.getCellAt(19, 9));
		assertEquals(ans, board.getAdjList(room));
		
		//length 2
		ans.removeAll(ans);
		ans.add(board.getCellAt(16, 8));
		ans.add(board.getCellAt(17, 9));
		ans.add(board.getCellAt(18, 10));
		ans.add(board.getCellAt(19, 9));
		ans.add(board.getCellAt(20, 8));
		ans.add(board.getCellAt(19, 7));
		ans.add(board.getCellAt(18, 6));
		ans.add(board.getCellAt(17, 7));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(11, 13);  //Pink W at top right bordering X, length 2
		ans.removeAll(ans);
		ans.add(board.getCellAt(9, 13));
		ans.add(board.getCellAt(10, 14));
		ans.add(board.getCellAt(11, 15));
		ans.add(board.getCellAt(11, 11));
		ans.add(board.getCellAt(10, 12));
		assertEquals(ans, board.getAdjList(room));
		
		//length 3  
		ans.removeAll(ans);
		ans.add(board.getCellAt(8, 13));
		ans.add(board.getCellAt(9, 14));
		ans.add(board.getCellAt(10, 15));
		ans.add(board.getCellAt(11, 16));
		ans.add(board.getCellAt(12, 15));
		ans.add(board.getCellAt(11, 10));
		ans.add(board.getCellAt(10, 11));
		ans.add(board.getCellAt(9, 12));
		assertEquals(ans, board.getAdjList(room));
	}

}
