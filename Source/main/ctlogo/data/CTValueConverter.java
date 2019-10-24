/**
 * 
 */
package ctlogo.data;

/**
 * @author Paul Yang
 *
 */
abstract class CTValueConverter {
	
	private TypeConversionDirection tcd;
	
	public CTValueConverter(TypeConversionDirection tcd) {
		this.tcd = tcd;
	}
	
	public CTValueConverter(TypeMarker from, TypeMarker to) {
		this.tcd = new TypeConversionDirection(from, to);
	}

	protected TypeConversionDirection getTcd() {
		return tcd;
	}
	
	abstract public CTValue convert(CTValue from);

    abstract boolean isConvertible(CTValue from);
	
}
