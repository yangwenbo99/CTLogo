/**
 * 
 */
package ctlogo.execute.rpn;

import java.util.NoSuchElementException;

import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.OperatorManager;

/**
 * The factory and manger of RPNExpression objects. 
 *
 * @author Paul Yang
 *
 */
public class RPNOperationManager {

    private static final RPNOperationManager thisInstance = new RPNOperationManager();

    public static RPNOperationManager getInstance() {
        return thisInstance;
    }

    /**
     *
     *
     * @param token token of the operator
     * @return the operator
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
     * @return the operator
     *
     * @throws NoSuchElementException if no such token
     */
    public RPNOperable getUnaryOperator(String token) {
        Class<? extends Expression> operatorExpressionClass = 
            OperatorManager.getInstance().getUnaryOperationExpression(token);
        return new RPNUnaryOperation(operatorExpressionClass);
    }

}
