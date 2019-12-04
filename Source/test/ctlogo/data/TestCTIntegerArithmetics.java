package ctlogo.data;

import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 *
 * @author Paul Yang
 *
 * Since CTInteger will be testted when testing CTString, we only test some 
 * method here.
 */
public class TestCTIntegerArithmetics {
    @Test
    void testConstruct() {
        Assertions.assertEquals(cint(100), new CTInteger(Long.valueOf(100)));
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(cint(3), cint(1).add(cint(2)));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).add(cstr("test")));
    }

    @Test
    void testSubstract() {
        Assertions.assertEquals(cint(-1), cint(1).subtract(cint(2)));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).subtract(cstr("test")));
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(cint(6), cint(3).multiply(cint(2)));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).multiply(cstr("test")));
    }

    @Test
    void testDivide() {
        Assertions.assertEquals(cint(1), cint(3).divide(cint(2)));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).divide(cstr("test")));
    }

    @Test
    void testMod() {
        Assertions.assertEquals(cint(1), cint(3).mod(cint(2)));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).mod(cstr("test")));
    }

    @Test
    void testNegate() {
        Assertions.assertEquals(cint(8), cint(-8).negate());
    }

    @Test 
    void testPow() {
        Assertions.assertEquals(cint(8), cint(2).pow(cint(3)));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).pow(cstr("test")));
    }

    @Test
    void testShift() {
        Assertions.assertEquals(cint(8), cint(2).shiftLeft(cint(2)));
        Assertions.assertEquals(cint(9223372036854775807L), cint(-2).shiftRight(cint(1)));
        Assertions.assertEquals(cint(-1), cint(-2).shiftRightArithmetic(cint(1)));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRight(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRightArithmetic(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftLeft(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRight(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRightArithmetic(cstr("test")));
    }
}
