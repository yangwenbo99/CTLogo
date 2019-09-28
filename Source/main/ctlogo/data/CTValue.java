package ctlogo.data;

public interface CTValue {
	public CTValue equals(CTValue another) throws Exception;
	public CTValue compareTo(CTValue another);
	public String toString();
	public String getTypeName(CTValue another);
	public CTValue convertTo(String newType);
	
	public CTValue add(CTValue another);
	public CTValue subtract(CTValue another);
	public CTValue negate(CTValue another);
	public CTValue multiply(CTValue another);
	public CTValue divide(CTValue another);
	public CTValue mod(CTValue another);
	public CTValue pow(CTValue another);
	
	public CTValue shiftLeft(CTValue another);
	public CTValue shiftRight(CTValue another);
	public CTValue shiftRightArithmetic(CTValue another);

	public CTValue and(CTValue another);
	public CTValue or(CTValue another);
	public CTValue not(CTValue another);
}
