/**
 * 
 */
package ctlogo.data;

/**
 * @author Paul Yang
 * CTValue's type converter 
 */
public abstract class CTValueConverter {
	
	private TypeConversionDirection tcd;
	
	/**
	 * @param tcd: the direction of this conversion
	 */
	public CTValueConverter(TypeConversionDirection tcd) {
		this.tcd = tcd;
	}
	
	/**
	 * @param from source type
	 * @param to destination type
	 */
	public CTValueConverter(TypeMarker from, TypeMarker to) {
		this.tcd = new TypeConversionDirection(from, to);
	}

	/**
	 * @return the direction of the conversion.
	 */
	protected TypeConversionDirection getDirection() {
		return tcd;
	}
	
	/**
	 * Perform the conversion.
	 * @param from
	 * @return
	 */
	abstract public CTValue convert(CTValue from);

    abstract protected boolean isConvertible(CTValue from);
	
}
