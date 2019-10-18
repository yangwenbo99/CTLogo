/**
 * 
 */
package ctlogo.execute;

import java.util.List;

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
		// TODO Auto-generated method stub
		return 1;
	}
}
