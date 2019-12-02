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
        return this.convertTo(CTInteger.getTypeMarkerStatic()).and(another);
    }

    @Override
    public CTValue bitwiseOr(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).or(another);
    }

    @Override
    public CTValue bitwiseNot() {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).not();
    }


}
