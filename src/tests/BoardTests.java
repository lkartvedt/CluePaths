//Lindsey Kartvedt, Amber Walker, Brianna Lijewski

package tests;

import static org.junit.Assert.*;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import clueGame.Board;
import clueGame.BoardCell;
import clueGame.DoorDirection;

public class BoardTests {
	public static final int LEGEND_SIZE = 11;
	public static final int NUM_ROWS = 28;
	public static final int NUM_COLUMNS = 26;

	private static Board board;
	
	@BeforeClass
	public static void setUp() {
		// Board is singleton, get the only instance
		board = Board.getInstance();
		// set the file names to use my config files
		board.setConfigFiles("data\\ClueLayout.csv", "data\\RoomLegend.txt");		
		// Initialize will load BOTH config files 
		board.initialize();
	}
	
	@Test
	public void testRooms() {
		// Get the map of initial => room 
		Map<Character, String> legend = board.getLegend();
		// Ensure we read the correct number of rooms
		assertEquals(LEGEND_SIZE, legend.size());
		// To ensure data is correctly loaded, test retrieving a few rooms 
		// from the hash, including the first and last in the file and a few others
		//System.out.println(legend.get('C'));
		assertTrue(legend.get('C').equals("Conservatory"));
		assertTrue(legend.get('B').equals("Basement"));
		assertTrue(legend.get('G').equals("Garage"));
		assertTrue(legend.get('R').equals("Bedroom"));
		assertTrue(legend.get('H').equals("Green House"));
		assertTrue(legend.get('S').equals("Sauna"));
		assertTrue(legend.get('Y').equals("Gym"));
		assertTrue(legend.get('K').equals("Kitchen"));
		assertTrue(legend.get('Z').equals("Dungeon"));
		assertTrue(legend.get('X').equals("Closet"));
		assertTrue(legend.get('W').equals("Walkway"));
	}
	
	@Test
	public void testBoardDimensions() {
		// Ensure we have the proper number of rows and columns
		assertEquals(NUM_ROWS, board.getNumRows());
		assertEquals(NUM_COLUMNS, board.getNumColumns());		
	}
	
	// Test a doorway in each direction (RIGHT/LEFT/UP/DOWN), plus 
	// two cells that are not a doorway.
	// These cells are white on the planning spreadsheet
	@Test
	public void FourDoorDirections() {
		BoardCell room = board.getCellAt(1, 14);  //Kitchen door, top left
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.LEFT, room.getDoorDirection());
		room = board.getCellAt(21, 12);			  //Bedroom door, first up
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.UP, room.getDoorDirection());
		room = board.getCellAt(16, 5);			  //Dungeon door, up right
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.RIGHT, room.getDoorDirection());
		room = board.getCellAt(7, 24);			  //Kitchen door, down right
		assertTrue(room.isDoorway());
		assertEquals(DoorDirection.DOWN, room.getDoorDirection());
		// Test that room pieces that aren't doors know it
		room = board.getCellAt(12, 0);			  //walkway
		assertFalse(room.isDoorway());	
		// Test that walkways are not doors
		BoardCell cell = board.getCellAt(0, 6);
		assertFalse(cell.isDoorway());		

	}
	
	// Test that we have the correct number of doors
	@Test
	public void testNumberOfDoorways() {
		int numDoors = 0;
		for (int row = 0; row < board.getNumRows(); row++)
			for (int col = 0; col < board.getNumColumns(); col++) {
				BoardCell cell = board.getCellAt(row, col);
				if (cell.isDoorway())
					numDoors++;
			}
		assertEquals(26, numDoors);
	}

	// Test a few room cells to ensure the room initial is correct.
	@Test
	public void testRoomInitials() {
		// Test first cell in room
		assertEquals('C', board.getCellAt(0, 0).getInitial());
		assertEquals('K', board.getCellAt(7, 25).getInitial());
		assertEquals('W', board.getCellAt(18, 25).getInitial());
		assertEquals('W', board.getCellAt(19, 16).getInitial());
		assertEquals('W', board.getCellAt(6, 0).getInitial());
		assertEquals('H', board.getCellAt(0, 8).getInitial());
		assertEquals('Z', board.getCellAt(14, 0).getInitial());
		assertEquals('K', board.getCellAt(0, 14).getInitial());
		// Test last cell in room
		assertEquals('C', board.getCellAt(5, 4).getInitial());
		assertEquals('B', board.getCellAt(23, 15).getInitial());
		assertEquals('G', board.getCellAt(25, 19).getInitial());
		assertEquals('R', board.getCellAt(10, 25).getInitial());
		assertEquals('H', board.getCellAt(0, 6).getInitial());
		assertEquals('S', board.getCellAt(8, 0).getInitial());
		assertEquals('K', board.getCellAt(7, 24).getInitial());
		assertEquals('Z', board.getCellAt(14, 0).getInitial());
		// Test a walkway
		assertEquals('W', board.getCellAt(0, 5).getInitial());
		// Test the closet
		assertEquals('X', board.getCellAt(14, 9).getInitial());	
	}
	

}

