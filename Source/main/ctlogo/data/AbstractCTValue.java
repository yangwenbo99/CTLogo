/**
 * 
 */
package ctlogo.data;

import javax.naming.OperationNotSupportedException;

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
