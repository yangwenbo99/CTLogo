package ctlogo.data;

public class CTInteger extends AbstractNumericalCTValue {
    private final static TypeMarker typeMarker = new TypeMarker("integer");

    private Long value;
    
    public final static CTInteger ZERO = new CTInteger(0);
    public final static CTInteger ONE = new CTInteger(1);

    public CTInteger(long i) {
        value = i;
    }

    public CTInteger(Long i) {
        value = i;
    }

    public static TypeMarker getTypeMarkerStatic() {
        return typeMarker;
    }

    public TypeMarker getTypeMarker() {
        return typeMarker;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

	/**
	 * Calculate the sum.
	 * If {@code another} is double, {@code this} will be converted to double,
	 * then calculate the sum. 
	 * Otherwise, the method will first convert {@code another} to CTInteger,
	 * then calculate the result. If there is no such conversion, the result 
	 * shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue add(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).add(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value + otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the difference.
	 * If {@code another} is double, {@code this} will be converted to double,
	 * then calculate the result. 
	 * Otherwise, the method will first convert {@code another} to CTInteger,
	 * then calculate the result. If there is no such conversion, the result 
	 * shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue subtract(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).subtract(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value - otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the negation.
	 *
	 * @return The result.
	 */
    @Override
    public CTValue negate() {
        return new CTInteger(-value);
    }

	/**
	 * Calculate the product.
	 * If {@code another} is double, {@code this} will be converted to double,
	 * then calculate the result. 
	 * Otherwise, the method will first convert {@code another} to CTInteger,
	 * then calculate the result. If there is no such conversion, the result 
	 * shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue multiply(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).multiply(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value * otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the quotient.
	 * If {@code another} is double, {@code this} will be converted to double,
	 * then calculate the result. 
	 * Otherwise, the method will first convert {@code another} to {@code CTInteger},
	 * then calculate the result. If there is no such conversion, the result 
	 * shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue divide(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).divide(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value / otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the remainder.
	 * If {@code another} is double, {@code this} will be converted to double,
	 * then calculate the result. 
	 * Otherwise, the method will first convert {@code another} to {@code CTInteger},
	 * then calculate the result. If there is no such conversion, the result 
	 * shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue mod(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).mod(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value % otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the power.
	 * If {@code another} is {@code CTInteger}, the integral power will be 
	 * calculated. 
	 * Otherwise, the method will first convert {@code another} to 
	 * {@code CTDouble}, then calculate the result. If there is no 
	 * such conversion, the result shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue pow(CTValue another) {
        if (another instanceof CTInteger) {
            CTInteger otherInt = (CTInteger) another;
            return new CTInteger((long) Math.pow(this.value, otherInt.value));
        } else if (another.isConvertibleTo(CTDouble.getTypeMarkerStatic())) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).pow(another);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the result of left shifting.
	 * If {@code another} is {@code CTInteger}, the result will be directly
	 * calculated. 
	 * Otherwise, the result shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue shiftLeft(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherVal = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value << otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the result of (logical) right shifting.
	 * If {@code another} is {@code CTInteger}, the result will be directly
	 * calculated. 
	 * Otherwise, the result shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue shiftRight(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherVal = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value >>> otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

	/**
	 * Calculate the result of arithmetic right shifting.
	 * If {@code another} is {@code CTInteger}, the result will be directly
	 * calculated. 
	 * Otherwise, the result shall be {@code: CTUndefined}.
	 *
	 * @param another another operand. 
	 * @return The result.
	 */
    @Override
    public CTValue shiftRightArithmetic(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherVal = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value >> otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
	public Number getNumericalValue() {
        return this.value;
    }
}
