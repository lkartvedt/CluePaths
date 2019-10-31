package clueGame;

import java.util.ArrayList;

public abstract class Player {
	private String name;
	private String color;
	private BoardCell cell;
	char lastRoom;
	private ArrayList<Card> cardHand = new ArrayList<Card>();
	
	
	public Player(String name, String color, BoardCell cell) {
		this.name = name;
		this.color = color;
		this.cell = cell;
	}
	public String getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
	public BoardCell getLoc() {
		return cell;
	}
	
	public ArrayList<Card> getHand() {
		return cardHand;
	}
	
	public void addCard(Card card) {
		cardHand.add(card);
	}
	
	public void setHands(ArrayList<Card> cardsInHand) {
		this.cardHand = cardsInHand;
	}

	public abstract BoardCell selectTarget(int i);
	
	//Used for tests only
	public void setLoc(BoardCell cell) {
		this.cell = cell;
	}
	
	//Used for tests only
	public void setLastRoom(char initial) {
		lastRoom = initial;
	}
}
