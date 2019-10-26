/**
 * 
 */
package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

/**
 * Stub class for testing purpose. 
 *
 * @author Paul Yang
 *
 */
public class DummyUnaryOperator extends AbstractUnaryOperator {

	/**
	 * @param operand
	 */
	public DummyUnaryOperator(Expression operand) {
		super(operand);
	}

	/**
	 * @param operands
	 */
	public DummyUnaryOperator(List<Expression> operands) {
		super(operands);
	}

	@Override
	CTValue operate(CTValue value) throws CTDataUndefinedException, CTConversionNotSupportedException {
		return value;
	}

}
