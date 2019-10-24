package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;
import ctlogo.exception.CTOperationUndefinedException;

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

    private Boolean isValue() {
        return value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public CTValue add(CTValue another) {
        return this.convertTo(CTInteger.getTypeMarkerStatic()).add(another);
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
    Number getNumericalValue() {
        return value ? 1 : 0;
    }
}
