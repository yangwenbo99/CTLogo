package ctlogo.execute;

import ctlogo.execute.expression.Expression;

class RPNBinaryOperation extends RPNOperation {

	public RPNBinaryOperation(Class<? extends Expression> operator) {
		super(operator);
	}

	@Override
	public int getParameterNumber() {
		// TODO Auto-generated method stub
		return 2;
	}

}
