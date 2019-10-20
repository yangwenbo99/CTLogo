/**
 * 
 */
package ctlogo.execute.rpn;

import ctlogo.execute.expression.*;

/**
 * The factory and manger of RPNExpression objects. 
 *
 * @author Paul Yang
 *
 */
public class RPNExpressionManager {

    /**
     *
     *
     * @param token token of the operator
     * @return the oeprator
     *
     * @throws NoSuchElementException if no such token
     */
    public RPNOperable getBinaryOperator(String token) {
        Class<? extends Expression> operatorExpressionClass = 
            OperatorManager.getInstance().getBinaryOperationExpression(token);
        return new RPNBinaryOperation(operatorExpressionClass);
    }

    /**
     *
     *
     * @param token token of the operator
     * @return the oeprator
     *
     * @throws NoSuchElementException if no such token
     */
    public RPNOperable getUnaryOperator(String token) {
        Class<? extends Expression> operatorExpressionClass = 
            OperatorManager.getInstance().getBinaryOperationExpression(token);
        return new RPNUnaryOperation(operatorExpressionClass);
    }

    public RPNOperable getFunctionCallOperator(String funcitonName) {
        throw new UnsupportedOperationException("To be implemented");
    }

}
