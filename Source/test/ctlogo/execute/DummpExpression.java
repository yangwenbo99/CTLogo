package ctlogo.execute;

import java.util.List;

import ctlogo.data.CTUndefined;
import ctlogo.data.CTValue;

public class DummpExpression implements Expression {
	
	private int operandNum = 0;

	public DummpExpression() {
		operandNum = 0;
	}

	public DummpExpression(int op) {
		operandNum = op;
	}


	public DummpExpression(Expression exp1) {
		operandNum = 1;
	}

	public DummpExpression(Expression exp1, Expression exp2) {
		operandNum = 2;
	}

	public DummpExpression(List<Expression> exp) {
		operandNum = exp.size();
	}

	@Override
	public CTValue execute(Context context) {
		// TODO Auto-generated method stub
		return new CTUndefined();
	}
	
	public String toString() {
		return String.format("DummyExpression with %d operand(s)", operandNum);
	}
	
	public boolean equals(Object other) {
		if (!(other instanceof DummpExpression))
			return false;
		
		DummpExpression cOther = (DummpExpression) other;
		return this.operandNum == cOther.operandNum;
	}

}
