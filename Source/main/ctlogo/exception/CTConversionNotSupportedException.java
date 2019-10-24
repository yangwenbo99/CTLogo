package ctlogo.exception;

@SuppressWarnings("serial")
public class CTConversionNotSupportedException extends UnsupportedOperationException {

	public CTConversionNotSupportedException() {
		super("Conversion is not supported.");
	}
	
	public CTConversionNotSupportedException(String s) {
		super(s);
	}

	public CTConversionNotSupportedException(String dataTypeFrom, String dataTypeTo) {
		super("Conversion from " + dataTypeFrom + " to " + dataTypeTo + " is not supported.");
	}

}
