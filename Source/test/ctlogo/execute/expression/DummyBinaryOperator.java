package ctlogo.execute.expression;

import ctlogo.data.CTValue;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.exception.CTDataUndefinedException;

import java.util.*;

/**
 * Stub class for testing purpose. 
 *
 * @author Paul Yang
 */
public class DummyBinaryOperator extends AbstractBinaryOperator {

	public DummyBinaryOperator(Expression operand1, Expression operand2) {
		super(operand1, operand2);
	}

	public DummyBinaryOperator(List<Expression> operands) {
		super(operands);
	}

    @Override
    CTValue operate(CTValue value1, CTValue value2) throws CTDataUndefinedException, CTConversionNotSupportedException {
        return value1;
    }

}