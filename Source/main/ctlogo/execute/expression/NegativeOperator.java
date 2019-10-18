package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class NegativeOperator extends AbstractUnaryOperator {

	public NegativeOperator(Expression operand) {
		super(operand);
	}

	public NegativeOperator(List<Expression> operands) {
		super(operands);
	}

	@Override
	CTValue operate(CTValue value) 
			throws CTDataUndefinedException, CTConversionNotSupportedException {
		return value.negate();
	}

}
