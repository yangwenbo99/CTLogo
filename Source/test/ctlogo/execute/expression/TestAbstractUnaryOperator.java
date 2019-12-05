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
public class TestAbstractUnaryOperator {

    Expression ZERO = new LiteralExpression(new CTInteger(0));
    Expression ONE = new LiteralExpression(new CTInteger(1));
    DummyUnaryOperator opr = new DummyUnaryOperator(ZERO);
    
    @Test
    void testConstruct() {
    	Assertions.assertDoesNotThrow(
    			() -> new DummyUnaryOperator(List.<Expression>of(ONE)));
    	Assertions.assertThrows(
    			IllegalArgumentException.class, 
    			() -> new DummyUnaryOperator(List.<Expression>of(ONE, ZERO)));
    }

    @Test 
    void testGetOperand() throws CTException {
    	Assertions.assertSame(ZERO, opr.getOperand());
    }

    @Test 
    void testExecute() throws CTException {
    	Assertions.assertEquals(ZERO.execute(null), opr.execute(null));
    }
}
