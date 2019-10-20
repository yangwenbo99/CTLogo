package ctlogo.execute.rpn;

import ctlogo.execute.expression.Expression;

class RPNBinaryOperation extends RPNOperation {

	public RPNBinaryOperation(Class<? extends Expression> operator) {
		super(operator);
	}

	@Override
	public int getParameterNumber() {
		return 2;
	}

}
