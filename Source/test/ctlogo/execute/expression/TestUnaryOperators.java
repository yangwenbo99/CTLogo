package ctlogo.execute.expression;

import static ctlogo.data.TestDataUtility.cdbl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTInteger;
import ctlogo.exception.CTException;

/**
 * @author Paul Yang
 *
 */
public class TestUnaryOperators {

    Expression ZERO = new LiteralExpression(new CTInteger(0));
    Expression ONE = new LiteralExpression(new CTInteger(1));
    Expression ONEM = new LiteralExpression(new CTInteger(-1));
    Expression DTWO = new LiteralExpression(cdbl(2));
    Expression FIVE = new LiteralExpression(new CTInteger(5));
    Expression DFIVE = new LiteralExpression(cdbl(5));
    Expression SIX = new LiteralExpression(new CTInteger(6));
    Expression SEVEN = new LiteralExpression(new CTInteger(7));
    Expression SEVENTEEN = new LiteralExpression(new CTInteger(17));
    Expression DSEVENTEEN = new LiteralExpression(new CTInteger(17));
    Expression TRUE = new LiteralExpression(CTBoolean.TRUE);
    Expression FALSE = new LiteralExpression(CTBoolean.FALSE);

    @Test 
    void testPositiveTrival() throws CTException {
        Assertions.assertEquals(
        		ONE.execute(null), 
        		(new PositiveOperator(ONE)).execute(null));
        Assertions.assertEquals(
        		ONE.execute(null), 
        		(new PositiveOperator(List.<Expression>of(ONE))).execute(null));
    }

    @Test 
    void testNegativeTrival() throws CTException {
        Assertions.assertEquals(
        		ONEM.execute(null), 
        		(new NegativeOperator(ONE)).execute(null));
        Assertions.assertEquals(
        		ONEM.execute(null), 
        		(new NegativeOperator(List.<Expression>of(ONE))).execute(null));
    }

}
