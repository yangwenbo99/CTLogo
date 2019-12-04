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
public class TestCTValue {
	private StubCTValue v1 = new StubCTValue();
	private StubCTValue v2 = new StubCTValue();
	
	@Test
	void testAdd() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.add(v2));
	}

	@Test
	void testSubstract() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.subtract(v2));
	}

	@Test
	void testNegate() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.negate());
	}

	@Test
	void testMultiply() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.multiply(v2));
	}

	@Test
	void testDivide() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.divide(v2));
	}

	@Test
	void testMod() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.mod(v2));
	}

	@Test
	void testPow() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.pow(v2));
	}

	@Test
	void testShiftLeft() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.shiftLeft(v2));
	}

	@Test
	void testShiftRight() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.shiftRight(v2));
	}

	@Test
	void testShiftRightArithmetic() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.shiftRightArithmetic(v2));
	}

	@Test
	void testBitwiseAnd() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.bitwiseAnd(v2));
	}

	@Test
	void testBitwiseOr() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.bitwiseOr(v2));
	}

	@Test
	void testBitwiseNot() {
		Assertions.assertSame(CTUndefined.UNDEFINED, v1.bitwiseNot());
	}

	@Test
	void testExactlyEquals() {
		Assertions.assertSame(CTBoolean.FALSE, v1.exactlyEquals(new StubCTValue2()));
		Assertions.assertNull(v1.exactlyEquals(v2));
	}
}

class StubCTValue implements CTValue {
	private static TypeMarker tm = new TypeMarker("Stub1");

	@Override
	public CTBoolean equals(CTValue another) {
		return null;
	}
	
	@Override 
	public boolean equals(Object other) {
		return other.getClass().equals(this.getClass());
	}

	@Override
	public int compareTo(CTValue another) {
		return 0;
	}

	@Override
	public boolean isCompareableTo(CTValue another) {
		return false;
	}

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

}

class StubCTValue2 implements CTValue {
	private static TypeMarker tm = new TypeMarker("Stub2");

	@Override
	public CTBoolean equals(CTValue another) {
		return null;
	}
	
	@Override 
	public boolean equals(Object other) {
		return other.getClass().equals(this.getClass());
	}

	@Override
	public int compareTo(CTValue another) {
		return 0;
	}

	@Override
	public boolean isCompareableTo(CTValue another) {
		return false;
	}

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

}
	