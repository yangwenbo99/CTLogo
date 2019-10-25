/**
 * 
 */
package ctlogo.execute.expression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.*;
import ctlogo.exception.CTException;

/**
 * @author Paul Yang
 *
 */
public class TestExpression {

    Expression ZERO = new LiteralExpression(new CTInteger(0));
    Expression ONE = new LiteralExpression(new CTInteger(1));
    Expression FIVE = new LiteralExpression(new CTInteger(5));
    Expression SIX = new LiteralExpression(new CTInteger(6));
    Expression SEVENTEEN = new LiteralExpression(new CTInteger(17));

    @Test 
    void testExpressionTrival() throws CTException {
        Assertions.assertEquals(SIX.execute(null), (new PlusOperator(ONE, FIVE)).execute(null));
    }
}
