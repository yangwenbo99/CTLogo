package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class CTString extends AbstractCTValue {
    private final static TypeMarker typeMarker = new TypeMarker("double");

    private String value;

    public CTString(String string) {
        this.value = string;
    }

    public static TypeMarker getTypeMarkerStatic() {
        return typeMarker;
    }

    public TypeMarker getTypeMarker() {
        return typeMarker;
    }

    private String getValue() {
        return value;
    }

    @Override
    public CTBoolean equals(CTValue another) {
        if (another instanceof CTString)
            return new CTBoolean(this.toString().equals(another.toString()));

        if (this.isConvertibleTo(another.getTypeMarker())) {
            return this.convertTo(another.getTypeMarker()).equals(another);
        } else {
            return new CTBoolean(this.toString().equals(another.toString()));
        }
    }

    private CTValue convertToNum() {
        if (this.isConvertibleTo(CTInteger.getTypeMarkerStatic()))
            return this.convertTo(CTInteger.getTypeMarkerStatic());
        else if (this.isConvertibleTo(CTDouble.getTypeMarkerStatic()))
            return this.convertTo(CTDouble.getTypeMarkerStatic());
        else
            return CTDouble.NaN;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public CTValue add(CTValue another) {
        return new CTString(toString() + another.toString());
    }

    @Override
    public CTValue subtract(CTValue another) {
        return this.convertToNum().subtract(another);
    }

    @Override
    public CTValue negate() {
        return this.convertToNum().negate();
    }

    @Override
    public CTValue multiply(CTValue another) {
        return this.convertToNum().multiply(another);
    }

    @Override
    public CTValue divide(CTValue another) {
        return this.convertToNum().divide(another);
    }

    @Override
    public CTValue mod(CTValue another) {
        return new CTUndefined();
    }

    @Override
    public CTValue pow(CTValue another) {
        return this.convertToNum().pow(another);
    }

    @Override
    public CTValue shiftLeft(CTValue another) {
        return this.convertToNum().shiftLeft(another);
    }

    @Override
    public CTValue shiftRight(CTValue another) {
        return this.convertToNum().shiftRight(another);
    }

    @Override
    public CTValue shiftRightArithmetic(CTValue another) {
        return this.convertToNum().shiftRightArithmetic(another);
    }

    @Override
    public CTValue and(CTValue another) {
        return this.convertTo(CTBoolean.getTypeMarkerStatic()).and(another);
    }

    @Override
    public CTValue or(CTValue another) {
        return this.convertTo(CTBoolean.getTypeMarkerStatic()).or(another);
    }

    @Override
    public CTValue not() {
        return this.convertTo(CTBoolean.getTypeMarkerStatic()).not();
    }

    @Override
    public CTInteger compareTo(CTValue another) {
        if (another instanceof CTString)
            return new CTInteger(this.toString().compareTo(another.toString()));

        if (this.isConvertibleTo(another.getTypeMarker())) {
            return this.convertTo(another.getTypeMarker()).compareTo(another);
        } else {
            return new CTInteger(this.toString().compareTo(another.toString()));
        }
    }

    @Override
    public boolean isCompareableTo(CTValue another) {
        return true;
    }


}
