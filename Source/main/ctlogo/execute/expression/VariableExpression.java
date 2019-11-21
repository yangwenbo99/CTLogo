package ctlogo.execute.expression;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;

public class VariableExpression implements Expression {

	private CTValue value;

	@Override
	public CTValue execute(Context context) throws CTException {
		// TODO Auto-generated method stub
		return value;
	}

}
