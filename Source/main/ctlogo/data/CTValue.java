package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public interface CTValue {
	public CTBoolean equals(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException;
	public CTInteger compareTo(CTValue another) throws CTDataUndefinedException, CTConversionNotSupportedException;
	public String toString();
	public String getTypeName();
	public CTValue convertTo(String newType) throws CTDataUndefinedException, CTConversionNotSupportedException;
	
	public CTValue add(CTValue another) throws CTDataUndefinedException;
	public CTValue subtract(CTValue another) throws CTDataUndefinedException;
	public CTValue negate() throws CTDataUndefinedException, CTConversionNotSupportedException;
	public CTValue multiply(CTValue another) throws CTDataUndefinedException;
	public CTValue divide(CTValue another) throws CTDataUndefinedException;
	public CTValue mod(CTValue another) throws CTDataUndefinedException;
	public CTValue pow(CTValue another) throws CTDataUndefinedException;
	
	public CTValue shiftLeft(CTValue another) throws CTDataUndefinedException;
	public CTValue shiftRight(CTValue another) throws CTDataUndefinedException;
	public CTValue shiftRightArithmetic(CTValue another) throws Exception;

	public CTValue and(CTValue another) throws CTDataUndefinedException;
	public CTValue or(CTValue another) throws CTDataUndefinedException;
	public CTValue not() throws CTDataUndefinedException;
}
