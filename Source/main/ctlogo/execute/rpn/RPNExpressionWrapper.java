package ctlogo.execute.rpn;

import ctlogo.execute.expression.Expression;

public class RPNExpressionWrapper implements RPNEvaluable {
	
	private Expression exp;

	public RPNExpressionWrapper(Expression exp) {
		this.exp = exp;
	}

	@Override
	public Expression getExpression() {
		return exp;
	}

}
