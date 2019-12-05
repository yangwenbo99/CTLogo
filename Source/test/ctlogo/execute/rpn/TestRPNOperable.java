package ctlogo.execute.rpn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTValue;
import ctlogo.exception.CTCodeNotEvaluableException;
import ctlogo.exception.CTException;
import ctlogo.exception.CTOperatorNotAvailable;
import ctlogo.exception.CTOperatorNotUsable;
import ctlogo.exception.CTUnexpectedExpressionException;
import ctlogo.execute.Context;
import ctlogo.execute.DummpExpression;
import ctlogo.execute.expression.Expression;

public class TestRPNOperable {

    public TestRPNOperable() {
    }

	/*
    @Test 
    void testUnaryParamNum() throws CTCodeNotEvaluableException {
        RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
        RPNOperable unary = new RPNUnaryOperation(DummpExpression.class);
        Assertions.assertEquals(1, unary.getParameterNumber());
    }
	*/

    @Test 
    void testUnary() throws CTCodeNotEvaluableException {
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
    void testBinary() throws CTCodeNotEvaluableException {
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

    class StubRPNOperation extends RPNOperation {

        private int opn;

        public StubRPNOperation(
                Class<? extends Expression> operator, 
                int opn) {
            super(operator);
            this.opn = opn;
        }

        @Override
        public int getParameterNumber() {
            return opn;
        }

        public Class<? extends Expression> getOperator() {
            return super.getOperator();
        }
    }

	@Test
	void testWrongParamNumber() {
        RPNOperable rpnOP0 = new StubRPNOperation(
                DummyExpNoContructor.class,
                1);
        Assertions.assertThrows(
                CTUnexpectedExpressionException.class,
                () -> rpnOP0.operateOn(List.<RPNObject>of(
                        rpnOP0)));
	}
    
    @Test 
    void testTrivalWrongContructorParamNumber() throws CTCodeNotEvaluableException {
        RPNEvaluable rpneva = new RPNExpressionWrapper(new DummpExpression());
        RPNOperable rpnOP0 = new StubRPNOperation(
                DummyExpNoContructor.class,
                0);
        RPNOperable rpnOP1 = new StubRPNOperation(
                AbsDummyExpNoContructor.class,
                1);
        Assertions.assertThrows(
                CTOperatorNotAvailable.class,
                () -> rpnOP0.operateOn(List.<RPNObject>of()));
        Assertions.assertThrows(
                CTOperatorNotUsable.class,
                () -> rpnOP1.operateOn(List.<RPNObject>of(rpneva)));
    }

    @Test 
    void testTrivalGetOperator() throws CTCodeNotEvaluableException {
        StubRPNOperation rpnOP0 = new StubRPNOperation(
                DummyExpNoContructor.class,
                0);
        Assertions.assertEquals(
                DummyExpNoContructor.class,
                rpnOP0.getOperator()
                );
    }
}

abstract class AbsDummyExpNoContructor implements Expression {
    public AbsDummyExpNoContructor(List<Expression> l) {
    }
}

class DummyExpNoContructor extends AbsDummyExpNoContructor {

    private DummyExpNoContructor() {
        super(null);
    } 

    @Override
    public CTValue execute(Context context) throws CTException {
        return null;
    }
}

