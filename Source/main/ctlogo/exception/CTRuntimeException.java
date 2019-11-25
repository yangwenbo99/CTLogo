package ctlogo.exception;

public class CTRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6153857924677681324L;

	public CTRuntimeException() {
	}

	public CTRuntimeException(String message) {
		super(message);
	}

	public CTRuntimeException(Throwable cause) {
		super(cause);
	}

	public CTRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CTRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
