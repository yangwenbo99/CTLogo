package ctlogo.exception;

@SuppressWarnings("serial")
public class CTException extends Exception {
	public CTException(String message) {
		super(message);
	}

	public CTException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
