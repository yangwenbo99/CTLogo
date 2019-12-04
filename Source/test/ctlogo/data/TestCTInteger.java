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
public class TestCTInteger {
    @Test
    void testConstruct() {
        Assertions.assertEquals(cint(100), new CTInteger(Long.valueOf(100)));
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(cdbl(3), cint(1).add(cdbl(2.)));
    }

    @Test
    void testSubstract() {
        Assertions.assertEquals(cdbl(-1), cint(1).subtract(cdbl(2.)));
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(cdbl(6), cint(3).multiply(cdbl(2.)));
    }

    @Test
    void testDivide() {
        Assertions.assertEquals(cdbl(1.5), cint(3).divide(cdbl(2.)));
    }

    @Test
    void testMod() {
        Assertions.assertEquals(cdbl(1), cint(3).mod(cdbl(2.)));
    }

    @Test 
    void testPow() {
        Assertions.assertEquals(cdbl(8), cint(2).pow(cdbl(3)));
    }

    @Test
    void testShift() {
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftLeft(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRight(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRightArithmetic(cstr("test")));
    }

    @Test
    void testToString() {
        Assertions.assertEquals("100", cint(100).toString());
    }
}
