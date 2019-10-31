package clueGame;

import java.util.ArrayList;

public class Player {
	private String name;
	private String color;
	BoardCell cell;
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
	
}
