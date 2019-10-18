/**
 * 
 */
package ctlogo.execute;

/**
 * @author yang
 *
 */
public class CTOperatorNotAvailable extends CTCodeNotEvaluableException {

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
