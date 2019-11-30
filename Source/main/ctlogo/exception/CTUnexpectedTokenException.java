/**
 * 
 */
package ctlogo.exception;

/**
 * @author yang
 *
 */
public class CTUnexpectedTokenException extends CTSyntaxException {

	/**
	 * @param message The message.
	 */
	public CTUnexpectedTokenException(String message) {
		super(message);
	}

	/**
	 * @param message The message.
	 * @param throwable the exception causing this exception.
	 */
	public CTUnexpectedTokenException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * @param message The message.
	 */
	public CTUnexpectedTokenException(String expected, String actual) {
		super(String.format(
					"Unexpected token, expecting \"%s\", given \"%s\"",
					expected,
					actual));
	}

}
