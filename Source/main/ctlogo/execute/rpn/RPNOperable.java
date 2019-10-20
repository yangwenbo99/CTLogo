package ctlogo.execute.rpn;

import java.util.List;

import ctlogo.exception.CTCodeNotEvaluableException;

/**
 *
 *
 * @author Paul Yang
 */
public interface RPNOperable extends RPNObject {
    /**
     * Get the number of parameter.
     *
     * @return the number of parameter if this operator has fixed numberof 
     * parameter, 0 if it takes no parameter and negative if it has
     * variable number of parameter. 
     *
     * If the number of parameter is variable, then the all pending 
     * evaluable RPNObjects on the stack shall be passed in, until either
     * an non-evaluable RPNObject meet. If this non-evaluable RPNObject is 
     * RPNTerminator, then this object can be optionally the last element 
     * in the argument list passed in.
     */
    int getParameterNumber();

    /**
     * Perform operation. 
     *
     * @param operands the operands of the operable RPNObject
     * @return the result of this operation
     *
     * @throws CTCodeNotEvaluableException when some arguments passed in 
     * are not evaluable.
     */
    RPNObject operateOn(List<RPNObject> operands) 
            throws CTCodeNotEvaluableException; 

    default boolean isOperable() { return true; }
    default boolean isEvaluable() { return false; }
    default boolean isTerminator() { return false; }
}
