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
public class CTVariableNotDefinedException extends CTRuntimeException {

	private static final long serialVersionUID = 2270036389981757278L;

	/**
	 * 
	 */
	public CTVariableNotDefinedException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public CTVariableNotDefinedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public CTVariableNotDefinedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CTVariableNotDefinedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CTVariableNotDefinedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
