/**
 * 
 */
package ctlogo.execute;

import ctlogo.execute.expression.Expression;

/**
 * @author Paul Yang
 *
 */
interface RPNEvaluable extends RPNObject {
    /**
     * Get the expression that this RPNObject should be evaluated to. 
     *
     * @return the target expression object. 
     */
    Expression getExpression();

    default boolean isOperable() { return false; }
    default boolean isEvaluable() { return true; }
    default boolean isTerminator() { return false; }
}
