package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class ModuloOperator extends AbstractBinaryOperator {

	public ModuloOperator(Expression operand1, Expression operand2) {
		super(operand1, operand2);
	}

	public ModuloOperator(List<Expression> operands) {
		super(operands);
	}

	@Override
	CTValue operate(CTValue value1, CTValue value2) 
			throws CTDataUndefinedException, CTConversionNotSupportedException {
		return value1.mod(value2);
	}
}
