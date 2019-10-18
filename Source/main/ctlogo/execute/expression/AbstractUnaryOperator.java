package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;
import ctlogo.execute.Context;

public abstract class AbstractUnaryOperator implements Expression {
	private Expression operand;

	public AbstractUnaryOperator(Expression operand) {
		this.operand = operand;
	}

	/**
	 * 
	 * @param operands
	 * 
	 * @throws IllegalArgumentException if incorrect side of operands
	 */
	public AbstractUnaryOperator(
			List<Expression> operands) {
		if (operands.size() != 1)
			throw new IllegalArgumentException(
					"Unary operator accepts exactly 1 operator");
		this.operand = operands.get(0);
	}

	@Override
	public CTValue execute(Context context) 
			throws CTDataUndefinedException, CTConversionNotSupportedException {
		return operate(operand.execute(context));
	}

	protected Expression getOperand() {
		return operand;
	}

	abstract CTValue operate(CTValue value)
			throws CTDataUndefinedException, CTConversionNotSupportedException;
}
