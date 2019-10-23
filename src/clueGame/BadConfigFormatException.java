package clueGame;

public class BadConfigFormatException extends Exception{

	public BadConfigFormatException() {
		super();
	}

	public BadConfigFormatException(char t) {
		super(t + "is not found in your room config file.");
	}
}
