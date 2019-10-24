package ctlogo.data;

import java.math.BigDecimal;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class CTDouble extends AbstractNumericalCTValue {
    private final static TypeMarker typeMarker = new TypeMarker("double");
    public final static CTDouble ZERO = new CTDouble(0.);
    public final static CTDouble NaN = new CTDouble(Double.NaN);

    private Double value;

    public CTDouble(Double d) {
        this.value = d;
    }
    public static TypeMarker getTypeMarkerStatic() {
        return typeMarker;
    }

    public TypeMarker getTypeMarker() {
        return typeMarker;
    }

    private Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public CTValue add(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTDouble otherVal = (CTDouble) another.convertTo(this.getTypeMarker());
            return new CTDouble(this.value + otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue subtract(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTDouble otherVal = (CTDouble) another.convertTo(this.getTypeMarker());
            return new CTDouble(this.value - otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue negate() {
        return new CTDouble(-value);
    }

    @Override
    public CTValue multiply(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTDouble otherVal = (CTDouble) another.convertTo(this.getTypeMarker());
            return new CTDouble(this.value * otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue divide(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            try {
                CTDouble otherVal = (CTDouble) another.convertTo(this.getTypeMarker());
                return new CTDouble(this.value / otherVal.value);
            } catch (NumberFormatException e) {
                return NaN;
            }
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue mod(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTDouble otherVal = (CTDouble) another.convertTo(this.getTypeMarker());
            BigDecimal thisD = new BigDecimal(this.value);
            BigDecimal otherD = new BigDecimal(otherVal.value);
            if (otherD.equals(BigDecimal.ZERO))
                return new CTDouble(Double.NaN);
            return new CTDouble(thisD.remainder(otherD).doubleValue());
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue pow(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTDouble otherVal = (CTDouble) another.convertTo(this.getTypeMarker());
            return new CTDouble(Math.pow(this.value, otherVal.value));
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    Number getNumericalValue() {
        return this.value;
    }
}
