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

}
