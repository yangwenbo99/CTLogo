/**
 * 
 */
package ctlogo.data;

/**
 * @author yang
 *
 * All should be convertible to CTBoolean
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

    @Override
    public CTValue and(CTValue another) {
        if (this.isConvertibleTo(CTBoolean.getTypeMarkerStatic())) {
            return this.convertTo(CTBoolean.getTypeMarkerStatic()).and(another);
        }
        return this;
    }

    @Override
    public CTValue or(CTValue another) {
        if (this.isConvertibleTo(CTBoolean.getTypeMarkerStatic())) {
            return this.convertTo(CTBoolean.getTypeMarkerStatic()).and(another);
        }
        return another;
    }

    @Override
    public CTValue not() {
        return this.convertTo(CTBoolean.getTypeMarkerStatic()).not();
    }
}
