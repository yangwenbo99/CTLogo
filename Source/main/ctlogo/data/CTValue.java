package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public interface CTValue {
	/**
	 * Analogue to JS's '==' operator
	 * @param another
	 * @return
	 */
	public CTBoolean equals(CTValue another);

	/**
	 * Similar to JS's '=' operator.
	 * 
	 * This method should behave the same as {Code: equals(Object)}
	 * @param other
	 * @return
	 */
	default public CTBoolean exactlyEquals(CTValue other) {
		if (!this.getClass().equals(other.getClass()))
			return CTBoolean.FALSE;
		return this.equals(other);
	}
	
	public TypeMarker getTypeMarker();

	public CTInteger compareTo(CTValue another);
	public boolean isCompareableTo(CTValue another);
	public String toString();
	public String getTypeName();
	public CTValue convertTo(String newType);
	public boolean isConvertibleTo(String newType);
	
	public CTValue add(CTValue another);
	public CTValue subtract(CTValue another);
	public CTValue negate();
	public CTValue multiply(CTValue another);
	public CTValue divide(CTValue another);
	public CTValue mod(CTValue another);
	public CTValue pow(CTValue another);
	
	public CTValue shiftLeft(CTValue another);
	public CTValue shiftRight(CTValue another);
	public CTValue shiftRightArithmetic(CTValue another);

	public CTValue and(CTValue another);
	public CTValue or(CTValue another);
	public CTValue not();
}
