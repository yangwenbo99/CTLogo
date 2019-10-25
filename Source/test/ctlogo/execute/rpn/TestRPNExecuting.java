package ctlogo.execute.rpn;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTException;
import ctlogo.exception.CTLogicException;
import ctlogo.execute.expression.*;
import ctlogo.data.*;
import static ctlogo.data.TestDataUtility.*;


public class TestRPNExecuting {
    private final static RPNOperable PLUS = new RPNBinaryOperation(PlusOperator.class);
    private final static RPNOperable MINU = new RPNBinaryOperation(MinusOperator.class);
    private final static RPNOperable MILT = new RPNBinaryOperation(MultiplyOperator.class);
    private final static RPNOperable DIVS = new RPNBinaryOperation(DivisionOperator.class);
    private final static RPNOperable MODS = new RPNBinaryOperation(ModuloOperator.class);

    private List<CTValue> exec(List<RPNObject> list) throws CTException {
        List<Expression> exps = RPNExpressionExecutor.getInstance().execute(list);
        List<CTValue> values = new ArrayList<>();

        for (Expression exp : exps) {
            values.add(exp.execute(null));
        }
        return values;
    }

    private CTValue firstVal(List<RPNObject> list) throws CTException {
        return exec(list).get(0);
    }

    private RPNExpressionWrapper w(Expression exp) {
        return new RPNExpressionWrapper(exp);
    }

    private LiteralExpression le(CTValue v) {
        return new LiteralExpression(v);
    }

    private RPNExpressionWrapper wle(CTValue v) {
        return w(le(v));
    }

    @Test
    void testBasicsValues() throws CTException {
        Assertions.assertArrayEquals(
                new Object [] {},
                exec(new ArrayList<RPNObject>()).toArray());
        Assertions.assertArrayEquals(
                new Object [] {cint(10)}, 
                exec(List.<RPNObject>of(wle(cint(10)))).toArray());
        Assertions.assertArrayEquals(
                new Object [] {cint(10), cint(20)}, 
                exec(List.<RPNObject>of(wle(cint(10)), wle(cint(20)))).toArray());
        Assertions.assertArrayEquals(
                new Object [] {cint(10), cint(20), cint(30)}, 
                exec(List.<RPNObject>of(
                        wle(cint(10)), 
                        wle(cint(20)), 
                        wle(cint(30)))).toArray());
    }

    @Test
    void testTrivialOperations() throws CTException {
        Assertions.assertArrayEquals(
                new Object [] {cint(30)}, 
                exec(List.<RPNObject>of(
                        wle(cint(10)), 
                        wle(cint(20)), 
                        PLUS)).toArray());
    }

    @Test 
    void testTrivialException() throws CTException {
        // operand not found
        Assertions.assertThrows(
                CTLogicException.class,
                () -> exec(List.<RPNObject>of(
                        wle(cint(20)), 
                        PLUS)));
    }


}
