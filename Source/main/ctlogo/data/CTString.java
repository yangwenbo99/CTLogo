package ctlogo.data;

import ctlogo.execute.util.DoubleParser;
import ctlogo.execute.util.LongParser;

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
        if (LongParser.isParseable(this.value)) {
            return new CTInteger(LongParser.parseLong(this.value));
        } else if (DoubleParser.isParseable(this.value)) {
            return new CTDouble(DoubleParser.ParseDouble(this.value));
        } else {
            return CTDouble.NaN;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Concatenate this string with the string representation of the 
     * parameter. 
     */
    @Override
    public CTValue add(CTValue another) {
        return new CTString(toString() + another.toString());
    }

    /**
     * Convert this two numerical variable, then subtract the parameter.
     */
    @Override
    public CTValue subtract(CTValue another) {
        return this.convertToNum().subtract(another);
    }

    /**
     * Convert this two numerical variable, then negate the parameter.
     */
    @Override
    public CTValue negate() {
        return this.convertToNum().negate();
    }

    /**
     * Convert this two numerical variable, then multiply the parameter.
     */
    @Override
    public CTValue multiply(CTValue another) {
        return this.convertToNum().multiply(another);
    }

    /**
     * Convert this two numerical variable, then divide the parameter.
     */
    @Override
    public CTValue divide(CTValue another) {
        return this.convertToNum().divide(another);
    }

    /**
     * Convert this two numerical variable, then mod the parameter.
     */
    @Override
    public CTValue mod(CTValue another) {
        return this.convertToNum().mod(another);
    }

    /**
     * Convert this two numerical variable, then take power in the degree
     * as the parameter.
     */
    @Override
    public CTValue pow(CTValue another) {
        return this.convertToNum().pow(another);
    }

    /**
     * Convert this two numerical variable, then shift left.
     */
    @Override
    public CTValue shiftLeft(CTValue another) {
        return this.convertToNum().shiftLeft(another);
    }

    /**
     * Convert this two numerical variable, then shift right.
     */
    @Override
    public CTValue shiftRight(CTValue another) {
        return this.convertToNum().shiftRight(another);
    }

    /**
     * Convert this two numerical variable, then shift right arithmetically.
     */
    @Override
    public CTValue shiftRightArithmetic(CTValue another) {
        return this.convertToNum().shiftRightArithmetic(another);
    }

    /*
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
    */

    /**
     * <p>Compare this object with another CTValue object. </p>
     * 
     * <p>The comparison is done with the following manner: </p>
     * 
     * <ol>
     * <li>If {@code another} is {@code CTString}, then they are compared using 
     *     {@link String#compareTo(String)}.</li>
     * <li>If {@code another} is not {@code CTString}, but this object's
     *     content is convertible to {@code another}, then {@code this} 
     *     is converted to the type of {@code another}, then compared using 
     *     {@code another}'s comparison method. </li>
     * <li>Otherwise, {@code another} is converted {@code CTString}, and then 
     *     compared with {@code this}.</li>
     * </ol>
     */
    @Override
    public int compareTo(CTValue another) {
        if (another instanceof CTString)
            return this.toString().compareTo(another.toString());

        if (this.isConvertibleTo(another.getTypeMarker())) {
            return this.convertTo(another.getTypeMarker()).compareTo(another);
        } else {
            return this.toString().compareTo(another.toString());
        }
    }

    @Override
    public boolean isCompareableTo(CTValue another) {
        return true;
    }


}
