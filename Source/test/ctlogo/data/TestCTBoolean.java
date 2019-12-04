package ctlogo.data;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cdbl;
import static ctlogo.data.TestDataUtility.cint;
import static ctlogo.data.TestDataUtility.cstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCTBoolean {

    static class DummyValueType implements CTValue {
    	private boolean isConvertibleToString;

    	public DummyValueType(boolean isConvertibleToString) {
			super();
			this.isConvertibleToString = isConvertibleToString;
		}

		public DummyValueType() {
			this(true); 
		}

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
        	if (isConvertibleToString && newType.equals(CTString.getTypeMarkerStatic()))
        		return new CTString("Dummy");
            return null;
        }

        @Override
        public boolean isConvertibleTo(TypeMarker newType) {
        	if (isConvertibleToString && newType.equals(CTString.getTypeMarkerStatic()))
        		return true;
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
        Assertions.assertEquals(cstr("trueb"), cbol(true).add(cstr("b")));
        Assertions.assertEquals(cint(3), cbol(true).add(cint(2)));
        Assertions.assertEquals(cstr("trueDummy"), cbol(true).add(new DummyValueType()));
        Assertions.assertSame(CTUndefined.UNDEFINED, cbol(true).add(new DummyValueType(false)));
    }

    @Test
    void testSubstract() {
        Assertions.assertEquals(cint(-1), cbol(true).subtract(cint(2)));
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(cint(2), cbol(true).multiply(cint(2)));
    }

    @Test
    void testNegate() {
        Assertions.assertEquals(cint(-1), cbol(true).negate());
    }

    @Test 
    void testDivision() {
        Assertions.assertEquals(cdbl(2), cbol(true).divide(cdbl(0.5)));
    }

    @Test
    void testMod() {
        Assertions.assertEquals(cint(1), cbol(true).mod(cint(2)));
    }

    @Test
    void testPow() {
        Assertions.assertEquals(cint(1), cbol(true).pow(cint(4)));
    }
    
    @Test
    void testGetNumericalValue() {
        Assertions.assertEquals(1, cbol(true).getNumericalValue());
        Assertions.assertEquals(0, cbol(false).getNumericalValue());
    }

    @Test
    void testGetValue() {
        Assertions.assertEquals(false, cbol(false).getValue());
    }

    @Test
    void testLogicalOperators() {
        Assertions.assertEquals(cint(1), cbol(true).and(cint(1)));
        Assertions.assertEquals(cbol(false), cbol(false).and(cint(1)));
        Assertions.assertEquals(cbol(true), cbol(true).or(cint(0)));
        Assertions.assertEquals(cint(0), cbol(false).or(cint(0)));
        Assertions.assertEquals(cbol(false), cbol(true).not());
        Assertions.assertEquals(cbol(true), cbol(false).not());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("true", cbol(true).toString());
    }
}
