package clueGame;

public class Card {

	String name;
	CardType type;
	
	public Card(String name, String type) {
		this.name = name;
		switch(type) {
			case "Person":
				this.type = CardType.PERSON;
				break;
			case "Room":
				this.type = CardType.ROOM;
				break;
			case "Weapon":
				this.type = CardType.WEAPON;
		}
	}
	
	public boolean equalCards(Card otherCard) {
		return false;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(CardType type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public CardType getCardType() {
		return type;
	}
}
