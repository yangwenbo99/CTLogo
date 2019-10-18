package ctlogo.execute;

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
