//Lindsey Kartvedt, Brianna Lijewski, Amber Walker

package tests;

//IMPORT Statements
import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import experiment.*;


public class IntBoardTests {

	BoardCell[][] board;
	IntBoard test;

	//Sets up the board / game before starting tests
	@Before
	public void setUp() {
		board = new BoardCell[4][4];
		
		//Initializing the board
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = new BoardCell(i, j);
			}
		}
		
		test = new IntBoard(board);
	}

	//Test for the top left corner
	@Test
	public void testAdjacency00() {
		BoardCell cell = test.getCell(0,0);
		Set<BoardCell> testList = test.getAdjList(cell);
		assertNotNull(testList); 							//makes sure contains values to test
		assertTrue(testList.contains(test.getCell(1,0)));
		assertTrue(testList.contains(test.getCell(0,1)));
		assertEquals(2, testList.size());
	}

	//Test for the right side
	@Test
	public void testAdjacency13() {
		BoardCell cell = test.getCell(1,3);
		
		Set<BoardCell> testList = test.getAdjList(cell);
		assertNotNull(testList); 							//makes sure contains values to test
		assertTrue(testList.contains(test.getCell(1,2)));
		assertTrue(testList.contains(test.getCell(2,3)));
		assertTrue(testList.contains(test.getCell(0,3)));
		assertEquals(3, testList.size());
	}

	//Test for the bottom left corner
	@Test
	public void testAdjacency30() {
		BoardCell cell = test.getCell(3, 0);
		Set<BoardCell> testList = test.getAdjList(cell);
		assertNotNull(testList); 							//makes sure contains values to test
		assertTrue(testList.contains(test.getCell(2, 0)));
		assertTrue(testList.contains(test.getCell(3, 1)));
		assertEquals(2, testList.size());
	}

	//Test for the bottom right corner
	@Test
	public void testAdjacency33() {
		BoardCell cell = test.getCell(3,3);
		Set<BoardCell> testList = test.getAdjList(cell);
		assertNotNull(testList); 							//makes sure contains values to test
		assertTrue(testList.contains(test.getCell(3,2)));
		assertTrue(testList.contains(test.getCell(2,3)));
		assertEquals(2, testList.size());
	}

	//Test for the left side
	@Test
	public void testAdjacency10() {
		BoardCell cell = test.getCell(1,0);
		Set<BoardCell> testList = test.getAdjList(cell);
		assertNotNull(testList); 							//makes sure contains values to test
		assertTrue(testList.contains(test.getCell(0,0)));
		assertTrue(testList.contains(test.getCell(2,0)));
		assertTrue(testList.contains(test.getCell(1,1)));
		assertEquals(3, testList.size());
	}

	//Test for the middle 
	@Test
	public void testAdjacency22() {
		BoardCell cell = test.getCell(2,2);
		Set<BoardCell> testList = test.getAdjList(cell);
		assertNotNull(testList); 							//makes sure contains values to test
		assertTrue(testList.contains(test.getCell(1,2)));
		assertTrue(testList.contains(test.getCell(2,1)));
		assertTrue(testList.contains(test.getCell(2,3)));
		assertTrue(testList.contains(test.getCell(3,2)));
		assertEquals(4, testList.size());
	}

	//Test for the middle 2
	@Test
	public void testAdjacency11() {
		BoardCell cell = test.getCell(1,1);
		Set<BoardCell> testList = test.getAdjList(cell);
		assertNotNull(testList); 							//makes sure contains values to test
		assertTrue(testList.contains(test.getCell(1,0)));
		assertTrue(testList.contains(test.getCell(1,2)));
		assertTrue(testList.contains(test.getCell(2,1)));
		assertTrue(testList.contains(test.getCell(0,1)));
		assertEquals(4, testList.size());
	}
	
	/* Tests for calcTarget code:
	 * - Be sure to test different numbers of steps
	 * - I would test from at least two different starting locations
	 * - Number of steps should not exceed 6 (realistic roll of die)
	 */
	
	@Test
	public void testCalcTargetMove3FromOrigin() {
		BoardCell cell = test.getCell(0, 0);
		test.calcTargets(cell, 3);
		Set<BoardCell> targets = test.getTargets();
		assertNotNull(targets); 							//makes sure contains values to test
		
		assertEquals(6, targets.size());

		assertTrue(targets.contains(test.getCell(3, 0)));
		assertTrue(targets.contains(test.getCell(2, 1)));
		assertTrue(targets.contains(test.getCell(0, 1)));
		assertTrue(targets.contains(test.getCell(1, 2)));
		assertTrue(targets.contains(test.getCell(0, 3)));
		assertTrue(targets.contains(test.getCell(1, 0)));	
	}
	
	@Test
	public void testCalcTargetMove2FromOrigin() {
		BoardCell cell = test.getCell(0, 0);
		test.calcTargets(cell, 2); 							//makes sure contains values to test
		Set<BoardCell> targets = test.getTargets();
		assertNotNull(targets);
		
		assertEquals(3, targets.size());
		
		assertTrue(targets.contains(test.getCell(1, 1)));
		assertTrue(targets.contains(test.getCell(2, 0)));
		assertTrue(targets.contains(test.getCell(0, 2)));
	}
	
	@Test
	public void testCalcTargetMove2FromMiddle() {
		BoardCell cell = test.getCell(2, 2);
		test.calcTargets(cell,  2); 
		Set<BoardCell> targets = test.getTargets();
		assertNotNull(targets); 							//makes sure contains values to test
		
		assertEquals(6, targets.size());
		
		assertTrue(targets.contains(test.getCell(1, 3)));
		assertTrue(targets.contains(test.getCell(3, 3)));
		assertTrue(targets.contains(test.getCell(0, 2)));
		assertTrue(targets.contains(test.getCell(1, 1)));
		assertTrue(targets.contains(test.getCell(1, 3)));
		assertTrue(targets.contains(test.getCell(2, 0)));
		
	}
}
