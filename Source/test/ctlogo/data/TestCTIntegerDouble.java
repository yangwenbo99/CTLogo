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
public class TestCTIntegerDouble {
    @Test
    void testConstruct() {
        Assertions.assertEquals(cint(100), new CTInteger(Long.valueOf(100)));
    }

    @Test
    void testAddInt() {
        Assertions.assertEquals(cdbl(3), cint(1).add(cdbl(2.)));
    }

    @Test
    void testAddDbl() {
        Assertions.assertSame(
                CTUndefined.UNDEFINED, 
                cdbl(1).add(cstr("ASDF")));
    }

    @Test
    void testSubstractInt() {
        Assertions.assertEquals(cdbl(-1), cint(1).subtract(cdbl(2.)));
    }

    @Test
    void testSubstractDbl() {
        Assertions.assertSame(
                CTUndefined.UNDEFINED, 
                cdbl(1).subtract(cstr("ASDF")));
    }

    @Test
    void testNegateDbl() {
        Assertions.assertEquals(cdbl(1), cdbl(-1).negate());
    }

    @Test
    void testMultiplyInt() {
        Assertions.assertEquals(cdbl(6), cint(3).multiply(cdbl(2.)));
    }

    @Test
    void testMultipleDbl() {
        Assertions.assertSame(
                CTUndefined.UNDEFINED, 
                cdbl(1).multiply(cstr("ASDF")));
    }

    @Test
    void testDivideInt() {
        Assertions.assertEquals(cdbl(1.5), cint(3).divide(cdbl(2.)));
    }

    @Test
    void testDivideDbl() {
        Assertions.assertSame(
                CTUndefined.UNDEFINED, 
                cdbl(1).divide(cstr("ASDF")));
        Assertions.assertTrue(
                Double.isNaN(
                    ((CTDouble) cdbl(1).divide(cstr("NaN")))
                    .getNumericalValue().doubleValue()));
    }

    @Test
    void testModInt() {
        Assertions.assertEquals(cdbl(1), cint(3).mod(cdbl(2.)));
    }

    @Test
    void testModDbl() {
        Assertions.assertSame(
                CTUndefined.UNDEFINED, 
                cdbl(1).mod(cstr("ASDF")));
        Assertions.assertTrue(
                Double.isNaN(
                    ((CTDouble) cdbl(1).mod(cdbl(0)))
                    .getNumericalValue().doubleValue()));
    }

    @Test 
    void testPowInt() {
        Assertions.assertEquals(cdbl(8), cint(2).pow(cdbl(3)));
    }

    @Test
    void testPowDbl() {
        Assertions.assertSame(
                CTUndefined.UNDEFINED, 
                cdbl(1).pow(cstr("ASDF")));
    }

    @Test
    void testShiftInt() {
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftLeft(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRight(cstr("test")));
        Assertions.assertSame(CTUndefined.UNDEFINED, cint(2).shiftRightArithmetic(cstr("test")));
    }

    @Test
    void testToStringInt() {
        Assertions.assertEquals("100", cint(100).toString());
    }

    @Test
    void testToString() {
        Assertions.assertEquals(
                "1.5", 
                cdbl(1.5).toString());
    }
}
