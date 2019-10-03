package ctlogo.data;

import ctlogo.exception.CTDataUndefinedException;

public class CTUndefined implements CTValue {

	@Override
	public CTBoolean equals(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTInteger compareTo(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public String toString() {
		return "undefined";
	}

	@Override
	public String getTypeName() {
		return "undefined";
	}

	@Override
	public CTValue convertTo(String newType) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue add(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue subtract(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue negate() throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue multiply(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue divide(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue mod(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue pow(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue shiftLeft(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue shiftRight(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue shiftRightArithmetic(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue and(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue or(CTValue another) throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

	@Override
	public CTValue not() throws CTDataUndefinedException {
//		TODO make exception message specific by mentioning which data is undefined
		throw new CTDataUndefinedException();
	}

}
