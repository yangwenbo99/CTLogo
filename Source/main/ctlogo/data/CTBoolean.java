package ctlogo.data;

public class CTBoolean extends AbstractNumericalCTValue {
    public final static CTBoolean TRUE = new CTBoolean(true);
    public final static CTBoolean FALSE = new CTBoolean(false);

    private final static TypeMarker typeMarker = new TypeMarker("boolean");

    private Boolean value;

    public CTBoolean(Boolean value) {
        this.value = value;
    }

    /*
    CTBoolean (AbstractNumericalCTValue v) {
        this(v.getNumericalValue().longValue() == 1);
    }
    */

    public static TypeMarker getTypeMarkerStatic() {
        return typeMarker;
    }

    public TypeMarker getTypeMarker() {
        return typeMarker;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    /**
     * <p>Performs CTLogo add operation on this object. 
     * Similar to JS's add operation.
     * The comparison is done with the following manner: </p>
     * 
     * <ol>
     * <li>If {@code another} is {@code CTString}, then they are 
     * concatenated.</li>
     * <li>If {@code another} is numberical value, then the result is 
     * the integer sum of 1 or 0 (depends on the value of {@code this}
     * </li>
     * <li>If {@code another} is convertible to {@code CTString}, ]
     * then they are concatenated.</li>
     * <li>Otherwise, an {@link CTUndefined} object is returned</li>
     * </ol>
     */
    @Override
    public CTValue add(CTValue another) {
    	if (another instanceof CTString)
    		return this.convertTo(CTString.getTypeMarkerStatic()).add(another);
    	if (another instanceof AbstractNumericalCTValue) 
			return this.convertTo(CTInteger.getTypeMarkerStatic()).add(another);
    	if (another.isConvertibleTo(CTString.getTypeMarkerStatic()))
    		return this.convertTo(CTString.getTypeMarkerStatic()).add(another);
    	return CTUndefined.UNDEFINED;
    }

    /**
     * Convert this two integer variable, then subtract
     */
    @Override
    public CTValue subtract(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).subtract(another);
    }

    /**
     * Convert this two integer variable, then negate
     */
    @Override
    public CTValue negate() {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).negate();
    }

    /**
     * Convert this two integer variable, then multiply
     */
    @Override
    public CTValue multiply(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).multiply(another);
    }

    /**
     * Convert this two integer variable, then divide.
     */
    @Override
    public CTValue divide(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).divide(another);
    }

    /**
     * Convert this two integer variable, then calculate modulus.
     */
    @Override
    public CTValue mod(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).mod(another);
    }

    /**
     * Convert this two integer variable, then calculate power.
     */
    @Override
    public CTValue pow(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).pow(another);
    }

    @Override
	public Number getNumericalValue() {
        return value ? 1 : 0;
    }
    
    /**
     * Get the boolean value of this object.
     * 
     * @return the value of this object. 
     */
    public boolean getValue() {
    	return value;
    }

    @Override 
    public CTValue and(CTValue other) {
        System.out.println(other);
        if (this.value)
            return other;
        else
            return this;
    }

    @Override 
    public CTValue or(CTValue other) {
        if (this.value)
            return this;
        else
            return other;
    }

    @Override 
    public CTValue not() {
        if (this.value)
            return FALSE;
        else
            return TRUE;
    }
}
