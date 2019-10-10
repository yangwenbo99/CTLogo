/**
 * 
 */
package ctlogo.execute;

import ctlogo.exception.CTSyntaxException;

/**
 * @author yang
 *
 */
public class CTCodeNotEvaluableException extends CTSyntaxException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public CTCodeNotEvaluableException(String message) {
        super(message);
    }

}
