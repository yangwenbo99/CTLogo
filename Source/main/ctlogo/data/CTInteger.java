package ctlogo.data;

public class CTInteger implements CTValue {
	private int value;

	public CTInteger(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public CTValue equals(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CTValue compareTo(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(value);
	}

	@Override
	public String getTypeName(CTValue another) {
		// TODO Auto-generated method stub
		return "integer";
	}

	@Override
	public CTValue convertTo(String newType) {
		if (newType == "boolean")
			return new CTBoolean(value > 0);
		if (newType == "integer")
			return new CTInteger(value);
		if (newType == "double")
			return new CTDouble(new Double(value));
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
		return null;
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
	public CTValue shiftRightArithmetic(CTValue another) {
		// TODO Auto-generated method stub
		return null;
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
