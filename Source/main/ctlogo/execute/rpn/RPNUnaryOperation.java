/**
 * 
 */
package ctlogo.execute.rpn;

import ctlogo.execute.expression.Expression;

/**
 * @author Paul Yang
 *
 */
class RPNUnaryOperation extends RPNOperation {
	
	public RPNUnaryOperation(Class<? extends Expression> operator) {
		super(operator);
	}

	@Override
	public int getParameterNumber() {
		return 1;
	}
}
