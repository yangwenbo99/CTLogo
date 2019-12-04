/**
 * 
 */
package ctlogo.data;

import java.util.Objects;
import static ctlogo.data.TestDataUtility.cstr;
import static ctlogo.data.TestDataUtility.cint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ctlogo.exception.CTOperationUndefinedException;

/**
 * Test {@link CTValue}. 
 * 
 * @author Paul Yang
 *
 */
public class TestNumbericalCTValue {
	private AbstractNumericalCTValue snv1 = new StubNumericalCTValue(1);
	private AbstractNumericalCTValue snv2 = new StubNumericalCTValue(2);
	private AbstractNumericalCTValue snvm2 = new StubNumericalCTValue(-2);
	private AbstractCTValue convertableTrue = new StubAbsCTValue(CTBoolean.TRUE, true);
	private AbstractCTValue convertableFalse = new StubAbsCTValue(CTBoolean.FALSE, true);
	private AbstractCTValue nonconvertable = new StubAbsCTValue(null, false);
	
	@Test
	void testEquals() {
		Assertions.assertEquals(
				CTBoolean.FALSE,
				snv1.equals(CTUndefined.UNDEFINED));
		Assertions.assertEquals(CTBoolean.TRUE, snv1.equals(snv1));
		Assertions.assertEquals(CTBoolean.FALSE, snv1.equals(snv2));
		Assertions.assertEquals(CTBoolean.FALSE, snv1.equals(cstr("AAA")));
	}
	
	@Test
	void testIsCompareableTo() {
		Assertions.assertTrue(snv1.isCompareableTo(snv2));
		Assertions.assertFalse(snv1.isCompareableTo(cstr("A")));
	}

	@Test
	void testCompareTo() {
		Assertions.assertTrue(snv1.compareTo(snv1) == 0);
		Assertions.assertTrue(snv1.compareTo(snv2) < 0);
		Assertions.assertTrue(snv2.compareTo(snv1) > 0);
		Assertions.assertThrows(
				CTOperationUndefinedException.class,
				() -> snv1.compareTo(cstr("AAA")));
	}
	
	@Test
	void testMod() {
		Assertions.assertEquals(cint(2), snv2.mod(cint(3)));
	}

    @Test
    void testShift() {
        Assertions.assertEquals(cint(8), snv2.shiftLeft(cint(2)));
        Assertions.assertEquals(cint(9223372036854775807L), snvm2.shiftRight(cint(1)));
        Assertions.assertEquals(cint(-1), snvm2.shiftRightArithmetic(cint(1)));
    }

    @Test
    void testBitwiseOperations() {
        Assertions.assertEquals(cint(2), snv2.bitwiseAnd(cint(3)));
        Assertions.assertEquals(cint(3), snv2.bitwiseOr(cint(1)));
        Assertions.assertEquals(
				cint(Long.parseUnsignedLong("18446744073709551613")), 
				snv2.bitwiseNot());
    }

}

class StubNumericalCTValue extends AbstractNumericalCTValue {

	private static TypeMarker mk = new TypeMarker("SNV");
	private long val;

	public StubNumericalCTValue(long val) {
		this.val = val;
	}

	@Override
	public TypeMarker getTypeMarker() {
		return mk;
	}

	@Override
	public Number getNumericalValue() {
		return val;
	}

	@Override
	public boolean isConvertibleTo(TypeMarker type) {
		return type.equals(CTInteger.getTypeMarkerStatic());
	}

	@Override
	public CTValue convertTo(TypeMarker type) {
		return cint((long) val);
	}
}
