package ctlogo.execute.expression;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTInteger;
import ctlogo.exception.CTException;

/**
 * @author Paul Yang
 *
 */
public class TestAbstractBinaryOperator {

    Expression ZERO = new LiteralExpression(new CTInteger(0));
    Expression ONE = new LiteralExpression(new CTInteger(1));
    DummyBinaryOperator opr = new DummyBinaryOperator(ZERO, ONE);
    
    @Test
    void testConstruct() {
    	Assertions.assertDoesNotThrow(
    			() -> new DummyBinaryOperator(List.<Expression>of(ONE, ZERO)));
    	Assertions.assertThrows(
    			IllegalArgumentException.class, 
    			() -> new DummyBinaryOperator(List.<Expression>of(ONE)));
    }

    @Test 
    void testGetOperand() throws CTException {
    	Assertions.assertSame(ZERO, opr.getOperand1());
    	Assertions.assertSame(ONE, opr.getOperand2());
    }

    @Test 
    void testExecute() throws CTException {
    	Assertions.assertEquals(ZERO.execute(null), opr.execute(null));
    }
}
