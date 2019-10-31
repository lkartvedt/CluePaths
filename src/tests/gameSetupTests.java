package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;
import clueGame.Card;
import clueGame.CardType;
import clueGame.DoorDirection;
import clueGame.Player;

public class gameSetupTests {

	private static Board board;
	private static final int NUM_CARDS = 20;
	@BeforeClass
	public static void setUp() {
		// Board is singleton, get the only instance
		board = Board.getInstance();
		// set the file names to use my config files
		board.setConfigFiles("data\\ClueLayout.csv", "data\\RoomLegend.txt", "data\\PlayerData.txt", "data\\CardData.txt");
		// Initialize will load BOTH config files 
		board.initialize();
		board.calcAdjacencies();
		board.deal();
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
		assertEquals(6, board.getAmountCardType(CardType.PERSON));
		assertEquals(9, board.getAmountCardType(CardType.ROOM));
		assertEquals(5, board.getAmountCardType(CardType.WEAPON));
		
		//Testing three cards to make sure the deck contains them
		assertTrue(board.cardExists("Red", CardType.PERSON));
		assertTrue(board.cardExists("Sauna", CardType.ROOM));
		assertTrue(board.cardExists("Kindness", CardType.WEAPON));
	}
	
	
	//Testing the deal of the cards
	@Test
	public void dealDeckTest() {
		int cardsDealt = 0;
		
		ArrayList<Player> playerArray = new ArrayList<Player>(board.playerMaptoPlayerArray(board.getPlayerMap()));
		
		for (Player player : playerArray) {
			assertTrue(player.getHand().size() < 6 && player.getHand().size() > 3 );
			cardsDealt += player.getHand().size();
		}
		
		assertEquals(cardsDealt, board.getDeckSize());
	}
	
	//Testing that the same card is not given to >1 player
	@Test
	public void differentCards() {
		Set<Card> cardsDealt = new HashSet<Card>();
		
		ArrayList<Player> playerArray = new ArrayList<Player>(board.playerMaptoPlayerArray(board.getPlayerMap()));
		for (Player player : playerArray) {
			for(Card card : player.getHand()) {
				if (cardsDealt.contains(card)) {
					fail("Card already dealt");
				}
				
				else {
					cardsDealt.add(card);
				}
			}
		}
	}
	
	//The test ensures the computer correctly picks the target location
	@Test
	public void selectTargetLoc() {
		//This part checks with a room in the target list
		BoardCell loc = board.getCellAt(20, 3);
		board.getPlayer("Blue").setLoc(loc);
		//Runs test 20 times to ensure it always picks the room
		for(int i = 0; i < 20; i++) {
			assertEquals(board.getCellAt(23, 4), board.getPlayerTarget("Blue", 4));
		}
		
		//Test checks that all target spaces are randomly picked, when none is a room
		loc = board.getCellAt(13, 7);
		board.getPlayer("Blue").setLoc(loc);
		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;
		for(int i = 0; i < 100; i++) {
			BoardCell target = board.getPlayerTarget("Blue", 1);
			if(target == board.getCellAt(12, 7)) {
				up++;
			}else if(target == board.getCellAt(14, 7)) {
				down++;
			}else if(target == board.getCellAt(13, 6)) {
				left++;
			}else {
				right++;
			}
		}
		assertTrue(up >= 10);
		assertTrue(down >= 10);
		assertTrue(left >= 10);
		assertTrue(right >= 10);
		
		//Test checks that if previously in room
		loc = board.getCellAt(16, 6);
		board.getPlayer("Blue").setLoc(loc);
		board.getPlayer("Blue").setLastRoom('Z');
		up = 0;
		down = 0;
		left = 0;
		right = 0;
		for(int i = 0; i < 100; i++) {
			BoardCell target = board.getPlayerTarget("Blue", 1);
			if(target == board.getCellAt(15, 6)) {
				up++;
			}else if(target == board.getCellAt(17, 6)) {
				down++;
			}else if(target == board.getCellAt(16, 5)) {
				left++;
			}else {
				right++;
			}
		}
		assertTrue(up >= 10);
		assertTrue(down >= 10);
		assertTrue(left >= 10);
		assertTrue(right >= 10);
	}

}
