package ctlogo.execute.expression;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;
import ctlogo.exception.CTException;
import ctlogo.execute.Context;

public abstract class AbstractBinaryOperator implements Expression {
	private Expression operand1;
	private Expression operand2;

	public AbstractBinaryOperator(
			Expression operand1, Expression operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	/**
	 * 
	 * @param operands
	 * 
	 * @throws IllegalArgumentException if incorrect side of operands
	 */
	public AbstractBinaryOperator(
			List<Expression> operands) {
		if (operands.size() != 2)
			throw new IllegalArgumentException(
					"Binary operator accepts exactly 2 operators");
		this.operand1 = operands.get(0);
		this.operand2 = operands.get(1);
	}

	@Override
	public CTValue execute(Context context) throws CTException {
		// TODO Auto-generated method stub
		return operate(
				operand1.execute(context),
				operand2.execute(context));
	}

	protected Expression getOperand1() {
		return operand1;
	}

	protected Expression getOperand2() {
		return operand2;
	}
	
	abstract CTValue operate(CTValue value1, CTValue value2) throws CTDataUndefinedException, CTConversionNotSupportedException;
}
