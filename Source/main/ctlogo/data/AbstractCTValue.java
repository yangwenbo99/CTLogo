/**
 * 
 */
package ctlogo.data;

/**
 * Skeloton of CTValue.
 *
 * Note that all children of this class should be convertible to CTBoolean
 * @author yang
 *
 */
abstract public class AbstractCTValue implements CTValue {

	/**
	 * 
	 */
	public AbstractCTValue() { }

    @Override 
    public boolean equals(Object other) {
        if (other instanceof CTValue) {
            CTValue otherCtv = (CTValue) other;
            return this.exactlyEquals(otherCtv).getNumericalValue().intValue() > 0;
        } else {
            return false;
        }
    }

	@Override
	public boolean isConvertibleTo(TypeMarker newType) {
        return CTValueConverterManager.getInstance().isConvertible(
                this, newType);
    }

	@Override
	public CTValue convertTo(TypeMarker newType) {
        return CTValueConverterManager.getInstance().convert(
                this, newType);
	}

    /**
     * <p>Similar to JavaScript's and operator. </p>
     * 
     * @return If another's boolean value is true, then the result will be 
     * {@code another}, otherwise, it will be {@code this}.
     * 
     */
    @Override
    public CTValue and(CTValue another) {
        if (this.isConvertibleTo(CTBoolean.getTypeMarkerStatic())) {
        	CTBoolean converted = (CTBoolean) this.convertTo(CTBoolean.getTypeMarkerStatic());
        	if (converted.getValue())
        		return another;
        	else
        		return this;
        } else {
        	throw new RuntimeException(
        			"A subclass of AbstractCTValue does not support converting "
        			+ "to CTBoolean");
        }
    }

    /**
     * <p>Similar to JavaScript's or operator. </p>
     * 
     * @return If another's boolean value is false, then the result will be 
     * {@code another}, otherwise, it will be {@code this}.
     * 
     */
    @Override
    public CTValue or(CTValue another) {
        if (this.isConvertibleTo(CTBoolean.getTypeMarkerStatic())) {
        	CTBoolean converted = (CTBoolean) this.convertTo(CTBoolean.getTypeMarkerStatic());
        	if (converted.getValue())
        		return this;
        	else
        		return another;
        } else {
        	throw new RuntimeException(
        			"A subclass of AbstractCTValue does not support converting "
        			+ "to CTBoolean");
        }
    }

    /**
     * <p>Similar to JavaScript's not operator. </p>
     * <p> This method will convert this to boolean value, then return its negate</p>
     * 
     * @return The logic negate result. 
     * 
     */
    @Override
    public CTValue not() {
        if (!this.isConvertibleTo(CTBoolean.getTypeMarkerStatic())) {
        	throw new RuntimeException(
        			"A subclass of AbstractCTValue does not support converting "
        			+ "to CTBoolean");
        }
        return this.convertTo(CTBoolean.getTypeMarkerStatic()).not();
    }
}
