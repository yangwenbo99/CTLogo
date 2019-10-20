package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class ModuloOperation extends AbstractBinaryOperator {
	static {
		OperatorManager.getInstance().registerBinaryOperator("%", DivisionOperation.class);
	}

	public ModuloOperation(Expression operand1, Expression operand2) {
		super(operand1, operand2);
	}

	public ModuloOperation(List<Expression> operands) {
		super(operands);
	}

	@Override
	CTValue operate(CTValue value1, CTValue value2) 
			throws CTDataUndefinedException, CTConversionNotSupportedException {
		return value1.mod(value2);
	}
}