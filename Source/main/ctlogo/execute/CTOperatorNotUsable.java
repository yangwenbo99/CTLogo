/**
 * 
 */
package ctlogo.execute;

/**
 * @author yang
 *
 */
public class CTOperatorNotUsable extends CTCodeNotEvaluableException {

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
