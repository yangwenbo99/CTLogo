/**
 * 
 */
package ctlogo.execute.rpn;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import ctlogo.exception.CTCodeNotEvaluableException;
import ctlogo.exception.CTLogicException;
import ctlogo.execute.expression.Expression;

/**
 * @author Paul Yang
 *
 */
public class RPNExpressionExecutor {

    private static final RPNExpressionExecutor instance = new RPNExpressionExecutor();

    private RPNExpressionExecutor () { }

    public static RPNExpressionExecutor getInstance() {
        return instance;
    }

    /**
     *
     *
     * @param rpns the RPN operations
     * @return the resulting expression
     *
     * @throws CTLogicException if operand not found
     *
     * TODO: more specified exception
     */
    public List<Expression> execute(List<RPNObject> rpns) throws CTLogicException {
        Stack<RPNObject> rpnStack = new Stack<>();
        List<Expression> resExp = new ArrayList<>();
        try {
            for (RPNObject rpn : rpns) {

                if (rpn.isEvaluable() || rpn.isTerminator()) {
                    rpnStack.push(rpn);
                } else if (rpn.isOperable()) {
                    RPNOperable rpnOperable = (RPNOperable) rpn;
                    int operandNum = rpnOperable.getParameterNumber();
                    List<RPNObject> operands;

                    assert(operandNum >= 0);
					operands = new ArrayList<>(
							rpnStack.subList(rpnStack.size()-operandNum, rpnStack.size()));
					for (int i=0; i<operandNum; i++) {
						rpnStack.pop();
					}
                    RPNObject res = rpnOperable.operateOn(operands);
                    assert(res.isEvaluable());
                    rpnStack.push(res);
                }
            }

            for (RPNObject rpn : rpnStack) {
                if (!rpn.isEvaluable()) {
                    throw new CTLogicException("Result not evaluable");
                }
                resExp.add(((RPNEvaluable) rpn).getExpression());
            }
        } catch (EmptyStackException | IndexOutOfBoundsException e) {
            throw new CTLogicException("Operand not found");
        } catch (CTCodeNotEvaluableException e) {
            // TODO: more specific exception
            throw new CTLogicException("Some operand cannot be evaluated");
        }
           return resExp;
    }
}
