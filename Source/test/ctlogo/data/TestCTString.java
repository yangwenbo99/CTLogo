package ctlogo.data;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCTString {

    static class DummyValueType implements CTValue {
        @Override
        public CTBoolean equals(CTValue another) {
            return null;
        }

        @Override
        public int compareTo(CTValue another) {
            return 0;
        }

        @Override
        public boolean isCompareableTo(CTValue another) {
            return false;
        }

        private static TypeMarker tm = new TypeMarker("Dummy in testing string");

        @Override
        public TypeMarker getTypeMarker() {
            return tm;
        }

        @Override
        public CTValue convertTo(TypeMarker newType) {
            return null;
        }

        @Override
        public boolean isConvertibleTo(TypeMarker newType) {
            return false;
        }

        @Override
        public CTValue and(CTValue another) {
            return null;
        }

        @Override
        public CTValue or(CTValue another) {
            return null;
        }

        @Override
        public CTValue not() {
            return null;
        }

        @Override 
        public String toString() {
            return "Dummy";
        }
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(cstr("ab"), cstr("a").add(cstr("b")));
        Assertions.assertEquals(cstr("a1"), cstr("a").add(cstr("1")));

    }

    @Test
    void testSubstract() {
        // Assertions.assertEquals(cint(3), cstr("1").add(cint(2)));
        Assertions.assertEquals(cint(-1), cstr("1").subtract(cint(2)));
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(cint(6), cstr("3").multiply(cint(2)));
        Assertions.assertTrue(() ->
                Double.isNaN(((CTDouble) cstr("IK").multiply(cint(2))).getNumericalValue().doubleValue()));
    }

    @Test
    void testNegate() {
        Assertions.assertEquals(cint(6), cstr("-6").negate());
    }

    @Test 
    void testDivision() {
        // int division
        Assertions.assertEquals(cint(6), cstr("19").divide(cint(3)));
        Assertions.assertEquals(cint(1), cstr("3").divide(cint(2)));
        // float division
        Assertions.assertEquals(cdbl(1.5), cstr("3.0").divide(cint(2)));
        Assertions.assertEquals(cdbl(1.5), cstr("3").divide(cdbl(2)));
        Assertions.assertEquals(cdbl(1.5), cstr("3").divide(cdbl(2)));
        Assertions.assertEquals(cdbl(1.5), cstr("3").divide(cdbl(2)));
        Assertions.assertEquals(cdbl(0.9), cstr("1.8").divide(cdbl(2)));
        Assertions.assertEquals(cdbl(1.75), cstr("3.5").divide(cdbl(2)));
    }

    @Test
    void testMod() {
        Assertions.assertEquals(cint(1), cstr("3").mod(cint(2)));
    }

    @Test
    void testPow() {
        Assertions.assertEquals(cint(16), cstr("2").pow(cint(4)));
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(cbol(true), cstr("abc").equals(cstr("abc")));
        Assertions.assertEquals(cbol(true), cstr("3").equals(cint(3)));
        Assertions.assertEquals(cbol(true), cstr("Dummy").equals(new DummyValueType()));
        Assertions.assertEquals(cbol(false), cstr("dummy").equals(new DummyValueType()));

    }

    @Test
    void testCompareTo() {
        Assertions.assertEquals(0, cstr("1").compareTo(cint(1)));
        Assertions.assertEquals(0, cstr("1").compareTo(cstr("1")));
        Assertions.assertTrue(() ->
                1 > 0);
        Assertions.assertTrue(() ->
                cstr("dummy").compareTo(new DummyValueType()) > 0);

    }

    @Test
    void testLogicalOperators() {
        Assertions.assertEquals(cint(1), cstr("True").and(cint(1)));
        Assertions.assertEquals(cint(0), cstr("FALSE").or(cint(0)));
        Assertions.assertEquals(cbol(false), cstr("TRUE").not());

    }

    @Test
    void testOtherOperators() {
        Assertions.assertEquals(cint(16), cstr("1").shiftLeft(cint(4)));
        Assertions.assertEquals(cint(1), cstr("3").shiftRight(cint(1)));
        Assertions.assertEquals(cint(1), cstr("3").shiftRightArithmetic(cint(1)));
        Assertions.assertEquals(cint(1), cstr("3").shiftRightArithmetic(cint(1)));
    }

    @Test
    void testMisc() {
        Assertions.assertEquals(true, cstr("12").isCompareableTo(new DummyValueType()));
    }
}
