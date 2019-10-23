package clueGame;

public class BadConfigFormatException extends Exception{

	public BadConfigFormatException() {
		super("Config Error Occured");
	}
	
	public BadConfigFormatException(String m) {
		super(m);
	}
}
