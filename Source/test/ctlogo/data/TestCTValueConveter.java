package ctlogo.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.data.TypeConversionDirection;
import ctlogo.data.TypeMarker;

/**
 *
 *
 * @author Paul Yang
 *
 * Also testing TypeConversionDirection
 */
public class TestCTValueConveter {
    static class stubConverter1 extends CTValueConverter {

        public stubConverter1(TypeConversionDirection tcd) {
            super(tcd);
        }

        public stubConverter1(TypeMarker tm1, TypeMarker tm2) {
            super(tm1, tm2);
        }

        @Override
        public CTValue convert(CTValue from) {
            // TODO Auto-generated method stub
            return null;
        }

		@Override
		public boolean isConvertible(CTValue from) {
			return false;
		}

		public TypeConversionDirection getDirection() {
			return super.getDirection();
		}
    }

    TypeMarker tm1 = new TypeMarker("type marker 1");
    TypeMarker tm2 = new TypeMarker("type marker 2");
    TypeMarker tm3 = new TypeMarker("type marker 3");
    TypeConversionDirection dir1 = new TypeConversionDirection(tm1, tm2);
    TypeConversionDirection dir2 = new TypeConversionDirection(tm1, tm3);
    TypeConversionDirection dir3 = new TypeConversionDirection(tm2, tm3);
    TypeConversionDirection dir4 = new TypeConversionDirection(tm1, tm2);

    @Test
    public void TestConstructor() {
        stubConverter1 c1 = new stubConverter1(tm1, tm2);
        stubConverter1 c2 = new stubConverter1(dir1);
        Assertions.assertEquals(c1.getDirection(), c2.getDirection());
    }

    @Test 
    public void testDirEquals() {
        Assertions.assertNotEquals(dir2, dir1);
        Assertions.assertNotEquals(dir3, dir1);
        Assertions.assertNotEquals("stub", dir1);
    }

    @Test
    public void testHash() {
        Assertions.assertEquals(dir1.hashCode(), dir1.hashCode());
        Assertions.assertEquals(dir1.hashCode(), dir4.hashCode());
    }

    @Test 
    public void testDirToString() {
        String s = dir1.toString();
        Assertions.assertTrue(() -> s.contains("<"));
        Assertions.assertTrue(() -> s.contains("ctlogo.data.TypeConversionDirection"));
        Assertions.assertTrue(() -> s.contains("type marker 1"));
        Assertions.assertTrue(() -> s.contains("type marker 2"));
        Assertions.assertTrue(() -> s.contains(">"));
    }

    @Test
    public void testGetFromTo() {
        Assertions.assertEquals(tm1, dir1.getFrom());
        Assertions.assertEquals(tm2, dir1.getTo());
    }

}
