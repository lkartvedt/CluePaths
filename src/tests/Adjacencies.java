package tests;
import java.util.HashSet;
/*
 * This program tests that adjacencies and targets are calculated correctly.
 */
import java.util.Set;
//Doing a static import allows me to write assertEquals rather than
//assertEquals
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import clueGame.Board;
import clueGame.BoardCell;
import clueGame.DoorDirection;
import clueGame.Board;

public class Adjacencies {

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
	public void doorDirectionTest() {
		BoardCell room = board.getCellAt(5, 4);  //Upper right door of C
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.RIGHT, room.getDoorDirection());
		
		room = board.getCellAt(11, 3);  //Lower left door of S
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.DOWN, room.getDoorDirection());
		
		room = board.getCellAt(10, 8);  //Walkway
		assertTrue(!room.isDoorway());
		assertEquals(DoorDirection.NONE, room.getDoorDirection());
		
		room = board.getCellAt(24, 2);  //In room Y
		assertTrue(!room.isDoorway());
		assertEquals(DoorDirection.NONE, room.getDoorDirection());
		
		room = board.getCellAt(21, 11);  //Upper left room of B
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.UP, room.getDoorDirection());
		
		room = board.getCellAt(21, 18);  //Lower left room of G
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.LEFT, room.getDoorDirection());
	}

	@Test
	public void inRoomAdjTest() {
		BoardCell room = board.getCellAt(18, 5);  //Orange in Z
		assertEquals(new HashSet<BoardCell>() , board.getAdjList(room));
		
		room = board.getCellAt(24, 16);  //Orange in B
		assertEquals(new HashSet<BoardCell>() , board.getAdjList(room));
		
		room = board.getCellAt(4, 15);  //Orange in K
		assertEquals(new HashSet<BoardCell>() , board.getAdjList(room));
	}
	
	@Test
	public void inDoorwayAdjTest() {
		BoardCell room = board.getCellAt(7, 10);  //Purple HD
		Set<BoardCell> ans = new HashSet<BoardCell>();
		ans.add(board.getCellAt(8, 10));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(21, 13);  //Purple BU
		ans.removeAll(ans);
		ans.add(board.getCellAt(20, 13));
		assertEquals(new HashSet<BoardCell>() , board.getAdjList(room));
		
	}
	
}
