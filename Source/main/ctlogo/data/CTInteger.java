package ctlogo.data;

public class CTInteger extends AbstractNumericalCTValue {
    private final static TypeMarker typeMarker = new TypeMarker("integer");

    private Long value;
    
    public final static CTInteger ZERO = new CTInteger(0);
    public final static CTInteger ONE = new CTInteger(1);

    public CTInteger(long i) {
        value = i;
    }

    public CTInteger(Long i) {
        value = i;
    }

    public static TypeMarker getTypeMarkerStatic() {
        return typeMarker;
    }

    public TypeMarker getTypeMarker() {
        return typeMarker;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

    @Override
    public CTValue add(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).add(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value + otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue subtract(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).subtract(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value - otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue negate() {
        return new CTInteger(-value);
    }

    @Override
    public CTValue multiply(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).multiply(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value * otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue divide(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).divide(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value / otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue mod(CTValue another) {
        if (another instanceof CTDouble) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).mod(another);
        } else if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherValue = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value % otherValue.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue pow(CTValue another) {
        if (another instanceof CTInteger) {
            CTInteger otherInt = (CTInteger) another;
            return new CTInteger((long) Math.pow(this.value, otherInt.value));
        } else if (another.isConvertibleTo(CTDouble.getTypeMarkerStatic())) {
            return this.convertTo(CTDouble.getTypeMarkerStatic()).pow(another);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue shiftLeft(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherVal = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value << otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue shiftRight(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherVal = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value >>> otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
    public CTValue shiftRightArithmetic(CTValue another) {
        if (another.isConvertibleTo(this.getTypeMarker())) {
            CTInteger otherVal = (CTInteger) another.convertTo(this.getTypeMarker());
            return new CTInteger(this.value >> otherVal.value);
        } else {
            return CTUndefined.UNDEFINED;
        }
    }

    @Override
	public Number getNumericalValue() {
        return this.value;
    }
}
