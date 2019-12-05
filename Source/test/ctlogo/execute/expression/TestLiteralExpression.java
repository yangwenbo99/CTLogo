package ctlogo.execute.expression;

import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTInteger;
import ctlogo.exception.CTException;

/**
 * @author Paul Yang
 *
 */
public class TestLiteralExpression {

    Expression ZERO = new LiteralExpression(new CTInteger(0));

    @Test
    void test1() throws CTException {
        Assertions.assertEquals(cint(0), ZERO.execute(null));
    }
}
