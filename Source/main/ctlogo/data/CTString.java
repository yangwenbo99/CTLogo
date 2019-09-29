package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class CTString implements CTValue {
	private String value;

	public CTString(String string) {
		this.value = string;
	}

	private String getValue() {
		return value;
	}

	private void setValue(String value) {
		this.value = value;
	}

	@Override
	public CTBoolean equals(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if (another.getTypeName() == "boolean")
			return another.equals(this);
		if (another.getTypeName() == "integer")
			return another.equals(this);
		if (another.getTypeName() == "double")
			return another.equals(this);
		if (another.getTypeName() == "string")
			return new CTBoolean(this.value.equals(((CTString) another).getValue()));
		throw new CTDataUndefinedException();
	}

	@Override
	public CTInteger compareTo(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if (another.getTypeName() == "boolean")
			return (CTInteger) another.compareTo(this).negate();
		if (another.getTypeName() == "integer")
			return (CTInteger) another.compareTo(this).negate();
		if (another.getTypeName() == "double")
			return (CTInteger) another.compareTo(this).negate();
		if (another.getTypeName() == "string")
			return new CTInteger(this.value.compareTo(((CTString) another).getValue()));
		throw new CTDataUndefinedException();
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public String getTypeName() {
		return "string";
	}

	@Override
	public CTValue convertTo(String newType) throws CTConversionNotSupportedException {
		if (newType == "boolean")
			return new CTBoolean(!(value.equals("")));
		if (newType == "integer") {
			try {
				return new CTInteger(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new CTConversionNotSupportedException(getTypeName(), newType);
			}
		}
		if (newType == "double") {
			try {
				return new CTDouble(Double.parseDouble(value));
			} catch (NumberFormatException e) {
				throw new CTConversionNotSupportedException(getTypeName(), newType);
			}
		}
		if (newType == "string")
			return new CTString(toString());
		throw new CTConversionNotSupportedException(getTypeName(), newType);
	}

	@Override
	public CTValue add(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue subtract(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue negate() throws CTDataUndefinedException, CTConversionNotSupportedException {
		try {
			return this.convertTo("integer").negate().convertTo("string");
		} catch (CTConversionNotSupportedException e) {
		}
		return this.convertTo("double").negate().convertTo("string");
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
		return null;
	}

	@Override
	public CTValue shiftRightArithmetic(CTValue another) throws Exception {
		// FIXME I don't know the functionality of this function
		throw new Exception("Functionality unknown");
	}

	@Override
	public CTValue and(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue or(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue not() {
		// TODO Auto-generated method stub
		return null;
	}

}
