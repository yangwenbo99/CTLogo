package ctlogo.execute.expression;

import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTInteger;
import ctlogo.exception.CTException;

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
        Assertions.assertEquals(cint(119), (new MultiplyOperator(SEVEN, SEVENTEEN)).execute(null));
        Assertions.assertEquals(cint(7), (new MultiplyOperator(TRUE, SEVEN)).execute(null));
    }

    @Test
    void testDivisionTrival() throws CTException {
        Assertions.assertEquals(cint(2), (new DivisionOperator(SEVENTEEN, SEVEN)).execute(null));
        Assertions.assertEquals(cint(2), (new DivisionOperator(FIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(2.5), (new DivisionOperator(DFIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(2.5), (new DivisionOperator(FIVE, DTWO)).execute(null));
        Assertions.assertEquals(cdbl(2.5), (new DivisionOperator(DFIVE, DTWO)).execute(null));
    }

    @Test
    void testModuloTrival() throws CTException {
        Assertions.assertEquals(cint(3), (new ModuloOperator(SEVENTEEN, SEVEN)).execute(null));
        Assertions.assertEquals(cint(1), (new ModuloOperator(FIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(1), (new ModuloOperator(DFIVE, TWO)).execute(null));
        Assertions.assertEquals(cdbl(1), (new ModuloOperator(FIVE, DTWO)).execute(null));
        Assertions.assertEquals(cdbl(1), (new ModuloOperator(DFIVE, DTWO)).execute(null));
    }
}
