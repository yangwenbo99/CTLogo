/**
 * 
 */
package ctlogo.exception;

/**
 * @author yang
 *
 */
public class CTOperatorNotUsable extends CTCodeNotEvaluableException {

	private static final long serialVersionUID = -8935296985622778191L;

	/**
	 * @param message
	 */
	public CTOperatorNotUsable(String message) {
		super(message);
	}
	
	public CTOperatorNotUsable(Class<?> operator) {
		super("Constructor for" + operator.toString() + " cannot be used.");
	}

}
