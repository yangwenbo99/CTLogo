package ctlogo.execute.expression;

import ctlogo.data.CTValue;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;

public class VariableExpression implements Expression {
	
	private String vname;

	public VariableExpression(String vname) {
		super();
		this.vname = vname;
	}

	@Override
	public CTValue execute(Context context) throws CTException {
		return context.getValueOf(vname);
	}

}
