package ctlogo.data;

public class CTString implements CTValue {
	private String value;

	public CTString(String string) {
		this.value = string;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public CTValue equals(CTValue another) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("Undefined cannot equal");
	}

	@Override
	public CTValue compareTo(CTValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String getTypeName(CTValue another) {
		// TODO Auto-generated method stub
		return "string";
	}

	@Override
	public CTValue convertTo(String newType) {
		if (newType == "boolean")
			return new CTBoolean(!(value.equals("")));
		if (newType == "integer")
//			TODO parseInt
//			return new CTInteger((int)value);
		if (newType == "double")
//			return new CTDouble(value);
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
