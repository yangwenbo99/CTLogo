package ctlogo.data;

public class CTBoolean implements CTValue {
	private boolean value;

	public CTBoolean(boolean value) {
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public CTValue equals(CTValue another) {
		return null;
	}

	@Override
	public CTValue compareTo(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}

	@Override
	public String getTypeName(CTValue another) {
		// TODO Auto-generated method stub
		return "boolean";
	}

	@Override
	public CTValue convertTo(String newType) {
		if (newType == "boolean")
			return new CTBoolean(value);
		if (newType == "integer")
			return new CTInteger(0);
		if (newType == "double")
			return new CTDouble(0.0);
		if (newType == "string")
			return new CTString(toString());
		return new CTUndefined();
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
	public CTValue negate(CTValue another) {
		// TODO Auto-generated method stub
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
	public CTValue or(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue not(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

}
