package ctlogo.data;

public class CTDouble implements CTValue {
	private double value;

	public CTDouble(double d) {
		this.value = d;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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
		return Double.toString(value);
	}

	@Override
	public String getTypeName(CTValue another) {
		// TODO Auto-generated method stub
		return "double";
	}

	@Override
	public CTValue convertTo(String newType) {
		if (newType == "boolean")
			return new CTBoolean(value > 0);
		if (newType == "integer")
			return new CTInteger((int)value);
		if (newType == "double")
			return new CTDouble(value);
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
