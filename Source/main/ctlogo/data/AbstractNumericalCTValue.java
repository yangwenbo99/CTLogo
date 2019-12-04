/**
 * 
 */
package ctlogo.data;

import ctlogo.exception.CTOperationUndefinedException;

/**
 * @author Paul Yang
 * @version 1.0
 *
 * All should be convertible to CTInteger
 *
 */
abstract public class AbstractNumericalCTValue extends AbstractCTValue {

    /**
     * Get the numerical representation of this object. 
     *
     * This should not return null.
     *
     * @return numerical representation of the object. 
     */
    abstract public Number getNumericalValue();

	/**
	 * Check whether two CTValue objects are equal. 
	 *
	 * <ul>
	 * <li>If the other operand has the type CTUndefined, the result should 
	 * be false</li>
	 * <li>If both are numerical value, their values are compared</li>
	 * <li>Otherwise, the result is false. </li>
	 * </ul>
	 *
	 * @param other
	 * @return the result. 
	 */
    @Override
    public CTBoolean equals(CTValue other) {
        if (other instanceof CTUndefined) {
            return CTBoolean.FALSE;
        } else if (other instanceof AbstractNumericalCTValue) {
            AbstractNumericalCTValue otherVal = (AbstractNumericalCTValue) other;
            return new CTBoolean(otherVal.getNumericalValue().doubleValue() == 
                this.getNumericalValue().doubleValue());
        } else {
            return CTBoolean.FALSE;
        }
    }

	/**
	 * Compares two {@link CTValue} variables.
	 * If {@code this.isCompareableTo(another)} is false, an exception 
	 * will be thrown. If they are comparable, their values are to be 
	 * compared. 
	 *
	 * @param another
	 * @return the comparison result. 
	 */
    @Override
    public int compareTo(CTValue another) {
        if (another instanceof AbstractNumericalCTValue) {
            AbstractNumericalCTValue otherVal = (AbstractNumericalCTValue) another;
            double res = 
                this.getNumericalValue().doubleValue() -
                otherVal.getNumericalValue().doubleValue();
            if (res > 0)
                return 1;
            else if (res < 0)
                return -1;
            else
                return 0;
        } else {
            throw new CTOperationUndefinedException("Not comparable");
        }
    }

	/**
	 * Check whether two variables are comparable.
	 * <p>The result should always be true for two 
	 * {@code AbstractNumericalCTValue} variables, and false otherwise.  </p>
	 *
	 * @param another
	 * @return whether the other variable is comparable with {@code this}
	 */
    @Override
    public boolean isCompareableTo(CTValue another) {
        return another instanceof AbstractNumericalCTValue;
    }

    @Override
    public CTValue mod(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).mod(another);
    }

    @Override
    public CTValue shiftLeft(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).shiftLeft(another);
    }

    @Override
    public CTValue shiftRight(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).shiftRight(another);
    }

    @Override
    public CTValue shiftRightArithmetic(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).shiftRightArithmetic(another);
    }

    @Override
    public CTValue bitwiseAnd(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).bitwiseAnd(another);
    }

    @Override
    public CTValue bitwiseOr(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).bitwiseOr(another);
    }

    @Override
    public CTValue bitwiseNot() {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).bitwiseNot();
    }


}
