package clueGame;

public class Player {
	private String name;
	private String color;
	BoardCell cell;
	
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
		return new BoardCell(0, 0, "");
	}
}
