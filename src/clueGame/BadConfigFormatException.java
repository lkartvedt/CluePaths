package clueGame;

public class BadConfigFormatException extends Exception{

	public BadConfigFormatException() {
		super();
	}

	public BadConfigFormatException(char t) {
		super("Config Error: " + t + "is not found in your room config file");
	}
	
	public BadConfigFormatException(String m) {
		super(m);
	}
}
