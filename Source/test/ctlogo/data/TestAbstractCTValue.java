/**
 * 
 */
package ctlogo.data;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test {@link CTValue}. 
 * 
 * @author Paul Yang
 *
 */
public class TestAbstractCTValue {
	private AbstractCTValue convertableTrue = new StubAbsCTValue(CTBoolean.TRUE, true);
	private AbstractCTValue convertableFalse = new StubAbsCTValue(CTBoolean.FALSE, true);
	private AbstractCTValue nonconvertable = new StubAbsCTValue(null, false);
	
	@Test
	void testAnd() {
		Assertions.assertSame(
				nonconvertable,
				convertableTrue.and(nonconvertable));
		System.out.println(convertableFalse.and(nonconvertable).getClass());
		Assertions.assertSame(
				convertableFalse,
				convertableFalse.and(nonconvertable));
		Assertions.assertThrows(
				RuntimeException.class, 
				() -> nonconvertable.and(convertableTrue));
	}

	@Test
	void testOr() {
		Assertions.assertSame(
				convertableTrue,
				convertableTrue.or(nonconvertable));
		Assertions.assertSame(
				nonconvertable,
				convertableFalse.or(nonconvertable));
		Assertions.assertThrows(
				RuntimeException.class, 
				() -> nonconvertable.or(convertableTrue));
	}

	@Test
	void testNot() {
		Assertions.assertSame(
				CTBoolean.FALSE,
				convertableTrue.not());
		Assertions.assertSame(
				CTBoolean.TRUE,
				convertableFalse.not());
		Assertions.assertThrows(
				RuntimeException.class, 
				() -> nonconvertable.not());
	}

	@Test
	void testObjectEquals() {
		Assertions.assertTrue(convertableFalse.equals((Object) convertableFalse));
		Assertions.assertFalse(convertableFalse.equals((Object) convertableTrue));
		Assertions.assertFalse(convertableFalse.equals((Object) "ASD"));
	}
}

class StubAbsCTValue extends AbstractCTValue {
	private static TypeMarker tm = new TypeMarker("Stub1");
	
	private CTValue convertedTo;
	private boolean isConvertable;

	public StubAbsCTValue(CTValue convertedTo, boolean isConvertable) {
		super();
		this.convertedTo = convertedTo;
		this.isConvertable = isConvertable;
	}

	@Override
	public TypeMarker getTypeMarker() {
		return tm;
	}

	@Override
	public boolean isConvertibleTo(TypeMarker newType) {
		return isConvertable;
    }

	@Override
	public CTValue convertTo(TypeMarker newType) {
        return convertedTo;
	}

	@Override
	public CTBoolean equals(CTValue another) {
		return this == another ?
				CTBoolean.TRUE : 
					CTBoolean.FALSE;
	}
	
	@Override
	public CTBoolean exactlyEquals(CTValue another) {
		return this == another ?
				CTBoolean.TRUE : 
					CTBoolean.FALSE;
	}

	@Override
	public int compareTo(CTValue another) {
		return 0;
	}

	@Override
	public boolean isCompareableTo(CTValue another) {
		return false;
	}
}
	