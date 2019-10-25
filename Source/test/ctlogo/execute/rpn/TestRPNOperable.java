package ctlogo.execute.rpn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTCodeNotEvaluableException;
import ctlogo.exception.CTUnexpectedExpressionException;
import ctlogo.execute.DummpExpression;
import ctlogo.execute.rpn.RPNBinaryOperation;
import ctlogo.execute.rpn.RPNEvaluable;
import ctlogo.execute.rpn.RPNExpressionWrapper;
import ctlogo.execute.rpn.RPNObject;
import ctlogo.execute.rpn.RPNOperable;

import java.util.List;
import java.util.Arrays;

public class TestRPNOperable {

    public TestRPNOperable() {
        // TODO Auto-generated constructor stub
    }

    @Test 
    void testTrivalBasics() throws CTCodeNotEvaluableException {
        RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
        RPNOperable unary = new RPNUnaryOperation(DummpExpression.class);
        Assertions.assertEquals(1, unary.getParameterNumber());

    }

    @Test 
    void testTrivalUnary() throws CTCodeNotEvaluableException {
        RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
        RPNOperable unary = new RPNUnaryOperation(DummpExpression.class);
        List<RPNObject> list = Arrays.asList(
                new RPNObject [] {
                        rpneva
                });
        List<RPNObject> wrongList = Arrays.asList(
                new RPNObject [] {
                        rpneva, rpneva, rpneva
                });
        RPNObject res = unary.operateOn(list);
        Assertions.assertEquals((new DummpExpression(1)), ((RPNEvaluable) res).getExpression());
        Assertions.assertNotEquals((new DummpExpression(0)), ((RPNEvaluable) res).getExpression());
        Assertions.assertThrows(CTUnexpectedExpressionException.class, 
                () -> unary.operateOn(wrongList));
    }
    
    @Test 
    void testTrivalBinary() throws CTCodeNotEvaluableException {
        RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
        RPNOperable binary = new RPNBinaryOperation(DummpExpression.class);
        List<RPNObject> list = Arrays.asList(
                new RPNObject [] {
                        rpneva, rpneva
                });
        RPNObject res = binary.operateOn(list);
        Assertions.assertEquals((new DummpExpression(2)), ((RPNEvaluable) res).getExpression());
        Assertions.assertNotEquals((new DummpExpression(1)), ((RPNEvaluable) res).getExpression());
    }
    

}
