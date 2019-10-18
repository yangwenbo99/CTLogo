package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;

public class PositiveOperator extends AbstractUnaryOperator {

	public PositiveOperator(Expression operand) {
		super(operand);
	}

	public PositiveOperator(List<Expression> operands) {
		super(operands);
	}

	@Override
	CTValue operate(CTValue value) {
		return value;
	}

}
