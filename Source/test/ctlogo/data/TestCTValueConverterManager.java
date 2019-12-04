package ctlogo.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.exception.CTOperationUndefinedException;

/**
 *
 *
 * @author Paul Yang
 */
public class TestCTValueConverterManager {
	private static final CTValueConverterManager mgr = 
			CTValueConverterManager.getInstance();
	private static final StubCTValue v1 = new StubCTValue();
	private static final StubCTValue2 v2 = new StubCTValue2();
	
	static class DummyConverter12 extends CTValueConverter {

		public DummyConverter12() {
			super(v1.getTypeMarker(), v2.getTypeMarker());
		}

		@Override
		public CTValue convert(CTValue from) {
			return v2;
		}

		@Override
		protected boolean isConvertible(CTValue from) {
			return from.getTypeMarker().equals(v1.getTypeMarker());
		}
		
	}
	
	@BeforeAll
	static void prepareAll() {
		mgr.register(new DummyConverter12());
	}

    @Test
    public void TestMultipleRegister() {
    	Assertions.assertThrows(
    			IllegalArgumentException.class, 
    			() -> mgr.register(new DummyConverter12()));
    }

    @Test
    public void TestIsConvertibleSameType() {
    	Assertions.assertTrue(mgr.isConvertible(v2, v2.getTypeMarker()));
    }

    @Test
    public void TestIsConvertibleDifferentType() {
    	Assertions.assertTrue(mgr.isConvertible(v1, v2.getTypeMarker()));
    	Assertions.assertFalse(mgr.isConvertible(v2, v1.getTypeMarker()));
    }

    @Test
    public void TestConvertSameType() {
    	Assertions.assertEquals(v1, mgr.convert(v1, v1.getTypeMarker()));
    }

    @Test
    public void TestConvertDifferentType() {
    	Assertions.assertEquals(v2, mgr.convert(v1, v2.getTypeMarker()));
    	Assertions.assertThrows(CTOperationUndefinedException.class, 
    			() -> mgr.convert(v2, v1.getTypeMarker()));
    }

}
