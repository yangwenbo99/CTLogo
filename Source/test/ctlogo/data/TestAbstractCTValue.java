/**
 * 
 */
package ctlogo.data;

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
	