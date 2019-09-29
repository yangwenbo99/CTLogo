package ctlogo.exception;

@SuppressWarnings("serial")
public class CTDataUndefinedException extends CTDataException {

	public CTDataUndefinedException() {
		super("Data is undefined");
	}

	public CTDataUndefinedException(String message) {
		super(message + " is undefined");
	}

}
