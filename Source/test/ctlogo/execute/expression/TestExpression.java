/**
 * 
 */
package ctlogo.execute.expression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.*;
import ctlogo.exception.CTException;

import static ctlogo.data.TestDataUtility.*;

/**
 * @author Paul Yang
 *
 */
public class TestExpression {

    Expression ZERO = new LiteralExpression(new CTInteger(0));
    Expression ONE = new LiteralExpression(new CTInteger(1));
    Expression TWO = new LiteralExpression(new CTInteger(2));
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
    void testPlusTrival() throws CTException {
        Assertions.assertEquals(SIX.execute(null), (new PlusOperator(ONE, FIVE)).execute(null));
        Assertions.assertEquals(SIX.execute(null), (new PlusOperator(FIVE, TRUE)).execute(null));
    }

    @Test
    void testMinusTrival() throws CTException {
        Assertions.assertEquals(SIX.execute(null), (new MinusOperator(SEVEN, ONE)).execute(null));
        Assertions.assertEquals(ZERO.execute(null), (new MinusOperator(TRUE, TRUE)).execute(null));
    }

    @Test
    void testMultiplyTrival() throws CTException {
        Assertions.assertEquals(cint(119), (new MultiplyOperation(SEVEN, SEVENTEEN)).execute(null));
        Assertions.assertEquals(cint(7), (new MultiplyOperation(TRUE, SEVEN)).execute(null));
    }

    @Test
    void testDivisionTrival() throws CTException {
        Assertions.assertEquals(cint(2), (new DivisionOperation(SEVENTEEN, SEVEN)).execute(null));
        Assertions.assertEquals(cint(2), (new DivisionOperation(FIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(2.5), (new DivisionOperation(DFIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(2.5), (new DivisionOperation(FIVE, DTWO)).execute(null));
        Assertions.assertEquals(cdbl(2.5), (new DivisionOperation(DFIVE, DTWO)).execute(null));
    }

    @Test
    void testModuloTrival() throws CTException {
        Assertions.assertEquals(cint(3), (new ModuloOperation(SEVENTEEN, SEVEN)).execute(null));
        Assertions.assertEquals(cint(1), (new ModuloOperation(FIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(1), (new ModuloOperation(DFIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(1), (new ModuloOperation(FIVE, DTWO)).execute(null));
        Assertions.assertEquals(cdbl(1), (new ModuloOperation(DFIVE, DTWO)).execute(null));
    }
}
