package ctlogo.data;

import static ctlogo.data.TestDataUtility.cbol;
import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCTBooleanLogical {
    static class DummyValueType implements CTValue {
    	public DummyValueType(boolean isConvertibleToString) {
			super();
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

        private static TypeMarker tm = new TypeMarker(
        		"Dummy in testing boolean's logical part");

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
    
    private static final DummyValueType dummy = new DummyValueType();

    @Test
    void testAnd() {
        Assertions.assertSame(dummy, CTBoolean.TRUE.and(dummy));
        Assertions.assertSame(CTBoolean.FALSE, CTBoolean.FALSE.and(cint(1)));
    }

    @Test
    void testOr() {
        Assertions.assertSame(CTBoolean.TRUE, CTBoolean.TRUE.or(dummy));
        Assertions.assertSame(dummy, CTBoolean.FALSE.or(dummy));
    }
    
    @Test 
    void testNot () {
        Assertions.assertSame(CTBoolean.TRUE, CTBoolean.FALSE.not());
        Assertions.assertSame(CTBoolean.FALSE, CTBoolean.TRUE.not());
    }
}
