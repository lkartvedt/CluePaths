package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;
import clueGame.DoorDirection;

public class gameSetupTests {

	private static Board board;
	@Before
	public void setUp() {
		// Board is singleton, get the only instance
		board = Board.getInstance();
		// set the file names to use my config files
		board.setConfigFiles("data\\ClueLayout.csv", "data\\RoomLegend.txt", "data\\PlayerData.txt");
		// Initialize will load BOTH config files 
		board.initialize();
		board.calcAdjacencies();
	}
	
	@Test
	public void playerDataTest() {
		//Checks blue player's details are correct
		assertEquals("Bob", board.getPlayer("Blue").getName());
		assertEquals("Blue", board.getPlayer("Blue").getColor());
		BoardCell room = board.getCellAt(8, 25);
		assertEquals(room, board.getPlayer("Blue").getLoc());
		
		//Checks red player's details are correct
		assertEquals("Rachel", board.getPlayer("Red").getName());
		assertEquals("Red", board.getPlayer("Red").getColor());
		room = board.getCellAt(18, 25);
		assertEquals(room, board.getPlayer("Red").getLoc());
		
		//Checks yellow player's details are correct
		assertEquals("Yermolai", board.getPlayer("Yellow").getName());
		assertEquals("Yellow", board.getPlayer("Yellow").getColor());
		room = board.getCellAt(13, 0);
		assertEquals(room, board.getPlayer("Yellow").getLoc());
		
		//Checks green player's details are correct
		assertEquals("Grace", board.getPlayer("Green").getName());
		assertEquals("Green", board.getPlayer("Green").getColor());
		room = board.getCellAt(20, 0);
		assertEquals(room, board.getPlayer("Green").getLoc());
	}
	
	@Test
	public void deckSetupTest() {
		//Checks if the deck is the right size
		assertEquals(20, board.getDeckSize());
		
		//Checks if the correct amount of each type are in the deck
		assertEquals(6, board.getAmountCards("Person"));
		assertEquals(9, board.getAmountCards("Room"));
		assertEquals(5, board.getAmountCards("Weapon"));
		
		//Testing three cards to make sure the deck contains them
		assertTrue(board.cardExists("Red","Person"));
		assertTrue(board.cardExists("Sauna","Room"));
		assertTrue(board.cardExists("Kindness","Weapon"));
	}

}
