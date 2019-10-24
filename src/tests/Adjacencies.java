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
		board.setConfigFiles("data\\ClueLayout.csv", "data\\RoomLegend.txt");
		// Initialize will load BOTH config files 
		board.initialize();
		board.calcAdjacencies();
	}

	@Test
	public void doorDirectionTest() {
		System.out.println("test");
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
	
	@Test
	public void besidesDoorwayAdjTest() {
		BoardCell room = board.getCellAt(12, 4);  //Green W below SD
		Set<BoardCell> ans = new HashSet<BoardCell>();
		ans.add(board.getCellAt(12, 5));
		ans.add(board.getCellAt(12, 3));
		ans.add(board.getCellAt(13, 4));
		ans.add(board.getCellAt(11, 4));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(24, 5);  //Green W by YR
		ans.removeAll(ans);
		ans.add(board.getCellAt(23, 5));
		ans.add(board.getCellAt(25, 5));
		ans.add(board.getCellAt(24, 4));
		ans.add(board.getCellAt(24, 6));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(20, 12);  //Green W by BU
		ans.removeAll(ans);
		ans.add(board.getCellAt(20, 11));
		ans.add(board.getCellAt(20, 13));
		ans.add(board.getCellAt(19, 12));
		ans.add(board.getCellAt(21, 12));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(3, 13);  //Green W by KL
		ans.removeAll(ans);
		ans.add(board.getCellAt(3, 12));
		ans.add(board.getCellAt(3, 14));
		ans.add(board.getCellAt(2, 13));
		ans.add(board.getCellAt(4, 13));
		assertEquals(ans, board.getAdjList(room));
		
	}
	
	@Test
	public void WalkwayTest() {
		BoardCell room = board.getCellAt(13, 16);  //Red W in middle of walkway
		Set<BoardCell> ans = new HashSet<BoardCell>();
		ans.add(board.getCellAt(13, 17));
		ans.add(board.getCellAt(13, 15));
		ans.add(board.getCellAt(14, 16));
		ans.add(board.getCellAt(12, 16));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(27, 17);  //Red W at bottom of board
		ans.removeAll(ans);
		ans.add(board.getCellAt(26, 17));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(0, 5);  //Red W at top of board
		ans.removeAll(ans);
		ans.add(board.getCellAt(0, 4));
		ans.add(board.getCellAt(1, 5));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(8, 17);  //Red W bordering K
		ans.removeAll(ans);
		ans.add(board.getCellAt(8, 16));
		ans.add(board.getCellAt(8, 18));
		ans.add(board.getCellAt(9, 17));
		assertEquals(ans, board.getAdjList(room));
		
		room = board.getCellAt(19, 18);  //Red W bordering GL
		ans.removeAll(ans);
		ans.add(board.getCellAt(19, 17));
		ans.add(board.getCellAt(19, 19));
		ans.add(board.getCellAt(18, 18));
		assertEquals(ans, board.getAdjList(room));
	}
}
