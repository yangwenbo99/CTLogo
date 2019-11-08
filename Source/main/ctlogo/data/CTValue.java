package ctlogo.data;

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
	

	public CTInteger compareTo(CTValue another);
	public boolean isCompareableTo(CTValue another);
	public String toString();
	public TypeMarker getTypeMarker();
	public CTValue convertTo(TypeMarker newType);
	public boolean isConvertibleTo(TypeMarker newType);
	
	public default CTValue add(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue subtract(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue negate() {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue multiply(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue divide(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue mod(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue pow(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	
	public default CTValue shiftLeft(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue shiftRight(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
	public default CTValue shiftRightArithmetic(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
    public default CTValue bitwiseAnd(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
    public default CTValue bitwiseOr(CTValue another) {
        return CTUndefined.UNDEFINED;
    }
    public default CTValue bitwiseNot() {
        return CTUndefined.UNDEFINED;
    }

	public CTValue and(CTValue another);
	public CTValue or(CTValue another);
	public CTValue not();
}
