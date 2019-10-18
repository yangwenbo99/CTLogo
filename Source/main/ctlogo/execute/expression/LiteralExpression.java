package ctlogo.execute.expression;

import ctlogo.data.CTValue;
import ctlogo.execute.Context;

public class LiteralExpression implements Expression {
	private CTValue value;

	public LiteralExpression(CTValue value) {
		this.value = value;
	}

	@Override
	public CTValue execute(Context context) {
		return value;
	}

}
