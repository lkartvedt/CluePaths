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
		board.setConfigFiles("data\\ClueLayout.csv", "data\\RoomLegend.txt");
		// Initialize will load BOTH config files 
		board.initialize();
		board.calcAdjacencies();
	}

	@Test
	public void targetWalkwayTest() {
		BoardCell room = board.getCellAt(19, 8);  //Pink W at bottom left in middle of walkway, length 1
		Set<BoardCell> ans = new HashSet<BoardCell>();
		ans.add(board.getCellAt(20, 8));
		ans.add(board.getCellAt(18, 8));
		ans.add(board.getCellAt(19, 7));
		ans.add(board.getCellAt(19, 9));
		assertEquals(ans, board.calcTargets(room, 1));
		
		//length 2
		ans.removeAll(ans);
		ans.add(board.getCellAt(17, 8));
		ans.add(board.getCellAt(18, 9));
		ans.add(board.getCellAt(19, 10));
		ans.add(board.getCellAt(20, 9));
		ans.add(board.getCellAt(21, 8));
		ans.add(board.getCellAt(20, 7));
		ans.add(board.getCellAt(19, 6));
		ans.add(board.getCellAt(18, 7));
		assertEquals(ans, board.calcTargets(room, 2));
		
		room = board.getCellAt(11, 13);  //Pink W at top right bordering X, length 2
		ans.removeAll(ans);
		ans.add(board.getCellAt(9, 13));
		ans.add(board.getCellAt(10, 14));
		ans.add(board.getCellAt(11, 15));
		ans.add(board.getCellAt(11, 11));
		ans.add(board.getCellAt(10, 12));
		assertEquals(ans, board.calcTargets(room, 2));
		
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
		ans.add(board.getCellAt(10, 13));
		ans.add(board.getCellAt(11, 12));
		ans.add(board.getCellAt(11, 14));
		assertEquals(ans, board.calcTargets(room, 3));
	}

	@Test
	public void targetWalkwayEnteringRoomTest() {
		BoardCell room = board.getCellAt(2, 4);  //Pink W at top left by room C, length 2
		Set<BoardCell> ans = new HashSet<BoardCell>();
		ans.add(board.getCellAt(0, 4));
		ans.add(board.getCellAt(1, 5));
		ans.add(board.getCellAt(3, 5));
		assertEquals(ans, board.calcTargets(room, 2));
		
		room = board.getCellAt(0, 13);  //Pink W at top by KL, length 3
		ans.removeAll(ans);
		ans.add(board.getCellAt(2, 12));
		ans.add(board.getCellAt(3, 13));
		ans.add(board.getCellAt(0, 12));
		ans.add(board.getCellAt(1, 13));
		ans.add(board.getCellAt(1, 14));
		ans.add(board.getCellAt(2, 14));
		assertEquals(ans, board.calcTargets(room, 3));
		
	}
	
	@Test
	public void targetWalkwayLeavingRoomTest() {
		BoardCell room = board.getCellAt(20, 24);  //Pink GU, length 2
		Set<BoardCell> ans = new HashSet<BoardCell>();
		ans.add(board.getCellAt(18, 24));
		ans.add(board.getCellAt(19, 25));
		ans.add(board.getCellAt(19, 23));
		assertEquals(ans, board.calcTargets(room, 2));
		
		room = board.getCellAt(7, 22);  //Pink KD, length 3
		ans.removeAll(ans);
		ans.add(board.getCellAt(9, 23));
		ans.add(board.getCellAt(9, 21));
		ans.add(board.getCellAt(8, 24));
		ans.add(board.getCellAt(8, 20));
		assertEquals(ans, board.calcTargets(room, 3));
		
	}
}
