package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class CTBoolean implements CTValue {
    public final static CTBoolean TRUE = new CTBoolean(true);
    public final static CTBoolean FALSE = new CTBoolean(false);

	private Boolean value;

	public CTBoolean(Boolean value) {
		this.value = value;
	}

	private Boolean isValue() {
		return value;
	}

	private void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public CTBoolean equals(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if (another.getTypeName() == "boolean")
			return new CTBoolean(this.value.equals(((CTBoolean) another).isValue()));
		if (another.getTypeName() == "integer")
			return new CTBoolean(this.value.equals(((CTBoolean) another.convertTo("boolean")).isValue()));
		if (another.getTypeName() == "double")
			return new CTBoolean(this.value.equals(((CTBoolean) another.convertTo("boolean")).isValue()));
		if (another.getTypeName() == "string")
			return new CTBoolean(this.value.equals(((CTBoolean) another.convertTo("boolean")).isValue()));
		throw new CTDataUndefinedException();
	}

    @Override
	public boolean equals(Object other) {
        try {
            if (!(other instanceof CTValue)) {
                return false;
            }

            CTValue vOther = (CTValue) other;
            return this.equals(vOther).isValue();
        } catch (CTDataUndefinedException | CTConversionNotSupportedException e) {
            return false;
        }
    }

	@Override
	public CTInteger compareTo(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if (another.getTypeName() == "boolean")
			return new CTInteger(this.value.compareTo(((CTBoolean) another).isValue()));
		if (another.getTypeName() == "integer")
			return new CTInteger(this.value.compareTo(((CTBoolean) another.convertTo("boolean")).isValue()));
		if (another.getTypeName() == "double")
			return new CTInteger(this.value.compareTo(((CTBoolean) another.convertTo("boolean")).isValue()));
		if (another.getTypeName() == "string")
			return new CTInteger(this.value.compareTo(((CTBoolean) another.convertTo("boolean")).isValue()));
		throw new CTDataUndefinedException();
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}

	@Override
	public String getTypeName() {
		return "boolean";
	}

	@Override
	public CTValue convertTo(String newType) throws CTConversionNotSupportedException {
		if (newType == "boolean")
			return new CTBoolean(value);
		if (newType == "integer")
			return new CTInteger(value ? 1 : 0);
		if (newType == "double")
			return new CTDouble(value ? 1.0 : 0.0);
		if (newType == "string")
			return new CTString(toString());
		throw new CTConversionNotSupportedException(getTypeName(), newType);
	}

	@Override
	public CTValue add(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if(another.getTypeName()=="boolean")
			return this.convertTo("integer").add(another);
		if(another.getTypeName()=="integer")
			return another.add(this);
		if(another.getTypeName()=="double")
			return another.add(this);
		if(another.getTypeName()=="string")
			return this.convertTo("string").add(another);
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue subtract(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if(another.getTypeName()=="boolean")
			return this.convertTo("integer").subtract(another);
		if(another.getTypeName()=="integer")
			return another.subtract(this).negate();
		if(another.getTypeName()=="double")
			return another.subtract(this).negate();
		if(another.getTypeName()=="string")
			return another.subtract(this).negate();
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue negate() {
		return new CTBoolean(!value);
	}

	@Override
	public CTValue multiply(CTValue another) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}

	@Override
	public CTValue divide(CTValue another) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}

	@Override
	public CTValue mod(CTValue another) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}

	@Override
	public CTValue pow(CTValue another) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}

	@Override
	public CTValue shiftLeft(CTValue another) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}

	@Override
	public CTValue shiftRight(CTValue another) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}

	@Override
	public CTValue shiftRightArithmetic(CTValue another) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}

	@Override
	public CTValue and(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue or(CTValue another) throws CTDataUndefinedException {
		if (another.getTypeName() == "boolean")
			return new CTBoolean(this.value || ((CTBoolean) another).isValue());
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue not() {
		return new CTBoolean(!value);
	}

}
