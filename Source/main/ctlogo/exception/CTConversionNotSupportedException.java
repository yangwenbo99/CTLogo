package ctlogo.exception;

public class CTConversionNotSupportedException extends UnsupportedOperationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7681222632738005940L;

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
