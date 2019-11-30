package ctlogo.execute.expression;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestOperatorManager {
    private static final OperatorManager mgr = OperatorManager.getInstance();

    @BeforeAll
    static void init() {
        mgr.registerUnaryOperator("@", DummyUnaryOperator.class);
        mgr.registerBinaryOperator("`", DummyBinaryOperator.class);
    }

    @Test 
    void testRegister() {
        Assertions.assertThrows(IllegalArgumentException.class, 
                () -> mgr.registerUnaryOperator("@", DummyUnaryOperator.class)
                );
        Assertions.assertDoesNotThrow(
                () -> mgr.registerUnaryOperator("$", DummyUnaryOperator.class)
                );
        Assertions.assertThrows(IllegalArgumentException.class, 
                () -> mgr.registerBinaryOperator("`", DummyBinaryOperator.class)
                );
    }

    @Test 
    void testGet() {
        Assertions.assertEquals(
                DummyUnaryOperator.class,
                mgr.getUnaryOperationExpression("@"));
        Assertions.assertEquals(
                DummyBinaryOperator.class,
                mgr.getBinaryOperationExpression("`"));
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> mgr.getUnaryOperationExpression("%&^*&*()"));
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> mgr.getBinaryOperationExpression("%&^*&*()"));

    }

    @Test
    void testHas() {
        Assertions.assertTrue(mgr.hasUnaryOperator("@"));
        Assertions.assertTrue(mgr.hasBinaryOperator("`"));
        Assertions.assertFalse(mgr.hasUnaryOperator("asdfg"));
        Assertions.assertFalse(mgr.hasBinaryOperator("asdfg"));
    }

}
