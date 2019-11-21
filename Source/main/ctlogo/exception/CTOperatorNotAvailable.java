/**
 * 
 */
package ctlogo.exception;

/**
 * @author yang
 *
 */
public class CTOperatorNotAvailable extends CTCodeNotEvaluableException {

	private static final long serialVersionUID = 3652132540074415514L;

	/**
	 * @param message
	 */
	public CTOperatorNotAvailable(String message) {
		super(message);
	}
	
	public CTOperatorNotAvailable(Class<?> operator) {
		super("Cannot find for" + operator.toString() + ".");
	}

}
