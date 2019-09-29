package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class CTInteger implements CTValue {
	private Integer value;

	public CTInteger(Integer i) {
		value = i;
	}

	private Integer getValue() {
		return value;
	}

	private void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public CTBoolean equals(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if (another.getTypeName() == "boolean")
			return another.equals(this);
		if (another.getTypeName() == "integer")
			return new CTBoolean(this.value.equals(((CTInteger) another).getValue()));
		if (another.getTypeName() == "double")
			return another.equals(this);
		if (another.getTypeName() == "string")
			return this.equals(((CTDouble) another.convertTo("double")));
		throw new CTDataUndefinedException();
	}

	@Override
	public CTInteger compareTo(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if (another.getTypeName() == "boolean")
			return (CTInteger) another.compareTo(this).negate();
		if (another.getTypeName() == "integer")
			return new CTInteger(this.value.compareTo(((CTInteger) another).getValue()));
		if (another.getTypeName() == "double")
			return (CTInteger) another.compareTo(this).negate();
		if (another.getTypeName() == "string")
			return this.compareTo(((CTDouble) another.convertTo("double")));
		throw new CTDataUndefinedException();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(value);
	}

	@Override
	public String getTypeName() {
		// TODO Auto-generated method stub
		return "integer";
	}

	@Override
	public CTValue convertTo(String newType) throws CTConversionNotSupportedException {
		if (newType == "boolean")
			return new CTBoolean(new Boolean(value > 0));
		if (newType == "integer")
			return new CTInteger(new Integer(value));
		if (newType == "double")
			return new CTDouble(new Double(value));
		if (newType == "string")
			return new CTString(toString());
		throw new CTConversionNotSupportedException(getTypeName(), newType);
	}

	@Override
	public CTValue add(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		// TODO overflow exception
		if(another.getTypeName()=="boolean")
			return new CTInteger(value + ((CTInteger) another.convertTo("integer")).getValue());
		if(another.getTypeName()=="integer")
			return new CTInteger(value + ((CTInteger) another).getValue());
		if(another.getTypeName()=="double")
			return another.add(this);
		if(another.getTypeName()=="string")
			return this.convertTo("string").add(another);
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue subtract(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException {
		if(another.getTypeName()=="boolean")
			return new CTInteger(value - ((CTInteger) another.convertTo("integer")).getValue());
		if(another.getTypeName()=="integer")
			return new CTInteger(value - ((CTInteger) another).getValue());
		if(another.getTypeName()=="double")
			return another.subtract(this).negate();
		if(another.getTypeName()=="string")
			return another.subtract(this).negate();
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue negate() {
		return new CTInteger(-value);
	}

	@Override
	public CTValue multiply(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue divide(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue mod(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue pow(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue shiftLeft(CTValue another) {
		// TODO Auto-generated method stub
		return null;
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
