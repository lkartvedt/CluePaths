package clueGame;

public class BadConfigFormatException extends Exception{ //serializable class BadConfigFormatException does not declare a static final serialVersionUID field of type long

	public BadConfigFormatException() {
		super("Config Error Occured");
	}
	
	public BadConfigFormatException(String m) {
		super(m);
	}
}
