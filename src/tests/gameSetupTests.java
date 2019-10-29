package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;
import clueGame.DoorDirection;

public class gameSetupTests {

	private static Board board;
	@BeforeClass
	public static void setUp() {
		// Board is singleton, get the only instance
		board = Board.getInstance();
		// set the file names to use my config files
		board.setConfigFiles("data\\ClueLayout.csv", "data\\RoomLegend.txt", "data\\");
		// Initialize will load BOTH config files 
		board.initialize();
		board.calcAdjacencies();
	}
	
	@Test
	public void playerDataTest() {
		assertEquals("Bob", board.getPlayer("Blue").getName());
		assertEquals("Blue", board.getPlayer("Blue").getColor());
		BoardCell room = board.getCellAt(8, 25);
		assertEquals(room, board.getPlayer("Blue").getLoc());
		
		assertEquals("Rachel", board.getPlayer("Red").getName());
		assertEquals("Red", board.getPlayer("Red").getColor());
		room = board.getCellAt(18, 25);
		assertEquals(room, board.getPlayer("Red").getLoc());
		
		assertEquals("Yermolai", board.getPlayer("Yellow").getName());
		assertEquals("Yellow", board.getPlayer("Yellow").getColor());
		room = board.getCellAt(13, 0);
		assertEquals(room, board.getPlayer("Yellow").getLoc());
		
		assertEquals("Grace", board.getPlayer("Green").getName());
		assertEquals("Green", board.getPlayer("Green").getColor());
		room = board.getCellAt(20, 0);
		assertEquals(room, board.getPlayer("Green").getLoc());
	}

}
