package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

public class MultiplyOperator extends AbstractBinaryOperator {

	public MultiplyOperator(Expression operand1, Expression operand2) {
		super(operand1, operand2);
	}

	public MultiplyOperator(List<Expression> operands) {
		super(operands);
	}

	@Override
	CTValue operate(CTValue value1, CTValue value2) 
			throws CTDataUndefinedException, CTConversionNotSupportedException {
		// TODO Auto-generated method stub
		return value1.multiply(value2);
	}

}
