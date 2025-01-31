/**
 * 
 */
package ctlogo.execute.rpn;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import ctlogo.exception.CTCodeNotEvaluableException;
import ctlogo.exception.CTOperatorNotAvailable;
import ctlogo.exception.CTOperatorNotUsable;
import ctlogo.exception.CTUnexpectedExpressionException;
import ctlogo.execute.expression.Expression;

/**
 * @author Paul Yang
 *
 */
abstract class RPNOperation implements RPNOperable {

    Class<? extends Expression> operator;
    
    protected Class<? extends Expression> getOperator() {
        return operator;
    }

    /**
     * 
     */
    public RPNOperation(Class<? extends Expression> operator) {
        this.operator = operator;
    }

    @Override
    abstract public int getParameterNumber();

    @Override
    public RPNObject operateOn(List<RPNObject> operands) 
        throws CTCodeNotEvaluableException {
        Expression res = null;
        if (operands.size() != getParameterNumber()) 
            throw new CTUnexpectedExpressionException(
                    String.format("The operation takes exactly %d operand", getParameterNumber()));

        List<Expression> operandExpressions = new ArrayList<>();
        for (RPNObject operand : operands) {
            if (! operand.isEvaluable())
                throw new CTUnexpectedExpressionException(
                        "Operand must be evaluable");
            operandExpressions.add(
                    ((RPNEvaluable) operand).getExpression());
        }
        
        try {
            Constructor<? extends Expression> constructor =
                    operator.getConstructor(List.class);
            res = constructor.newInstance(operandExpressions);
        } catch (NoSuchMethodException | SecurityException e) {
            throw(new CTOperatorNotAvailable(operator));
        } catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException e) {
            throw(new CTOperatorNotUsable(operator));
        }
        
        return new RPNExpressionWrapper(res);
    }
}
