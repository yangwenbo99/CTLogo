package ctlogo.data;

public class CTUndefined implements CTValue{
	
	@Override
	public CTValue equals(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue compareTo(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public String toString() {
		return "undefined";
	}

	@Override
	public String getTypeName(CTValue another) {
		return "undefined";
	}

	@Override
	public CTValue convertTo(String newType) {
		return new CTUndefined();
	}

	@Override
	public CTValue add(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue subtract(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue negate(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue multiply(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue divide(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue mod(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue pow(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue shiftLeft(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue shiftRight(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue shiftRightArithmetic(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue and(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue or(CTValue another) {
		return new CTUndefined();
	}

	@Override
	public CTValue not(CTValue another) {
		return new CTUndefined();
	}

}
