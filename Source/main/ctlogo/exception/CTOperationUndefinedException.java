package ctlogo.exception;

@SuppressWarnings("serial")
public class CTOperationUndefinedException extends UnsupportedOperationException {

	public CTOperationUndefinedException() {
		super("Conversion is not supported.");
	}
	
	public CTOperationUndefinedException(String s) {
		super(s);
	}

	public CTOperationUndefinedException(String dataTypeFrom, String dataTypeTo) {
		super("Conversion from " + dataTypeFrom + " to " + dataTypeTo + " is not supported.");
	}

}
