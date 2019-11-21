/**
 * 
 */
package ctlogo.exception;

/**
 * Exception to indicate that some variable is not defined. 
 * 
 * @author Paul Yang
 *
 */
public class CTVariableAlreadyDefinedException extends CTRuntimeException {

	private static final long serialVersionUID = 2270036389981757278L;

	/**
	 * 
	 */
	public CTVariableAlreadyDefinedException() {
	}

	/**
	 * @param message
	 */
	public CTVariableAlreadyDefinedException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CTVariableAlreadyDefinedException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CTVariableAlreadyDefinedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CTVariableAlreadyDefinedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
