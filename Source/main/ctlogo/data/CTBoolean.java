package ctlogo.data;

public class CTBoolean extends AbstractNumericalCTValue {
    public final static CTBoolean TRUE = new CTBoolean(true);
    public final static CTBoolean FALSE = new CTBoolean(false);

    private final static TypeMarker typeMarker = new TypeMarker("boolean");

    private Boolean value;

    public CTBoolean(Boolean value) {
        this.value = value;
    }

    CTBoolean (AbstractNumericalCTValue v) {
        this(v.getNumericalValue().longValue() == 1);
    }

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

    @Override
    public CTValue subtract(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).subtract(another);
    }

    @Override
    public CTValue negate() {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).negate();
    }

    @Override
    public CTValue multiply(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).multiply(another);
    }

    @Override
    public CTValue divide(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).divide(another);
    }

    @Override
    public CTValue mod(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).mod(another);
    }

    @Override
    public CTValue pow(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).pow(another);
    }

    @Override
	public Number getNumericalValue() {
        return value ? 1 : 0;
    }

    @Override 
    public CTValue and(CTValue other) {
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
